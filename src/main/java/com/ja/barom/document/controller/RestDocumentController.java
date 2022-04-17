package com.ja.barom.document.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ja.barom.Vo.AttorneyRelatedVo;
import com.ja.barom.Vo.AttorneyVo;
import com.ja.barom.Vo.CaseBasicInfoVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.CauseVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.PlaintiffVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.PurposeVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.commons.UploadFiles;
import com.ja.barom.document.service.DocumentService;

@RestController
@RequestMapping("/document/*")
public class RestDocumentController {

	@Autowired
	private DocumentService documentService;

	@RequestMapping("insertnewCase")
	public HashMap<String, Object> insertCase(HttpSession session){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int user_no = sessionUser.getUser_no();
		
		CaseVo caseVo = new CaseVo();
		caseVo.setUser_no(user_no);
		
		String caseNo = documentService.insertCase(caseVo);
		
		data.put("result", "success");
		data.put("case_no", caseNo);
		
		return data;
	}
	
	@RequestMapping("insertBasicInfo")
	public HashMap<String, Object> insertBasicInfo(CaseBasicInfoVo vo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		int caseNo = documentService.insertBasicInfo(vo);
		
		data.put("result", "success");
		data.put("basicInfo_no", caseNo);
		return data;
	}
	
	@RequestMapping("updateBasicInfo")
	public HashMap<String, Object> updateBasicInfo(CaseBasicInfoVo vo){

		System.out.println("사건명 : " + vo.getMin_sj_sgn_category_no());
		System.out.println("청구구분 : " + vo.getCaseBasicInfo_claim_method());
		System.out.println("소가구분 : " + vo.getCaseBasicInfo_price_method());
		System.out.println("비용 : " + vo.getCaseBasicInfo_price());
		System.out.println("법원명 : " + vo.getMin_sj_court_category_no());
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		documentService.updateBasicInfo(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("insertPlaintif")
	public HashMap<String, Object> insertPlaintif(PlaintiffVo vo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		documentService.insertPlaintiff(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("getPlaintiff")
	public HashMap<String, Object> getPlaintiff(int no){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		PlaintiffVo plaintiffData = new PlaintiffVo();
		plaintiffData = documentService.getPlaintiffByNo(no);
		
		data.put("result", "success");
		data.put("data", plaintiffData);
		
		return data;
	}
	
	@RequestMapping("updatePlaintif")
	public HashMap<String, Object> updatePlaintif(PlaintiffVo vo){

		
		HashMap<String, Object> data = new HashMap<String, Object>();
		documentService.updatePlaintiff(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("deletePlaintif")
	public HashMap<String, Object> deletePlaintif(int no){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		documentService.deletePlaintiff(no);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("insertDefendant")
	public HashMap<String, Object> insertDefendant(DefendantVo vo){

		HashMap<String, Object> data = new HashMap<String, Object>();
		documentService.insertDefendant(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("getDefendant")
	public HashMap<String, Object> getDefendant(int no){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		DefendantVo defendantData = new DefendantVo();
		defendantData = documentService.getDefendantByNo(no);
		
		data.put("result", "success");
		data.put("data", defendantData);
		
		return data;
	}
	
	@RequestMapping("updateDefendant")
	public HashMap<String, Object> updateDefendant(DefendantVo vo){

		HashMap<String, Object> data = new HashMap<String, Object>();
		documentService.updateDefendant(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	
	@RequestMapping("deleteDefendant")
	public HashMap<String, Object> deleteDefendant(int no){

		HashMap<String, Object> data = new HashMap<String, Object>();
		documentService.deleteDefendant(no);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("getConcernedList")
	public HashMap<String, Object> getConcernedList(String case_no){
		
		System.out.println("[System]" + case_no + "의 사건 정보 불러오기");
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		ArrayList<PlaintiffVo> plaintiffList = new ArrayList<PlaintiffVo>();
		plaintiffList = documentService.getPlaintiffList(case_no);
		ArrayList<DefendantVo> defendantList = new ArrayList<DefendantVo>();
		defendantList = documentService.getDefendantList(case_no);
		
		data.put("result", "success");
		data.put("plaintiffList", plaintiffList);
		data.put("defendantList", defendantList);
		
		return data;
	}
	
	@RequestMapping("insertPurpose")
	public HashMap<String, Object> insertPurpose(PurposeVo vo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		int purposeNo = documentService.insertPurpose(vo);

		data.put("result", "success");
		data.put("purposeNo", purposeNo);
		
		return data;
	}
	
	@RequestMapping("updatePurpose")
	public HashMap<String, Object> updatePurpose(PurposeVo vo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		documentService.updatePurpose(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("insertCause")
	public HashMap<String, Object> insertCause(CauseVo vo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		int causeNo = documentService.insertCause(vo);
		
		data.put("result", "success");
		data.put("causeNo", causeNo);
		
		return data;
	}
	
	@RequestMapping("updateCause")
	public HashMap<String, Object> updateCause(CauseVo vo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		documentService.updateCause(vo);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("insertProofFile")
	public HashMap<String, Object> insertProofFile(){
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("deleteProofFile")
	public HashMap<String, Object> deleteProofFile(){
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("insertAttorney")
	public HashMap<String, Object> insertAttorney(AttorneyRelatedVo relatedVo, AttorneyVo attorneyVo){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("toFilePage")
	public HashMap<String, Object> toFilePage(String case_no, HttpSession session){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		session.setAttribute("case_no", case_no);
		
		data.put("result", "success");
		data.put("case_no", case_no);
		
		return data;
	}
	
	@RequestMapping("getSavedCaseData")
	public HashMap<String, Object> getSavedCaseData(String case_no, HttpSession session){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int user_no = sessionUser.getUser_no();
		
		HashMap<String, Object> caseData = new HashMap<String, Object>();
		
		if(documentService.isThisUsersCase(user_no, case_no)) {
			CaseBasicInfoVo caseBasicInfo = documentService.getCaseBasicInfo(case_no);
			ArrayList<PlaintiffVo> plaintiffList = documentService.getPlaintiffList(case_no);
			ArrayList<DefendantVo> defendantList = documentService.getDefendantList(case_no);
			PurposeVo purpose = documentService.getPurpose(case_no);
			CauseVo cause = documentService.getCause(case_no);
			
			caseData.put("caseBasicInfo", caseBasicInfo);
			caseData.put("plaintiffList", plaintiffList);
			caseData.put("defendantList", defendantList);
			caseData.put("purpose", purpose);
			caseData.put("cause", cause);
			
		} else {
			caseData = null;
		}
		
		data.put("result", "success");
		data.put("caseData", caseData);
		
		return data;
	}
	
	@RequestMapping("getSavedProofFile")
	public HashMap<String, Object> getSavedProofFile(String case_no, HttpSession session){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		int user_no = sessionUser.getUser_no();
		
		ArrayList<ProofFileVo> proofFileList = new ArrayList<ProofFileVo>();
		if(documentService.isThisUsersCase(user_no, case_no)) {
			proofFileList = documentService.getProofFileList(case_no);
		} else {
			proofFileList = null;
		}
		
		data.put("result", "success");
		data.put("fileData", proofFileList);
		
		return data;
	}
	
	@RequestMapping("delSavedProofFile")
	public HashMap<String, Object> delSavedProofFile(String file_name){
		
		System.out.println("[System] 파일 " + file_name + "삭제");
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		documentService.deleteProofFile(file_name);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("uploadProofFiles")
	public HashMap<String, Object> uploadProofFiles(MultipartFile[] uploadFiles, HttpSession session){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		System.out.println("[System] 파일 업로드");
				
		UserVo sessionUser = (UserVo) session.getAttribute("sessionUser");
		String case_no = (String) session.getAttribute("case_no");
		
		ArrayList<ProofFileVo> proofFileVoList = new ArrayList<ProofFileVo>();
		if(uploadFiles != null) {
			proofFileVoList = UploadFiles.uploadProofFilesToFolder(uploadFiles);
		}
		
		documentService.insertProofFiles(case_no, proofFileVoList);
		
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("getPrePdfUrl")
	public HashMap<String, Object> getPrePdfUrl (HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		System.out.println("PDF URL 저장");
		String pdfUrl = (String) session.getAttribute("pdfUrl");
		
		data.put("result", "success");
		data.put("pdfUrl", pdfUrl);
		
		return data;
	}
	
	@RequestMapping("deletePrePdf")
	public HashMap<String, Object> deletePrePdf(HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		String pdfUrl = (String) session.getAttribute("pdfUrl");
		documentService.deletePdf(pdfUrl);
		
		session.removeAttribute("pdfUrl");
		System.out.println("PrePDF 삭제 및 session 제거");
		data.put("result", "success");
		
		return data;
	}
	
	@RequestMapping("updatePrePdf")
	public HashMap<String, Object> updatePrePdf(HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		String pdfUrl = (String) session.getAttribute("pdfUrl");
		documentService.updatePdf(pdfUrl);
		
		session.removeAttribute("pdfUrl");
		System.out.println("PrePDF 업데이트 및 session 제거");
		data.put("result", "success");
		
		return data;
	}
	
}
