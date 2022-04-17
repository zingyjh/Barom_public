package com.ja.barom.admin.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;

import com.ja.barom.Vo.AdminVo;
import com.ja.barom.Vo.AnncmFilesVo;
import com.ja.barom.Vo.AnnouncementVo;
import com.ja.barom.Vo.FAQ_CategoryVo;
import com.ja.barom.Vo.FaqVo;
import com.ja.barom.Vo.QuestionLikeVo;
import com.ja.barom.Vo.ReppleVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.admin.service.SiteAdminService;
import com.ja.barom.commons.UploadFiles;
import com.ja.barom.customer.service.CustomerService;

@Controller
@RequestMapping("/admin/siteAdmin/*")
public class SiteAdminController {

	@RequestMapping("siteAdminPage")
	public String siteAdminPage() {
		
		return "admin/siteAdmin/siteAdminPage";
	}

	
////Q&A 관련
	

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("mainQnAList")
	public String mainQnAList(Model model) {

		ArrayList<HashMap<String, Object>> dataList = customerService.getQuestionList();

		model.addAttribute("dataList", dataList);

		return "admin/siteAdmin/mainQnAList";
	}

	@RequestMapping("readQnAContentPage")
	public String readQnAContentPage(int cus_question_no, HttpServletResponse response, HttpServletRequest request,
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

		return "admin/siteAdmin/readQnAContentPage";
	}

	@RequestMapping("reppleContentProcess")
	public String reppleContentProcess(ReppleVo param, HttpSession session) {
		AdminVo adminSession = (AdminVo) session.getAttribute("adminSession");
		int user_no = adminSession.getAdmin_no();
		param.setUser_no(user_no);

		customerService.reppleContent(param);

		return "redirect:./readQnAContentPage?cus_question_no=" + param.getCus_question_no();
	}

	@RequestMapping("deleteReppleContentProcess")
	public String deleteReppleContentProcess(ReppleVo param) {
		customerService.deleteRepple(param.getRepple_no());

		return "redirect:./readQnAContentPage?cus_question_no=" + param.getCus_question_no();
	}

	@RequestMapping("deleteContentProcess")
	public String deleteContentProcess(int cus_question_no) {

		customerService.deleteBoard(cus_question_no);

		return "redirect:./mainQnAList";
	}
	
	@RequestMapping("updateReppleContentPage")
	public String updateReppleContentPage(int repple_no, Model model) {

		HashMap<String, Object> map = customerService.getRepple(repple_no);

		model.addAttribute("data", map);

		return "admin/siteAdmin/updateReppleContentPage";
	}
	

	@RequestMapping("updateReppleContentProcess")
	public String updateReppleContentProcess(ReppleVo param) {
		customerService.updateRepple(param);

		return "redirect:./readQnAContentPage?cus_question_no=" + param.getCus_question_no();
	}
	
	
	
	@Autowired
	SiteAdminService siteAdminService;
	
	
	//// FAQ 관련
	
	
	/* FAQ 게시판 메인페이지 */
	@RequestMapping("adminFaqPage")
	public String adminFaqPage(Model model) {
		
		ArrayList<HashMap<String, Object>> faqList =  siteAdminService.getFaqList();
		
		model.addAttribute("faqList", faqList);
		
		return "admin/siteAdmin/adminFaqPage";
	}
	
	/* FAQ 게시판 게시글 작성 페이지 */
	@RequestMapping("writeFaq")
	public String writeFaq(Model model) {
		
		ArrayList<FAQ_CategoryVo> faqcategorylist = siteAdminService.getFAQ_CategoryList();
		model.addAttribute("FAQ_CategoryList", faqcategorylist);
		
		return "admin/siteAdmin/writeFaq";
	}
	
	
	
	
	/* FAQ 게시글 작성 프로세스 */
	@RequestMapping("writeFaqProcess")
	public String writeFaqProcess(FaqVo param) {
		
		siteAdminService.writeFaq(param);
		
		return "redirect:./adminFaqPage";
	}
	
	
	/* FAQ 게시판 게시글 상세페이지 */
	@RequestMapping("readFaq")
	public String readFaq(int faq_no, Model model) {
		
		HashMap<String, Object> map = siteAdminService.getFaq(faq_no);
		model.addAttribute("faqdata", map);
		
		return "admin/siteAdmin/readFaq";
	}
	
	
	
////공지사항 관련

	/// 공지사항 목록조회
	@RequestMapping("adAnncmList")
	public String adAnncmList(Model model) {

		ArrayList<HashMap<String, Object>> AnncmLines = siteAdminService.getAnncmList();

		model.addAttribute("AnncmLines", AnncmLines);

		return "admin/siteAdmin/adAnncmList";

	}

	/// 공지사항 상세조회
	@RequestMapping("adReadAnncm")
	public String readAnncm(int anncm_no, Model model) {

		HashMap<String, Object> map = siteAdminService.getAnncm(anncm_no);
		model.addAttribute("AnncmDetails", map);

		return "admin/siteAdmin/adReadAnncm";

	}

	/// 공지사항 작성페이지 접근
	@RequestMapping("adWriteAnncm")
	public String writeAnncm() {

		return "admin/siteAdmin/adWriteAnncm";

	}

	/// 공지사항 작성 후 프로세스
	@RequestMapping("writeAnncmProcess")
	public String wirteAnncmProcess(AnnouncementVo AnncmVo, MultipartFile[] uploadFiles, HttpSession kkksession) {

		//로컬 설정
		// String anncmUploadFolder = "C:/uploadFolder/";
		//서버 설정
		String anncmUploadFolder = "/uploadFolder/";

		ArrayList<AnncmFilesVo> anncmFilesVoList = new ArrayList<AnncmFilesVo>();

		if (uploadFiles != null) {
			for (MultipartFile uploadFile : uploadFiles) {
				if (uploadFile.isEmpty()) {
					continue;
				}

				/* UploadFiles 클래스의 정적 메소드 getFolderPath 호출 */
				String folderDate = UploadFiles.getFolderPath(anncmUploadFolder);

				String originalFileName = uploadFile.getOriginalFilename();

				/* UploadFiles 클래스의 정적 메소드 getFileName 호출 */
				String fileNames[] = UploadFiles.getFileName(originalFileName);

				try {
					uploadFile.transferTo(new File(anncmUploadFolder + folderDate + fileNames[0]));
				} catch (Exception e) {
					e.printStackTrace();
				}

				// anncmFilesVo 필드 set()
				AnncmFilesVo anncmFilesVo = new AnncmFilesVo();

				anncmFilesVo.setAnncm_files_url(folderDate + fileNames[0]);
				anncmFilesVo.setAnncm_original_filename(originalFileName);

				anncmFilesVoList.add(anncmFilesVo);

			}

		}

		// 관리자 로그인 세션

		AdminVo siteAdminSession = (AdminVo) kkksession.getAttribute("adminSession");
		int siteAdminNo = siteAdminSession.getAdmin_no();

		AnncmVo.setAdmin_no(siteAdminNo);

		siteAdminService.writeAnncm(AnncmVo, anncmFilesVoList);

		return "redirect:./adAnncmList";

	}

	/// 공지사항 삭제
	@RequestMapping("deleteAnncmProcess")
	public String deleteAnncmProcess(int anncm_no) {

		siteAdminService.deleteAnncm(anncm_no);

		return "redirect:./adAnncmList";
	}

	/// 공지사항 본문 수정 페이지 접근
	@RequestMapping("adUpdateAnncm")
	public String updateAnncm(int anncm_no, Model model) {

		HashMap<String, Object> map = siteAdminService.getAnncm(anncm_no);
		model.addAttribute("AnncmData", map);

		return "admin/siteAdmin/adUpdateAnncm";
	}

	/// 공지사항 본문 수정 후 프로세스
	@RequestMapping("updateAnncmProcess")
	public String updateAnncmProcess(AnnouncementVo AnncmVo) {

		siteAdminService.updateAnncm(AnncmVo);

		return "redirect:./adReadAnncm?anncm_no=" + AnncmVo.getAnncm_no();
	}
	
	
	
	
	
	
	
	
}