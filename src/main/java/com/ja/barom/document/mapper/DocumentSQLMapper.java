package com.ja.barom.document.mapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.barom.Vo.AttorneyRelatedVo;
import com.ja.barom.Vo.AttorneyVo;
import com.ja.barom.Vo.CaseBasicInfoVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.CauseVo;
import com.ja.barom.Vo.DefendantCaseVo;
//import com.ja.barom.Vo.DefendantNameVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DefenseDocumentVo;
import com.ja.barom.Vo.DefenseProofFileVo;
import com.ja.barom.Vo.DefenseVo;
import com.ja.barom.Vo.DocumentConfirmedVo;
import com.ja.barom.Vo.DocumentPDFVo;
import com.ja.barom.Vo.DocumentPayVo;
import com.ja.barom.Vo.Min_Sj_Court_CategoryVo;
import com.ja.barom.Vo.Min_Sj_Sgn_CategoryVo;
//import com.ja.barom.Vo.PlaintiffNameVo;
import com.ja.barom.Vo.PlaintiffVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.PurposeVo;
import com.ja.barom.Vo.SubmitListVo;

public interface DocumentSQLMapper {

	public String createCasePk();
	public int createBasicInfoPk();
	public int createPlaintiffPk();
	public int createAttorneyRelatedPk();
	public int createAttorneyPk();
	public int createDefendantPk();
	public int createPurposePk();
	public int createCausePk();
	public int createDefensePk();
	
	public void insertCase(CaseVo vo);
	public CaseVo getCaseByNo(String no);
	public int isThisUsersCase(
				@Param("user_no") int user_no
				,@Param("case_no") String case_no
			);
	
	public void insertCaseBasicInfo(CaseBasicInfoVo vo);
	public CaseBasicInfoVo getCaseBasicInfoByNo(int no);
	public CaseBasicInfoVo getCaseBasicInfoByCaseNo(String no);
	public void delCaseBasicInfo(int no);
	public void updateCaseBasicInfo(CaseBasicInfoVo vo);
	
	public Min_Sj_Sgn_CategoryVo getSgnCateoryNameByNo(int no);
	public Min_Sj_Court_CategoryVo getCourtCategoryNameByNo(int no);
	public ArrayList<Min_Sj_Sgn_CategoryVo> getSgnCategoryList();
	public ArrayList<Min_Sj_Court_CategoryVo> getCourtCategoryList();
	
	public void insertPlaintiff(PlaintiffVo vo);
	public PlaintiffVo getPlaintiffByNo(int no);
	public ArrayList<PlaintiffVo> getPlaintiffListByCaseNo(String no);
	public PlaintiffVo getPlaintiffByCaseNo(String no);
	public int getPlaintiffNameCountByNo(int no);
	public void delPlaintiff(int no);
	public void updatePlaintiff(PlaintiffVo vo);
	
	public void insertDefendant(DefendantVo vo);
	public DefendantVo getDefendantByNo(int no);
	public DefendantVo getDefendantByCaseNo(String no);
	public ArrayList<DefendantVo> getDefendantListByCaesNo(String no);
	public void delDefendant(int no);
	public void updateDefendant(DefendantVo vo);
	
	public void insertAttorneyRelated(AttorneyRelatedVo vo);
	public ArrayList<AttorneyRelatedVo> getAttorneyRelatedByAttorneyNo(int no);
	public ArrayList<AttorneyRelatedVo> getAttorneyRelatedByConcernedPlaintiffNo(int no);
	public ArrayList<AttorneyRelatedVo> getAttorneyRelatedByConcernedDefendantNo(int no);
	public void delAttorneyRelated(int no);
	public void delAttorneyRelatedByAttorneyNo(int no);
	public void updateAttorneyRelated(AttorneyRelatedVo vo);
	
	public void insertAttorney(AttorneyVo vo);
	public AttorneyVo getAttorneyByNo(int no);
	public void delAttorney(int no);
	public void updateAttorney(AttorneyVo vo);
	
	public void insertPurpose(PurposeVo vo);
	public PurposeVo getPurposeByNo(int no);
	public PurposeVo getPurposeByCaseNo(String no);
	public void delPurpose(int no);
	public void updatePurpose(PurposeVo vo);
	
	public void insertCause(CauseVo vo);
	public CauseVo getCauseByNo(int no);
	public CauseVo getCauseByCaseNo(String no);
	public void delCause(int no);
	public void updateCause(CauseVo vo);
	
	public void insertDocumentConfirmed(DocumentConfirmedVo vo);
	public DocumentConfirmedVo getDocumentConfirmedByNo(String no);
	public DocumentConfirmedVo getDocumentConfirmedByCaseNo(String no);
	public void delDocumentConfirmed(int no);
	public void updateDocumentConfirmed(DocumentConfirmedVo vo);
	
	public void insertProofFile(ProofFileVo vo);
	public ProofFileVo getProofFileByNo(String no);
	public ProofFileVo getProofFileByCaseNo(String no);
	public ArrayList<ProofFileVo> getProofFileList(String no);
	public void delProofFile(int no);
	public void delProofFIleByName(String name);
	public void updateProofFile(ProofFileVo vo);
	
	public void insertDocumentPayInfo(DocumentPayVo vo);
	public void updateDocumentPayInfo(DocumentPayVo vo);
	public void updateDocumentPayDateAndToken(DocumentPayVo vo);
	public int getIsPayInfoExists(String no);
	public void updateCaseStatusAfterPay(String caseNo);
	
	//PDF 관련 
	public DocumentPDFVo getCaseForPdfByNo (String no);
	public String getPrePdfByNo (String no);
	public void deletePrePdfByUrl (String url);
	public void updatePrePdfByUrl (String url);
	public void updateCaseStatusAfterPdf (String caseNo);
		
	//내 소장 제출 목록 가져오기
	public ArrayList<HashMap<String, Object>> getMyCaseList (HashMap<String, Object> param);
	public String getCaseRefuseReason (String caseNo);
	
	//CaseConfirmed 관련
	public void insertDefendantCase (HashMap<String, Object> param);
	public int getDefendantCaseCount (DefendantCaseVo vo);
	public int getCaseConfirmedCount (HashMap<String, Object> param);
	public ArrayList<HashMap<String, Object>> getCaseConfirmedList (@Param("userNo") int userNo, @Param("searchOption") int searchOption);
	public ArrayList<HashMap<String, Object>> getConfirmedListForPlaintiff (HashMap<String, Object> param);
	public ArrayList<HashMap<String, Object>> getConfirmedListForDeffendant (HashMap<String, Object> param);
	public ArrayList<HashMap<String, Object>> getConfirmedListForPlaintiffSub (HashMap<String, Object> param);
	public ArrayList<HashMap<String, Object>> getConfirmedListForDefendantffSub (HashMap<String, Object> param);
	public HashMap<String, Object> getCaseConfirmed (String confirmedNo);
	public int getPlaintiffCountByConfirmedNo (String confirmedNo);
	public int getDefendantCountByConfirmedNo (String confirmedNo);
	public String getPlaintiffOneByConfirmedNo (String confirmedNo);
	public String getDefendanOneByConfirmedNo (String confirmedNo);
	public void updateConfirmedStatusAfterAnswer (String confirmedNo);
	public void updateConfirmedStatusAfterJudgment (String confirmedNo);
	public void updateConfirmedStatusAfter (@Param("statusNo") String statusNo, @Param("confirmedNo") String confirmedNo);
	
	
	// 답변서 관련
	public ArrayList<String> getWriteAnswerList (int userNo);
	public void insertAnswer (DefenseVo vo);
	public String getCourtByDefenseNo (int defenseNo);
	public DefenseVo getDefenseByNo (int defenseNo);
	public DefenseProofFileVo getDefenseProofListByNo (int defenseNo);
	public void insertDefenseDocument(DefenseDocumentVo vo);
	public void insertDefenseProofFile(DefenseProofFileVo vo);
	public ArrayList<String> getConfirmedList (int userNo);
	public int checkAnswerRegist (
			@Param("confirmedNo") String confirmedNo,
			@Param("userNo") int userNo);
	
	
	//@Param("searchOption") String searchOption
	public ArrayList<HashMap<String, Object>> getUserCaseList(int user_no);
	
	
}

