package com.ja.barom.customer.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.ja.barom.Vo.AnncmFilesVo;
import com.ja.barom.Vo.AnnouncementVo;
import com.ja.barom.Vo.CustomerQuestionVo;
import com.ja.barom.Vo.FAQ_CategoryVo;
import com.ja.barom.Vo.FaqVo;
import com.ja.barom.Vo.QuestionLikeVo;
import com.ja.barom.Vo.ReppleLikeVo;
import com.ja.barom.Vo.ReppleVo;

public interface CustomerSQLMapper {

	public void insertQuestion(CustomerQuestionVo vo);	

	public ArrayList<CustomerQuestionVo> getQuestionList(); //1개의 행을 받을때는 단일 객체 리턴 , N개의 행을 받을때는 List로 받는다.
	
	public CustomerQuestionVo getQuestionByNo(int cus_question_no);
	
	public void increaseReadCount(int question_no);
	
	public void deleteQuestion(int cus_question_no);
	
	public void updateQuestion(CustomerQuestionVo vo);
	
	public ArrayList<ReppleVo> getReppleList();
	
	public ReppleVo getReppleByNo(int repple_no);
	
	public void deleteReppleContent(int no);
	
	public void updateRepple(ReppleVo vo);
	
	public void insertReppleContent(ReppleVo vo);
	
	
	//좋아요 T
	public void insertLike(QuestionLikeVo vo);
	public void deleteLike(QuestionLikeVo vo);
	public int getTotalLikeCount(int boardNo);
	public int getMyLikeCount(QuestionLikeVo vo);


	// 댓글 좋아요 T
	public ReppleLikeVo getReepleLikeByNo(int repple_no);
	public void insertReppleLike(ReppleLikeVo vo);
	public void deleteReppleLike(ReppleLikeVo vo);
	public int getTotalReppleLikeCount(int repple_no);
	public int getMyReppleLIkeCount(ReppleLikeVo vo);
	public ArrayList<ReppleLikeVo> getReepleLikeList(int repple_no);
	public int getReppleCount(int CUS_QUESTION_NO);
	public ArrayList<ReppleLikeVo> getReppleLikeList();
	
	
	
////공지사항 관련
	
	// (사용자-공통) 공지사항 목록을 조회한다
		public ArrayList<AnnouncementVo> getAnncmList();
	// (사용자-공통) 첨부파일 유무를 확인한다
		public int getCountIsExistAnncmFiles (int anncmNo);
	// (사용자-공통) 공지사항 상세 내용(파일, 첨부)을 조회한다 
		public AnnouncementVo getAnncmByNo(int anncmNo);
		public ArrayList<AnncmFilesVo> getAnncmFiles(int anncmNo);
	// (사용자-공통) 공지사항 조회수를 올린다
		public void increaseAnncmReadCount(int anncmNo);
	
		// 메인 페이지 공지
		public ArrayList<HashMap<String, Object>> getMainPageAnncm();
	
		
	//// 자주하는 질문
		
		// 	자주하는 질문 카테고리 조회
			public ArrayList<FAQ_CategoryVo> getFAQ_CategoryList();
			
			public FAQ_CategoryVo getFaq_category_no(int no);
			
		//  자주하는 질문 목록 조회
			public ArrayList<FaqVo> getFaqList();
							
		//  자주하는 질문 상세 내용 조회
			public FaqVo getFaqByNo(int faqNo);
	
		// 메인 페이지 자주하는질문
		public ArrayList<HashMap<String, Object>> getMainPageFAQ();
	
	
	
	
	
}