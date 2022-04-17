package com.ja.barom.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.barom.Vo.AdminVo;
import com.ja.barom.Vo.AnncmFilesVo;
import com.ja.barom.Vo.AnnouncementVo;
import com.ja.barom.Vo.CustomerQuestionVo;
import com.ja.barom.Vo.FAQ_CategoryVo;
import com.ja.barom.Vo.FaqVo;
import com.ja.barom.Vo.QuestionLikeVo;
import com.ja.barom.Vo.ReppleLikeVo;
import com.ja.barom.Vo.ReppleVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.customer.mapper.CustomerSQLMapper;
import com.ja.barom.user.mapper.UserSQLMapper;
@Service
public class CustomerService {

	@Autowired
	private CustomerSQLMapper customerSQLMapper;

	@Autowired
	private UserSQLMapper userSQLMapper;

	
	
	
	
////QnA 관련
	
	
	public void writeContent(CustomerQuestionVo vo) {
		customerSQLMapper.insertQuestion(vo);
	}


	public ArrayList<HashMap<String, Object>> getQuestionList() {
		
		ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>(); 
		
		ArrayList<CustomerQuestionVo> questionVoList = customerSQLMapper.getQuestionList(); //SELECT * FROM FP_Board ORDER BY board_no DESC
		
		for(CustomerQuestionVo questionVo : questionVoList) {
			
			int userNo = questionVo.getUser_no(); //작성자 번호...
			int totalLikeCount = getTotalLikeCount(questionVo.getCus_question_no());
			int totalReppleCount = getReppleCount(questionVo.getCus_question_no());
			UserVo userVo = userSQLMapper.getUserByNo(userNo); //SELECT * FROM FP_MEMBER WHERE member_no = #{no}
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("userVo", userVo);
			map.put("questionVo", questionVo);
			map.put("totalLikeCount", totalLikeCount);
			map.put("totalReppleCount", totalReppleCount);
			//현재 글이...지금시간 -3 시간 보다 클때...
			Date writeDate = questionVo.getCus_question_writedate();
			long writeTime = writeDate.getTime();
			
			long currentTime = System.currentTimeMillis();
			long targetTime = currentTime - 1000*60*60*3;
			
			if(writeTime > targetTime) {
				map.put("newKeyword", true);
			}
			
			
			
			
			dataList.add(map);
		}
		
		return dataList;
		
	}

	public HashMap<String, Object> getQuestion(int cus_question_no, HttpSession session) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		CustomerQuestionVo questionVo = customerSQLMapper.getQuestionByNo(cus_question_no);


		int userNo = questionVo.getUser_no();
		UserVo userVo = userSQLMapper.getUserByNo(userNo);
		AdminVo adminVo = (AdminVo) session.getAttribute("adminSession");


		map.put("userVo", userVo);
		map.put("questionVo", questionVo);
		map.put("adminVo", adminVo);

		return map;
	}

	public ArrayList<ReppleLikeVo> getReppleLikeList() {
		return customerSQLMapper.getReppleLikeList();
	}

	public void increaseReadCount(int question_no) {
		customerSQLMapper.increaseReadCount(question_no);
	}

	public void deleteBoard(int question_no) {
		// 예외.. 처리..

		customerSQLMapper.deleteQuestion(question_no);
	}

	public void updateBoard(CustomerQuestionVo vo) {
		customerSQLMapper.updateQuestion(vo);
	}

	public void reppleContent(ReppleVo vo) {
		customerSQLMapper.insertReppleContent(vo);
	}

	public HashMap<String, Object> getRepple(int repple_no) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		ReppleVo reppleVo = customerSQLMapper.getReppleByNo(repple_no);
		int userNo = reppleVo.getUser_no();
		UserVo UserVo = userSQLMapper.getUserByNo(userNo);
		ReppleLikeVo likeVo = customerSQLMapper.getReepleLikeByNo(repple_no);
		map.put("userVo", UserVo);
		map.put("reppleVo", reppleVo);
		map.put("likeVo", likeVo);
		return map;
	}

	public ArrayList<HashMap<String, Object>> getReppleList(HttpSession session) {

		ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();

		ArrayList<ReppleVo> reppleoList = customerSQLMapper.getReppleList();

		for (ReppleVo reppleVo : reppleoList) {

			int totalReppleLikeCount = getTotalReppleLikeCount(reppleVo.getRepple_no());
			int totalReppleCount = getReppleCount(reppleVo.getCus_question_no());
			AdminVo adminSession = (AdminVo) session.getAttribute("adminSession");

			int userNo = reppleVo.getUser_no(); // 작성자 번호...
			int boardNo = reppleVo.getCus_question_no();
			CustomerQuestionVo questionVo = customerSQLMapper.getQuestionByNo(boardNo);
			UserVo userVo = userSQLMapper.getUserByNo(userNo);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("userVo", userVo);
			map.put("reppleVo", reppleVo);
			map.put("questionVo", questionVo);
			map.put("totalReppleLikeCount", totalReppleLikeCount);
			map.put("totalReppleCount", totalReppleCount);
			
			map.put("adminVo", adminSession);
			
			ReppleLikeVo reppleLikeVo = new ReppleLikeVo();
			reppleLikeVo.setRepple_no(reppleVo.getRepple_no());
			reppleLikeVo.setUser_no(userNo);
			int myReppleLikeCount = getMyReppleLikeCount(reppleLikeVo);
			map.put("reppleLikeVo", reppleLikeVo);
			map.put("myReppleLikeCount", myReppleLikeCount);

			dataList.add(map);
		}

		return dataList;

	}

	public void updateRepple(ReppleVo vo) {
		customerSQLMapper.updateRepple(vo);
	}

	public void deleteRepple(int repple_no) {
		customerSQLMapper.deleteReppleContent(repple_no);
	}

	// 좋아요...취소...
	public void doLike(QuestionLikeVo vo) {

		int count = customerSQLMapper.getMyLikeCount(vo);

		if (count > 0) {
			customerSQLMapper.deleteLike(vo);
		} else {
			customerSQLMapper.insertLike(vo);
		}
	}

	public int getTotalLikeCount(int boardNo) {
		return customerSQLMapper.getTotalLikeCount(boardNo);
	}

	public int getMyLikeCount(QuestionLikeVo vo) {
		return customerSQLMapper.getMyLikeCount(vo);
	}
	
	public int getReppleCount(int question_no) {
		return customerSQLMapper.getReppleCount(question_no);
	}
	
	public void doReppleLike(ReppleLikeVo vo) {

		int count = customerSQLMapper.getMyReppleLIkeCount(vo);

		if (count > 0) {
			customerSQLMapper.deleteReppleLike(vo);
		} else {
			customerSQLMapper.insertReppleLike(vo);
		}
	}

	public int getTotalReppleLikeCount(int reppleNo) {
		return customerSQLMapper.getTotalReppleLikeCount(reppleNo);
	}

	public int getMyReppleLikeCount(ReppleLikeVo reppleVo) {
		return customerSQLMapper.getMyReppleLIkeCount(reppleVo);
	}
	
	public ArrayList<HashMap<String, Object>> getMainPageFaQ(){
		
		System.out.println("[System] 자주묻는 질문 목록 최신 4개 불러오기");
		ArrayList<HashMap<String, Object>> faqList = new ArrayList<HashMap<String,Object>>();
		faqList = customerSQLMapper.getMainPageFAQ();
		
		return faqList;
	}

	//// 공지사항 사용자 관련 
	
	
	//	(공통-사용자) 공지사항 목록 조회, 첨부파일 유무 확인
	public ArrayList<HashMap<String, Object>> getAnncmList() {
		
		ArrayList<HashMap<String, Object>> AnncmLines = new ArrayList<HashMap<String, Object>>();
		
			ArrayList<AnnouncementVo> AnncmVoList = customerSQLMapper.getAnncmList();
					
					for (AnnouncementVo announcementVo : AnncmVoList) {
						int anncmNo = announcementVo.getAnncm_no();
						int isExistFiles = customerSQLMapper.getCountIsExistAnncmFiles(anncmNo);

						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("announcementVo", announcementVo);
						map.put("isExistFiles", isExistFiles);
						AnncmLines.add(map);
					}

			return AnncmLines;
			
	}
	
	//	(공통-사용자) 공지사항 상세 내용 조회
	public HashMap<String, Object> getAnncm(int anncm_no){
		
			AnnouncementVo announcementVo =  customerSQLMapper.getAnncmByNo(anncm_no);
			ArrayList<AnncmFilesVo> anncmFilesVo = customerSQLMapper.getAnncmFiles(anncm_no);
		
			HashMap<String, Object> map = new HashMap<String, Object>();
					
					map.put("announcementVo", announcementVo);
					map.put("anncmFilesVo", anncmFilesVo);
		
		return map;
	}
	
	
	// (공통-사용자) 조회수를 올린다
	public void increaseAnncmReadCount(int anncm_no) {
			customerSQLMapper.increaseAnncmReadCount(anncm_no);
	}
	
	
	public ArrayList<HashMap<String, Object>> getMainPageAnncm(){
		
		System.out.println("[System] 메인 페이지 공지사항 최신 4개 불러오기");
		ArrayList<HashMap<String, Object>> anncmList = new ArrayList<HashMap<String,Object>>();
		anncmList = customerSQLMapper.getMainPageAnncm();
		
		return anncmList;
	}
	
	
////자주하는 질문 사용자 관련
	
	
	// 자주하는 질문 카테고리
	public ArrayList<FAQ_CategoryVo> getFAQ_CategoryList(){
		return customerSQLMapper.getFAQ_CategoryList();
	}
	
	
	
	// 자주하는 질문 목록
	public ArrayList<HashMap<String, Object>> getFaqList() {
		
		ArrayList<HashMap<String, Object>> faqlist = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<FaqVo> faqVoList = customerSQLMapper.getFaqList();
		
		for(FaqVo faqVo : faqVoList) {			
			
			int faq_category_no = faqVo.getFaq_category_no();
			FAQ_CategoryVo faq_categoryVo = customerSQLMapper.getFaq_category_no(faq_category_no);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("faq_categoryVo", faq_categoryVo);
			map.put("faqVo", faqVo);
			
			faqlist.add(map);
		}
		
		return faqlist;
		
	}
	
	// 자주하는 질문 상세
	
	public HashMap<String,Object> getFaq(int faq_no){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		FaqVo faqVo = customerSQLMapper.getFaqByNo(faq_no);
		
		map.put("faqVo", faqVo);
		
		return map;
		
	}
	
	
	
	
	
	
	
	
	
}