package com.ja.barom.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ja.barom.Vo.CaseConfirmedVo;
import com.ja.barom.Vo.DefendantCaseVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DefenseVo;
import com.ja.barom.Vo.QuestionVo;
import com.ja.barom.Vo.SubmitListVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.commons.MailSenderThread;
import com.ja.barom.commons.MessageDigestUtil;
import com.ja.barom.document.mapper.DocumentSQLMapper;
import com.ja.barom.user.service.UserService;

@RestController
@RequestMapping("/user/*")
public class RestUserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping("getUserInfoByUserNo")
	public HashMap<String, Object> getUserInfoByUserNo (int userNo) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		HashMap<String, Object> userData = userService.getUserInfoByUserNo(userNo);  // Test 나중에 수정 할 것
		
		data.put("userData", userData);
		
		return data;
	}
	
	@RequestMapping("updateUserInfoByUserNo")
	public HashMap<String, Object> updateUserInfoByUserNo (UserVo vo, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		vo.setUser_no(sessionUser.getUser_no());
		
		userService.updateUserInfoByUserNo(vo);
		
		return data;
	}
	
	@RequestMapping("deleteUserInfoByUserNo") // 파라미터 user_no 넣을 것 
	public HashMap<String, Object> deleteUserInfoByUserNo (UserVo vo, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		String password = vo.getUser_pw();
		password = MessageDigestUtil.getPasswordHashCode(password);
		vo.setUser_pw(password);
		
		System.out.println("@@" +vo.getUser_pw());
		System.out.println("@@" +sessionUser.getUser_pw());
		
		if (sessionUser.getUser_pw().equals(vo.getUser_pw())) {
			
			
			userService.deleteUserInfoByUserNo(sessionUser);
			session.invalidate();
			data.put("result", "success");
		} else {
			data.put("result", "fail");
		}
		
		return data;
	}
	
	@RequestMapping("recoveryUserByInfo")
	public HashMap<String, Object> recoveryUserByInfo (UserVo vo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		
		int checkUser = userService.checkUser(vo);
        
        if ( checkUser == 1 ) {
        	userService.recoveryUserByInfo(vo);
			data.put("result", "success");
		} else {
			data.put("result", "fail");
		}
		
		return data;
	}
	
	@RequestMapping("userLoginProcess")
	public HashMap<String, Object> userLoginProcess(HttpServletRequest request ,UserVo vo) {
				
		HttpSession session = request.getSession();
		HashMap<String, Object> data = new HashMap<String, Object>();		
		UserVo sessionUser = userService.getUserByIdAndPw(vo);
		
		System.out.println();
		
		if(sessionUser != null) {	
			session.setMaxInactiveInterval(1800);
			session.setAttribute("sessionUser", sessionUser);
			data.put("result", "success");	
			String state = sessionUser.getUser_state();
			if(state.equals("Inactive")) {				
				data.put("result", "out");
			}
		} else {
			data.put("result", "fail");				
		}				
		
		
		
		return data;
	}
	
	@RequestMapping("logoutUserPorcess")
	public HashMap<String, Object> logoutUserPorcess (HttpServletRequest request) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		
		request.getSession().invalidate();
		request.getSession(true);
	
		return data;
	}
	
	@RequestMapping("getUserIdByNameAndJumin2")
	public HashMap<String, Object> getUserIdByNameAndJumin2 (UserVo vo) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		HashMap<String, Object> userInfo = userService.getUserIdByNameAndJumin2(vo);
		
		if (userInfo == null) {
			data.put("result", "fail");
		} else {
			data.put("result", "success");
			data.put("userInfo", userInfo);
		}
		
		return data;
	}
	
	
	//비밀번호찾기 질문조회
	@RequestMapping("getUserQuestionById")
	public HashMap<String, Object> getUserQuestionById (UserVo vo) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		HashMap<String, Object> userInfo = userService.getUserQquestionById(vo);
		
		if (userInfo == null) {
			data.put("result", "fail");
		} else {
			data.put("result", "success");
			data.put("userInfo", userInfo);
		}
		
		return data;
	}
	
	//비밀번호 찾기
		@RequestMapping("getUserPwByfindAnswer")
		public HashMap<String, Object> getUserPwByfindAnswer (UserVo vo)throws Exception{
			
			HashMap<String, Object> data = new HashMap<String, Object>();			
			UserVo userInfo = userService.getUserPwByfindAnswer(vo);			
			System.out.println("@@" + vo.getUser_id());
			System.out.println("@@"+ vo.getUser_findAnswer());
				
			if (userInfo == null) {		
				data.put("result", "fail");
			} else {
	            String pw = userInfo.getUser_pw();
	            String email = userInfo.getUser_email();
	            String name = userInfo.getUser_name();
				
				System.out.println("@@" + pw);
				System.out.println("@@" + email);
				data.put("result", "success");
				
				Random random = new Random();
		        int checkNum = random.nextInt(888888) + 111111;
		        
		        
		        String setFrom = "";
		        String toMail = email;
		        String title = "임시비밀번호 발급 메일입니다.";
		        String content = 
		                "전자소송 홈페이지를 방문해주셔서 감사합니다." +
		                "<br><br>" + 
		                name + "님의 임시비밀번호는 " + checkNum + "입니다." + 
		                "<br>" + 
		                "로그인 후 비밀번호를 반드시 변경해주세요.";
		        String num = "";
			    
			        num = Integer.toString(checkNum);			        
			        vo.setUser_pw(num);
			        String password = vo.getUser_pw();
					password = MessageDigestUtil.getPasswordHashCode(password);
					vo.setUser_pw(password);
			        userService.getUserUpdatePw(vo);
			        
			        MailSenderThread mst = new MailSenderThread(javaMailSender,toMail,content,title,setFrom);
			 					mst.start(); 		 			   
				}
			
			return data;
		}
	
	@RequestMapping("checkSession")
	public HashMap<String, Object> checkSession (HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo)session.getAttribute("sessionUser");
		
		if(sessionUser == null) {
			data.put("result", "fail");
		} else {
			data.put("result", "success");
			data.put("sessionUser", sessionUser);
		}
		
		return data;
	}
	
	@RequestMapping("getQuestionList")
	public HashMap<String, Object> getQuestionList () {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		ArrayList<QuestionVo> questionList = userService.getJoinQuestionList();
		
		data.put("questionList", questionList);
		
		return data;
	}
	
	@RequestMapping("checkId")
	public HashMap<String, Object> checkId (String user_id) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		int Count = userService.checkId(user_id);
		
		if ( Count == 0 ) {
			data.put("result", "success");
		} else {
			data.put("result", "fail");
		}
		
		return data;
	}
	
	@RequestMapping("mailCheck")
	   public String mailCheck(String userEmail) throws Exception{
	            
	        Random random = new Random();
	        int checkNum = random.nextInt(888888) + 111111;
	               
	        String setFrom = "";
	        String toMail = userEmail;
	        String title = "회원가입 인증 이메일 입니다.";
	        String content = 
	                "전자소송 홈페이지를 방문해주셔서 감사합니다." +
	                "<br><br>" + 
	                "인증 번호는 " + checkNum + "입니다." + 
	                "<br>" + 
	                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
	        String num = "";
	         
	           num = Integer.toString(checkNum);
	           
	           MailSenderThread mst = new MailSenderThread(javaMailSender,toMail,content,title,setFrom);
	            mst.start(); 
	             
	            
	       
	       return num;
	   }
	
	@RequestMapping("getMyCaseListProcess")
	public HashMap<String, Object> getMyCaseListProcess(@RequestBody @RequestParam HashMap<String, Object> param, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		System.out.println(param.get("docOption"));
		System.out.println(param.get("courtOption"));
		System.out.println(param.get("minDate"));
		System.out.println(param.get("maxDate"));
		System.out.println(param.get("caseNo"));
		
		param.put("userNo", sessionUser.getUser_no());
		
		ArrayList<HashMap<String, Object>> list = userService.getMyCaseList(param);
		
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("getMyCaseRefuseReason")
	public HashMap<String, Object> getMyCaseRefuseReason (String caseNo) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		System.out.println(caseNo);
		
		String reason = userService.getCaseRefuseReason(caseNo);
		
		data.put("reason", reason);
		
		return data;
		
	}
	
	//피고 사건 등록 관련
	@RequestMapping("getCaseConfirmedList")
	public HashMap<String, Object> getCaseConfirmedList (HttpSession session, int searchOption) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		ArrayList<HashMap<String, Object>> caseConfirmedList = userService.getCaseConfirmedList(sessionUser.getUser_no(), searchOption);
		
		data.put("caseConfirmedList", caseConfirmedList);
		
		return data;
	}
	
	@RequestMapping("registCaseConfirmed")
	public HashMap<String, Object> registCaseConfirmed (
			@RequestParam(value="case_confirmed_no") String caseConfirmedNo,
			@RequestParam(value="defendant_name") String defendantName,
			@RequestParam(value="defendant_zipcode") int defendantZipcode,
			@RequestParam(value="defendant_address") String defendantAddress,
			HttpSession session) 
	{
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		HashMap<String, Object> caseInfo = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		DefendantCaseVo dvo = new DefendantCaseVo();
		
		dvo.setUser_no(sessionUser.getUser_no());
		dvo.setCase_confirmed_no(caseConfirmedNo);
		
		caseInfo.put("userNo", sessionUser.getUser_no());
		caseInfo.put("caseConfirmedNo", caseConfirmedNo);
		caseInfo.put("defendantName", defendantName);
		caseInfo.put("defendantZipcode", defendantZipcode);
		caseInfo.put("defendantAddress", defendantAddress);
		
		int checkCase1 = userService.getCaseConfirmedCount(caseInfo); // caseconfirmed가 있는지 
		int checkCase2 = userService.getDefendantCaseCount(dvo); // 해당 정보의 피고가 사건등록에 있는지
		
		if (checkCase1 == 0) {
			data.put("result", "fail1");
			return data;
		} else if (checkCase2 == 1){
			data.put("result", "fail2");
			return data;
		} else {
			userService.insertCaseConfirmed(caseInfo);
			data.put("result", "success");
			return data;
		}
	}
	
	@RequestMapping("getRegistList")
	public HashMap<String, Object> getRegistList () {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		return data;
	}
	
	// 답변서 관련
	@RequestMapping("getWriteAnswerList")
	public HashMap<String, Object> getWriteAnswerList (HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		System.out.println("답변서 목록 불러오기");
		
		ArrayList<String> list = userService.getWriteAnswerList(sessionUser.getUser_no());
		
		
		System.out.println(list.size());
		
		data.put("result", "success");
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("getCaseConfirmedInfo")
	public HashMap<String, Object> getCaseConfirmedInfo (String confirmedNo) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		HashMap<String, Object> info = userService.getCaseConfirmed(confirmedNo);
		data.put("info", info);
		
		return data;
	}
	
	// 소송 취하, 합의 관련 
	@RequestMapping("getConfirmedList")
	public HashMap<String, Object> getConfirmedList (HttpSession session) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		
		ArrayList<String> list = userService.getConfirmedList(sessionUser.getUser_no());
		
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("updateConfirmedStatus")
	public HashMap<String, Object> updateConfirmedStatus (
			@RequestParam(value="confirmedNo") String confirmedNo,
			@RequestParam(value="concreteOption") String concreteOption) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		System.out.println("[답변서 업데이트]");
		System.out.println("사건번호 : "+confirmedNo);
		System.out.println("사건유형 : "+concreteOption);
		
		userService.updateConfirmedStatusAfter(concreteOption, confirmedNo);
		
		return data;
	}
	
	// 나의사건 현황 관련
	@RequestMapping("getMyAllCasePrif")
	public HashMap<String, Object> getMyAllCasePrif (@RequestBody @RequestParam HashMap<String, Object> param, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		param.put("userNo", sessionUser.getUser_no());
		
		System.out.println("원고 - " + param.get("statusOption"));
		System.out.println("원고 - " + param.get("answerOption"));
		System.out.println("원고 - " + param.get("courtOption"));
		System.out.println("원고 - " + param.get("minDate"));
		System.out.println("원고 - " + param.get("maxDate"));
		System.out.println("원고 - " + param.get("confirmedNo"));
		
		ArrayList<HashMap<String, Object>> list = userService.getMyAllCasePrif(param);
		
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("getMyAllCaseDef")
	public HashMap<String, Object> getMyAllCaseDef (@RequestBody @RequestParam HashMap<String, Object> param, HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		param.put("userNo", sessionUser.getUser_no());
		
		System.out.println("피고 - " + param.get("statusOption"));
		System.out.println("피고 - " + param.get("answerOption"));
		System.out.println("피고 - " + param.get("courtOption"));
		System.out.println("피고 - " + param.get("minDate"));
		System.out.println("피고 - " + param.get("maxDate"));
		System.out.println("피고 - " + param.get("confirmedNo"));
		
		
		ArrayList<HashMap<String, Object>> list = userService.getMyAllCaseDef(param);
		
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("getMyAllCaseSubOption")
	public HashMap<String, Object> getMyAllCaseSubOption (
			int personOption,
			int statusOption,
			int courtOption,
			int checkForm,
			Date minDate,
			Date maxDate,
			String confirmedNo,
			HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		param.put("statusOption", statusOption);
		param.put("courtOption", courtOption);
		param.put("checkForm", checkForm);
		param.put("minDate", minDate);
		param.put("maxDate", maxDate);
		param.put("confirmedNo", confirmedNo);
		param.put("userNo", sessionUser.getUser_no());
		
		ArrayList<HashMap<String, Object>> list = userService.getMyAllCaseSubOption(personOption, param);
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("test")
	public HashMap<String, Object> test (String id, String title, Date date) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		if ( id== null) {
			System.out.println("id = null");
		} else {
			System.out.println("id = " + id);
		}
		
		System.out.println(title);
		
		if ( date == null) {
			System.out.println("date = null");
		} else {
			System.out.println("date = " + date);
		}
		
		HashMap<String, Object> testmap = new HashMap<String, Object>();
		
		testmap.put("id", id);
		testmap.put("title", title);
		testmap.put("date", date);
		
		
		
		userService.testcode(id, title, testmap, date);
		
		return data;
	}
	
	
	
	
	
	
	
}
