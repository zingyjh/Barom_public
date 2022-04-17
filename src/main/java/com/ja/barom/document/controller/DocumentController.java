package com.ja.barom.document.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ja.barom.Vo.CaseBasicInfoVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DocumentConfirmedVo;
import com.ja.barom.Vo.DocumentPDFVo;
import com.ja.barom.Vo.DocumentPayVo;
import com.ja.barom.Vo.Min_Sj_Court_CategoryVo;
import com.ja.barom.Vo.Min_Sj_Sgn_CategoryVo;
import com.ja.barom.Vo.PlaintiffVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.PurposeVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.commons.CreatePdf;
import com.ja.barom.commons.UploadFiles;
import com.ja.barom.document.service.DocumentService;

@Controller
@RequestMapping("/document/*")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	
	@RequestMapping("msCategorySelect")
	public String msCategorySelect() {
		
		return "document/msCategorySelect";
	}
	
	@RequestMapping("agree")
	public String agree(HttpSession session) {
		
		session.removeAttribute("case_no");
		
		return "document/agree";
	}
	
	@RequestMapping("petition")
	public String petition(Model model) {
		
		ArrayList<Min_Sj_Sgn_CategoryVo> sgn_list = documentService.getSgnCategory();
		ArrayList<Min_Sj_Court_CategoryVo> court_list = documentService.getCourtCategory();
		model.addAttribute("sgn_list", sgn_list);
		model.addAttribute("court_list", court_list);
		
		return "document/petition";
	}
	
	@RequestMapping("modPetition")
	public String modPetition(String case_no, Model model, HttpSession session) {
		
		model.addAttribute("case_code", case_no);
		
		System.out.println("[System] 사건 " + case_no + "정보 불러오기");
		
		ArrayList<Min_Sj_Sgn_CategoryVo> sgn_list = documentService.getSgnCategory();
		ArrayList<Min_Sj_Court_CategoryVo> court_list = documentService.getCourtCategory();
		model.addAttribute("sgn_list", sgn_list);
		model.addAttribute("court_list", court_list);
		
		return "document/petition";
	}
	
	
	@RequestMapping("confFileInfo")
	public String confFileInfo(HttpSession session, Model model) {
	
		String case_no = (String) session.getAttribute("case_no");
		
		model.addAttribute("case_code", case_no);
		
		return "document/confFileInfo";
	}
	
	@RequestMapping("confFileInfoProcess")
	public String confFileInfoProcess(MultipartFile[] uploadFiles, HttpSession session) {
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		String case_no = (String) session.getAttribute("case_no");
		
		ArrayList<ProofFileVo> proofFileVoList = new ArrayList<ProofFileVo>();
		if(uploadFiles != null) {
			proofFileVoList = UploadFiles.uploadProofFilesToFolder(uploadFiles);
		}
		
		documentService.insertProofFiles(case_no, proofFileVoList);
		
		return "redirect:../document/confFileInfo";
	}
	
	@RequestMapping("preShowPdf")
	public String preShowPdf(HttpSession session, Model model) throws IOException {
		
		String case_no = (String) session.getAttribute("case_no");
		String pdfUrl = null;
		if (documentService.getPrePdfByNo(case_no) == null) {
			System.out.println("PDF 변환 실행");
			DocumentPDFVo PdfVo = documentService.getCaseForPdfByNo(case_no);
			ArrayList<PlaintiffVo> PList = documentService.getPlaintiffList(case_no);
			ArrayList<DefendantVo> DList = documentService.getDefendantList(case_no);
			ArrayList<ProofFileVo> FList = documentService.getProofFileList(case_no);
			
			PdfVo.setPvoList(PList);
			PdfVo.setDvoList(DList);
			if (FList.isEmpty() == false) {
				PdfVo.setFvoList(FList);
			}
			
			DocumentConfirmedVo documentConfirmedVo = CreatePdf.insertPdf(PdfVo);
			documentService.insertDocumentConfirme(documentConfirmedVo);
			pdfUrl = documentConfirmedVo.getConfirmed_url();
			documentService.updateCaseStatusAfterPdf(case_no);
			
		} else {
			// 해당 페이지 새로고침 할 경우 pdf 계속 생성 방지 
			System.out.println("이미 PDF 파일이 존재합니다.");
			pdfUrl = documentService.getPrePdfByNo(case_no);
		}
				
		session.setAttribute("pdfUrl", pdfUrl);
		
		return "document/preShowPdf";
	}
	
	@RequestMapping("payConf")
	public String payConf(HttpSession session, Model model) {

		String case_no = (String) session.getAttribute("case_no");
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int user_no = sessionUser.getUser_no();
		
		if(documentService.isThisUsersCase(user_no, case_no)){
			model.addAttribute("case_code", case_no);
			
			CaseVo caseInfo = documentService.getCaseByCaseNo(case_no);
			CaseBasicInfoVo caseBasicInfo = documentService.getCaseBasicInfo(case_no);

			String courtName = documentService.getSgnCourtName(caseBasicInfo.getMin_sj_court_category_no());
			String categoryName = documentService.getSgnCateoryName(caseBasicInfo.getMin_sj_sgn_category_no());
			
			model.addAttribute("caseInfo", caseInfo);
			model.addAttribute("caseBasicInfo", caseBasicInfo);
			model.addAttribute("courtName", courtName);
			model.addAttribute("categoryName", categoryName);
		} else {
			// 내 사건이 아님
		}

		return "document/payConf";
	}
	
	@RequestMapping("uploadConf")
	public String uploadConf(HttpSession session, String pg_token, int payResult) {

		String case_no = (String) session.getAttribute("case_no");
		
		switch(payResult) {
			case 1: 
				DocumentPayVo documentPayVo = new DocumentPayVo();
				documentPayVo.setPg_token(pg_token);
				documentPayVo.setCase_no(case_no);
				documentService.updateDocumentPayDateAndCode(documentPayVo);
				
			break;
			case 2: break;
			case 3: break;
		}
		documentService.updateCaseStatusAfterPay(case_no);
		session.removeAttribute("case_no");
		
		return "document/uploadConf";
	}
	
	@RequestMapping("screenPage")
	public String screenPage () {
	      
        return "document/screenPage";
	}

	
	
}