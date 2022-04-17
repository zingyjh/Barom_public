package com.ja.barom.customer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.barom.Vo.CustomerQuestionVo;
import com.ja.barom.Vo.QuestionLikeVo;
import com.ja.barom.Vo.ReppleLikeVo;
import com.ja.barom.Vo.ReppleVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.admin.service.SiteAdminService;
import com.ja.barom.customer.service.CustomerService;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	
	
////Q&A 관련
	
	
	/* Q&A 게시판 메인페이지 */

	@RequestMapping("mainPage")
	public String mainPage(Model model) {

		ArrayList<HashMap<String, Object>> dataList = customerService.getQuestionList();

		model.addAttribute("dataList", dataList);

		return "customer/mainPage";
	}

	/* Q&A 게시판 게시글 작성 페이지 */

	@RequestMapping("writeContentPage")
	public String writeContentPage() {
		return "customer/writeContentPage";
	}

	/* Q&A 게시판 게시글 작성 완료 프로세스 */

	@RequestMapping("writeContentProcess")
	public String writeContentProcess(CustomerQuestionVo param, HttpSession session) {

		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int userNo = sessionUser.getUser_no();
		param.setUser_no(userNo);

		customerService.writeContent(param);

		System.out.println(param.getCus_question_secret());

		return "redirect:./mainPage";
	}

	/* Q&A 게시판 게시글 상세 보기 */

	@RequestMapping("readContentPage")
	public String readContentPage(int cus_question_no, HttpServletResponse response, HttpServletRequest request,
			Model model, HttpSession session) {

		// 저장된 쿠키 불러오기
		Cookie cookies[] = request.getCookies();
		Map mapCookie = new HashMap();
		if (request.getCookies() != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie obj = cookies[i];
				mapCookie.put(obj.getName(), obj.getValue());
			}
		}

		String cookie_read_count = (String) mapCookie.get("read_count");
		String new_cookie_read_count = "|" + cus_question_no;
		if (StringUtils.indexOfIgnoreCase(cookie_read_count, new_cookie_read_count) == -1) {
			// 없을 경우 쿠키 생성
			Cookie cookie = new Cookie("read_count", cookie_read_count + new_cookie_read_count);
			// cookie.setMaxAge(1000); // 초단위
			response.addCookie(cookie);

			// 조회수 업데이트
			customerService.increaseReadCount(cus_question_no);
		}
		
		HashMap<String, Object> map = customerService.getQuestion(cus_question_no, session);
		model.addAttribute("date", map);

		ArrayList<HashMap<String, Object>> dataList = customerService.getReppleList(session);

		model.addAttribute("dataList", dataList);

		int totalLikeCount = customerService.getTotalLikeCount(cus_question_no);
		model.addAttribute("totalLikeCount", totalLikeCount);

		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		if (sessionUser != null) {
			// 로그인을 했을때...
			int userNo = sessionUser.getUser_no();
			QuestionLikeVo questionLikeVo = new QuestionLikeVo();
			questionLikeVo.setUser_no(userNo);
			questionLikeVo.setCus_question_no(cus_question_no);

			int myLikeCount = customerService.getMyLikeCount(questionLikeVo);
			model.addAttribute("myLikeCount", myLikeCount);
		}

		return "customer/readContentPage";
	}

	/* Q&A 게시판 게시글 삭제 */

	@RequestMapping("deleteContentProcess")
	public String deleteContentProcess(int cus_question_no) {

		customerService.deleteBoard(cus_question_no);

		return "redirect:./mainPage";
	}

	@RequestMapping("updateContentPage")
	public String updateContentPage(int cus_question_no, Model model, HttpSession session) {

		HashMap<String, Object> map = customerService.getQuestion(cus_question_no, session);
		model.addAttribute("data", map);

		return "customer/updateContentPage";
	}

	@RequestMapping("updateContentProcess")
	public String updateContentProcess(CustomerQuestionVo param) {

		customerService.updateBoard(param);

		return "redirect:./mainPage";
	}

	@RequestMapping("updateReppleContentPage")
	public String updateReppleContentPage(int repple_no, Model model) {

		HashMap<String, Object> map = customerService.getRepple(repple_no);

		model.addAttribute("data", map);

		return "customer/updateReppleContentPage";
	}

	@RequestMapping("updateReppleContentProcess")
	public String updateReppleContentProcess(ReppleVo param) {
		customerService.updateRepple(param);

		return "redirect:./readContentPage?cus_question_no=" + param.getCus_question_no();
	}

	@RequestMapping("reppleContentProcess")
	public String reppleContentProcess(ReppleVo param, HttpSession session) {
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int user_no = sessionUser.getUser_no();
		param.setUser_no(user_no);

		customerService.reppleContent(param);

		return "redirect:./readContentPage?cus_question_no=" + param.getCus_question_no();
	}

	@RequestMapping("deleteReppleContentProcess")
	public String deleteReppleContentProcess(ReppleVo param) {
		customerService.deleteRepple(param.getRepple_no());

		return "redirect:./readContentPage?cus_question_no=" + param.getCus_question_no();
	}

	@RequestMapping("likeProcess")
	public String likeProcess(QuestionLikeVo param, HttpSession session) {

		// 행위자 정보는 세션에서 꼭 뽑아오자...
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int userNo = sessionUser.getUser_no();
		param.setUser_no(userNo);

		customerService.doLike(param);
		return "redirect:./readContentPage?cus_question_no=" + param.getCus_question_no();
	}

	@RequestMapping("RepplelikeProces")
	public String RepplelikeProces(ReppleLikeVo param, HttpSession session, int repple_no, int cus_question_no) {

		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int userNo = sessionUser.getUser_no();
		param.setUser_no(userNo);
		param.setRepple_no(repple_no);

		customerService.doReppleLike(param);

		return "redirect:./readContentPage?cus_question_no=" + cus_question_no;
	}
	

   @RequestMapping("myQnAList")
   public String myQnAList(Model model) {

       ArrayList<HashMap<String, Object>> dataList = customerService.getQuestionList();

       model.addAttribute("dataList", dataList);

       return "customer/myQnAList";
   }

   @ResponseBody()
   @RequestMapping("checkSession")
   public HashMap<String, Object> checkSession(HttpSession session) {

       HashMap<String, Object> data = new HashMap<String, Object>();

       UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");

       if (sessionUser == null) {
           data.put("result", "fail");
       } else {
           data.put("result", "success");
           data.put("sessionUser", sessionUser);
       }

       return data;
   }
    
    
////FAQ 관련
   
   
  @Autowired
	SiteAdminService siteAdminService;
  

	/* FAQ 게시판 메인페이지 */

	@RequestMapping("faqPage")
	public String faqPage(Model model) {

		ArrayList<HashMap<String, Object>> faqList =  siteAdminService.getFaqList();
		
		model.addAttribute("faqList", faqList);	
		
		return "customer/faqPage";
	}
	
	/* FAQ 게시판 상세페이지 */
	@RequestMapping("faqContentPage")
	public String faqContentPage(int faq_no, Model model) {
		
		HashMap<String, Object> map = siteAdminService.getFaq(faq_no);
		model.addAttribute("faqdata", map);
		
		return "customer/faqContentPage";
	}


	//// 공지사항 관련
    


	// 공지사항 관련
	
 	@RequestMapping("cusAnncmList")
	public String cusAnncmList(Model model) {
		
			ArrayList<HashMap<String, Object>> AnncmLines = customerService.getAnncmList();
			
			model.addAttribute("AnncmLines", AnncmLines);
 		
		return "customer/cusAnncmList";
	}
	
	/// 공지사항 상세조회
	@RequestMapping("cusReadAnncm")
	public String readAnncm(int anncm_no, Model model) {
		
		// 조회수 증가
		customerService.increaseAnncmReadCount(anncm_no);
		
		HashMap<String, Object> map = customerService.getAnncm(anncm_no);
		model.addAttribute("AnncmDetails", map);
		
		return "customer/cusReadAnncm";
		
	}
	
	
	
    
    
    
    
    
    
    
    
    
    
}