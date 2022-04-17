package com.ja.barom.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ja.barom.Vo.CaseConfirmedVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DefenseProofFileVo;
import com.ja.barom.Vo.DefenseVo;
import com.ja.barom.Vo.Min_Sj_Court_CategoryVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.QuestionVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.commons.UploadFiles;
import com.ja.barom.document.service.DocumentService;
import com.ja.barom.user.service.UserService;

@RequestMapping("/user/*")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DocumentService documentService;
	
//	@RequestMapping("main")
//	public String main() {
//
//		return "/user/main";
//	}
	
	@RequestMapping("submitListPage")
	public String submitListPage(HttpSession session, Model model) {
		
		ArrayList<Min_Sj_Court_CategoryVo> courtList = documentService.getCourtCategory();
		model.addAttribute("courtList" , courtList);
		
		return "/user/submitListPage";
	}
	
	@RequestMapping("userInfoPage")
	public String userInfoPage(Model model) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		ArrayList<QuestionVo> list = userService.getJoinQuestionList();
		
		data.put("list", list);
		
		model.addAttribute("data", data);
		
		return "/user/userInfoPage";
	}
	
	@RequestMapping("userAgree")
	public String userAgree() {
		
		return "user/userAgree";
	}
	
	@RequestMapping("joinUserPage")
	public String joinUserPage(Model model) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		ArrayList<QuestionVo> list = userService.getJoinQuestionList();
		
		data.put("list", list);
		
		model.addAttribute("data", data);
		
		return "/user/joinUserPage";
	}
	
	@RequestMapping("insertUserProcess")
	public String insertUserProcess (UserVo vo) {
		
		userService.insertUser(vo);
		
		return "redirect:http://barom.s001lec.com:8080/";
	}
	
	@RequestMapping("userRecoveryPage")
	public String userRecoveryPage() {
		
		return "/user/userRecoveryPage";
	}
	
	
	@RequestMapping("findUserInfoPage")
	public String findUserInfoPage () {
		
		return "/user/findUserInfoPage";
	}
	
	@RequestMapping("registCasePage")
	public String registCasePage () {
		
		return "/user/registCasePage";
	}
	
	@RequestMapping("answerDocListPage")
	public String answerDocListPage (Model model) {
		
		ArrayList<Min_Sj_Court_CategoryVo> courtList = documentService.getCourtCategory();
		model.addAttribute("courtList" , courtList);
		
		return "/user/answerDocListPage";
	}
	
	@RequestMapping("writeAnswerPage")
	public String writeAnswerPage (String confirmedNo, HttpSession session) {
		System.out.println("답변서 페이지 접속 + " + confirmedNo);
		if ( confirmedNo != null ) {
			
			System.out.println("답변서 번호" + confirmedNo);
			session.setAttribute("confirmedNo", confirmedNo);
			
		}
		
		return "/user/writeAnswerPage";
	}
	
	@RequestMapping("writeAnswerProcess")
	public String writeAnswerProcess (DefenseVo vo, HttpSession session, MultipartFile[] uploadFiles) throws IOException {
		
		System.out.println(vo.getCase_confirmed_no() + "번 사건에 답변서를 저장합니다.");
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		vo.setUser_no(sessionUser.getUser_no());
		ArrayList<DefenseProofFileVo> fileList = new ArrayList<DefenseProofFileVo>();
		
		if ( session.getAttribute("confirmedNo") != null ) {
			
			String confirmedNo = (String) session.getAttribute("confirmedNo");
			vo.setCase_confirmed_no(confirmedNo);
			System.out.println("파라미터로 생성된 No" + confirmedNo);
			
		}
		
		if(uploadFiles != null) {
			fileList = UploadFiles.uploadDefenseProofFilesToFolder(uploadFiles);
		}
		System.out.println(uploadFiles.length);
		System.out.println(fileList.size());
		
		int defenseNo = userService.insertAnswer(vo, sessionUser, fileList);
		userService.insertDefenseProofFiles(defenseNo, fileList);
		userService.updateConfirmedStatusAfterAnswer(vo.getCase_confirmed_no());
		
		return "redirect:../user/writeAnswerSucessPage";
	}
	
	@RequestMapping("writeAnswerSucessPage")
	public String writeAnswerSucessPage () {
		
		return "/user/writeAnswerSucessPage";
	}
	
	@RequestMapping("withdrawPage")
	public String withdrawPage() {
		
		return "/user/withdrawPage";
	}
	
	@RequestMapping("myCasePage")
	public String myCasePage (Model model) {
		
		ArrayList<Min_Sj_Court_CategoryVo> courtList = documentService.getCourtCategory();
		model.addAttribute("courtList" , courtList);
		
		return "/user/myCasePage";
	}
	
	
}
