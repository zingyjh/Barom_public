package com.ja.barom.document.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.barom.Vo.AttorneyRelatedVo;
import com.ja.barom.Vo.AttorneyVo;
import com.ja.barom.Vo.CaseBasicInfoVo;
import com.ja.barom.Vo.CaseConfirmedVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.CauseVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DocumentConfirmedVo;
import com.ja.barom.Vo.DocumentPDFVo;
import com.ja.barom.Vo.DocumentPayVo;
import com.ja.barom.Vo.Min_Sj_Court_CategoryVo;
import com.ja.barom.Vo.Min_Sj_Sgn_CategoryVo;
import com.ja.barom.Vo.PlaintiffVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.PurposeVo;
import com.ja.barom.document.mapper.DocumentSQLMapper;

@Service
public class DocumentService {

	@Autowired
	private DocumentSQLMapper documentSQLMapper;
	
	// 소장제출 한 페이지로 통합을 위한 RESTAPI 작업
	
	public String insertCase(CaseVo vo) {
		
		System.out.println("[System] 사건정보 DB에 입력");
		String pk = documentSQLMapper.createCasePk();
		
		vo.setCase_no(pk);
		vo.setStatus_no(1);
		vo.setApproval_no(4);


		vo.setCase_refuse_reason("미입력");

		documentSQLMapper.insertCase(vo);
		
		return pk;
	}
	
	public CaseVo getCaseByCaseNo(String case_no) {
		
		return documentSQLMapper.getCaseByNo(case_no);
	}
	
	public int insertBasicInfo(CaseBasicInfoVo vo) {
		
		System.out.println("[System] 사건기본정보 DB에 입력");
		int pk = documentSQLMapper.createBasicInfoPk();
		vo.setCaseBasicInfo_no(pk);
		documentSQLMapper.insertCaseBasicInfo(vo);
		
		return pk;
	}
	
	public void updateBasicInfo(CaseBasicInfoVo vo) {
		
		System.out.println("[System] 사건기본정보 수정");
		documentSQLMapper.updateCaseBasicInfo(vo);
	}
	
	public CaseBasicInfoVo getCaseBasicInfo(String case_no) {
		
		System.out.println("[System] 사건기본정보 가져오기");
		
		return documentSQLMapper.getCaseBasicInfoByCaseNo(case_no);
	}
	
	public int insertPlaintiff(PlaintiffVo vo) {
		
		System.out.println("[System] 원고정보 입력");
		int pk = documentSQLMapper.createPlaintiffPk();
		vo.setPlaintiff_no(pk);
		vo.setPlaintiff_selected("_");
		documentSQLMapper.insertPlaintiff(vo);
		
		return pk;
	} 
	
	public PlaintiffVo getPlaintiffByNo(int no) {
		
		System.out.println("[System] 원고정보 가져오기");
		
		return documentSQLMapper.getPlaintiffByNo(no);
	}
	
	public void updatePlaintiff(PlaintiffVo vo) {
		
		System.out.println("[System] 원고정보 수정");
		documentSQLMapper.updatePlaintiff(vo);
	}
	
	public void deletePlaintiff(int no) {
		
		System.out.println("[System] 원고정보 삭제");
		documentSQLMapper.delPlaintiff(no);
	}
	
	public ArrayList<PlaintiffVo> getPlaintiffList(String case_no){
		
		System.out.println("[System] 원고목록 가져오기");
		ArrayList<PlaintiffVo> dataList = new ArrayList<PlaintiffVo>();
		dataList = documentSQLMapper.getPlaintiffListByCaseNo(case_no);
		
		return dataList;
	}
	
	public int insertDefendant(DefendantVo vo) {
		
		System.out.println("[System] 피고정보 입력");
		int pk = documentSQLMapper.createDefendantPk();
		vo.setDefendant_no(pk);
		documentSQLMapper.insertDefendant(vo);
		
		return pk;
	}
	
	public DefendantVo getDefendantByNo(int no) {
		
		System.out.println("[System] 피고정보 가져오기");
		
		return documentSQLMapper.getDefendantByNo(no);
	}
	
	public void updateDefendant(DefendantVo vo) {
		
		System.out.println("[System] 피고정보 수정");
		documentSQLMapper.updateDefendant(vo);
	}
	
	public void deleteDefendant(int no) {
		
		System.out.println("[System] 피고정보 삭제");
		documentSQLMapper.delDefendant(no);
	}
	
	public ArrayList<DefendantVo> getDefendantList(String case_no){
		
		System.out.println("[System] 피고목록 가져오기");
		ArrayList<DefendantVo> dataList = new ArrayList<DefendantVo>();
		dataList = documentSQLMapper.getDefendantListByCaesNo(case_no);
		
		return dataList;
	}
	
	public void insertAttorney(AttorneyRelatedVo related, AttorneyVo attorney) {
		
		System.out.println("[System] 대리인 정보 입력");
		int attorneyPk = documentSQLMapper.createAttorneyPk();
		attorney.setAttorney_no(attorneyPk);
		documentSQLMapper.insertAttorney(attorney);

		System.out.println("[System] 대리인 관계 정보 입력");
		int relatedPk = documentSQLMapper.createAttorneyRelatedPk();
		related.setAttorney_related_no(relatedPk);
		related.setAttorney_no(attorneyPk);
		documentSQLMapper.insertAttorneyRelated(related);
	}
	
	public void updateAttorney(AttorneyVo vo) {
		
		System.out.println("[System] 대리인 정보 수정");
		documentSQLMapper.updateAttorney(vo);
	}
	
	public void updateAttorneyRelated(AttorneyRelatedVo vo) {
		
		System.out.println("[System] 대리인 관계 정보 수정");
		documentSQLMapper.updateAttorneyRelated(vo);
	}
	
	public void deleteAttorney(int attorney_no) {
		
		System.out.println("[System] 대리인 정보 삭제");
		documentSQLMapper.delAttorney(attorney_no);
		
		System.out.println("[System] 대리인 관계 정보 삭제");
		documentSQLMapper.delAttorneyRelatedByAttorneyNo(attorney_no);
	}

	

	public int insertPurpose(PurposeVo vo) {
		
		System.out.println("[System] 청구취지 입력");
		int pk = documentSQLMapper.createPurposePk();
		vo.setPurpose_no(pk);
		documentSQLMapper.insertPurpose(vo);
	
		return pk;
	}
	
	public void updatePurpose(PurposeVo vo) {
		
		System.out.println("[System] 청구취지 수정");
		documentSQLMapper.updatePurpose(vo);
	}
	
	public PurposeVo getPurpose(String case_no) {
		
		System.out.println("[System] 청구취지 가져오기");
		
		return documentSQLMapper.getPurposeByCaseNo(case_no);
	}
	
	public int insertCause(CauseVo vo) {
		
		System.out.println("[System] 청구원인 입력");
		int pk = documentSQLMapper.createCausePk();
		vo.setCause_no(pk);
		documentSQLMapper.insertCause(vo);
		
		return pk;
	}
	
	public void updateCause(CauseVo vo) {
		
		System.out.println("[System] 청구원인 수정");
		documentSQLMapper.updateCause(vo);
	}
	
	public CauseVo getCause(String case_no) {
		
		System.out.println("[System] 청구원인 가져오기");
		
		return documentSQLMapper.getCauseByCaseNo(case_no);
	}
	
	public boolean isThisUsersCase(int user_no, String case_no) {
		
		System.out.println("[System] 사건 " + case_no + "는 사용자 " + user_no + "가 등록한 사건이 맞는가?");
		int count = documentSQLMapper.isThisUsersCase(user_no, case_no);
		
		if(count == 0) {
			System.out.println("[System] 거짓");
			return false;
		} else {
			System.out.println("[System] 참");
			return true;
		}	
	}

	
	public void insertProofFiles(String caseNo, ArrayList<ProofFileVo> vo) {
		int i = 1;
		for(ProofFileVo proofFile : vo) {
			System.out.println("[System] " + i + "번째 파일정보 DB에 입력");
			proofFile.setCase_no(caseNo);
			documentSQLMapper.insertProofFile(proofFile);
			i++;
		}
	}
	
	public void insertProofFile(String caseNo, ProofFileVo vo) {
		System.out.println("[System] 첨부파일 DB에 입력");
		vo.setCase_no(caseNo);
		documentSQLMapper.insertProofFile(vo);
	}
	
	public ArrayList<ProofFileVo> getProofFileList (String caseNo) {
		
		System.out.println("[System] 첨부파일 리스트 불러오기");
		ArrayList<ProofFileVo> dataList = documentSQLMapper.getProofFileList(caseNo);
		
		return dataList;
	}
	
	public void deleteProofFile(String file_name) {
		System.out.println("[System] 첨부파일 DB에서 삭제");
		documentSQLMapper.delProofFIleByName(file_name);
		
		// 로컬 설정
		// String filePath = "C:/uploadFolder/" + file_name;
		// 서버 설정
		String filePath = "/uploadFolder/" + file_name;

		File deleteFile = new File(filePath);
		
		if (deleteFile.exists()) {	
			System.out.println(filePath+"을 삭제합니다");
			deleteFile.delete();
			System.out.println(filePath+"을 삭제했습니다");
		} else {
			System.out.println(filePath+"을 찾지 못하였습니다.");
		}
	}
	
	public void insertDocumentPayInfo(DocumentPayVo vo) {
		System.out.println("[System] 결제정보 DB에 입력");
		
		int isExists = documentSQLMapper.getIsPayInfoExists(vo.getCase_no());
		if(isExists == 0) {
			System.out.println("[System] 결제정보 새로 입력");
			documentSQLMapper.insertDocumentPayInfo(vo);
		}else {
			System.out.println("[System] 이미 결제정보 존재");
			documentSQLMapper.updateDocumentPayInfo(vo);
		}
		
	}
	
	public void updateDocumentPayDateAndCode(DocumentPayVo vo) {
		System.out.println("[System] 결제코드 및 날짜 DB에 업데이트");
		
		documentSQLMapper.updateDocumentPayDateAndToken(vo);
	}
	
	public String getSgnCateoryName(int no) {
		Min_Sj_Sgn_CategoryVo categoryVo = documentSQLMapper.getSgnCateoryNameByNo(no);
		
		return categoryVo.getMin_sj_sgn_category_name();
	}
	
	public String getSgnCourtName(int no) {
		
		Min_Sj_Court_CategoryVo courtVo = documentSQLMapper.getCourtCategoryNameByNo(no);
		
		return courtVo.getMin_sj_court_category_name();
	}
	
	// PDF관련
	public DocumentPDFVo getCaseForPdfByNo (String caseNo) {
		
		DocumentPDFVo PdfVo = documentSQLMapper.getCaseForPdfByNo(caseNo);
		
		return PdfVo;
	}
	
	public void insertDocumentConfirme (DocumentConfirmedVo vo) {
		
		documentSQLMapper.insertDocumentConfirmed(vo);
	}
	
	public String getPrePdfByNo (String caseNo) {
		
		return documentSQLMapper.getPrePdfByNo(caseNo);
	}
	
	public void deletePdf (String pdfUrl) {
		
		documentSQLMapper.deletePrePdfByUrl(pdfUrl);
		
		// 로컬 설정
		// String filePath = "C:/uploadFolder" + pdfUrl;
		// 서버 설정
		String filePath = "/uploadFolder" + pdfUrl;

		File deleteFile = new File(filePath);
		
		if (deleteFile.exists()) {
			
			System.out.println(filePath+"을 삭제합니다");
			deleteFile.delete();
			System.out.println(filePath+"을 삭제했습니다");
		} else {
			System.out.println(filePath+"을 찾지 못하였습니다.");
		}
		
	}
	
	public void updatePdf (String pdfUrl) {
		
		documentSQLMapper.updatePrePdfByUrl(pdfUrl);
	}
	
	public void updateCaseStatusAfterPdf (String CaseNo) {
		
		documentSQLMapper.updateCaseStatusAfterPdf(CaseNo);
	}
	
	public void updateCaseStatusAfterPay (String CaseNo) {
		
		documentSQLMapper.updateCaseStatusAfterPay(CaseNo);
	}
		
	
	// 소장 입력 데이터 호출
	public ArrayList<Min_Sj_Sgn_CategoryVo> getSgnCategory(){
		
		System.out.println("[System] 소장종류리스트 불러오기");
		
		return documentSQLMapper.getSgnCategoryList();
	}
	
	public ArrayList<Min_Sj_Court_CategoryVo> getCourtCategory(){
		
		System.out.println("[System] 법원리스트 불러오기");
		
		return documentSQLMapper.getCourtCategoryList();
	}
	



	
}