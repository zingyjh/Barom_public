package com.ja.barom.admin.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.ja.barom.Vo.AdminVo;
import com.ja.barom.Vo.CaseBasicInfoVo;
import com.ja.barom.Vo.CaseConfirmedVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DocumentConfirmedVo;
import com.ja.barom.Vo.Min_Sj_Court_CategoryVo;
import com.ja.barom.Vo.Min_Sj_Sgn_CategoryVo;
import com.ja.barom.Vo.PlaintiffVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.TrialVo;
import com.ja.barom.Vo.CaseConfirmedStatusVo;
import com.ja.barom.admin.mapper.AdminSQLMapper;
import com.ja.barom.document.mapper.DocumentSQLMapper;

@Service
public class AdminService {

	@Autowired
	private AdminSQLMapper adminSQLMapper;
    @Autowired
    private DocumentSQLMapper documentSQLMapper;
	
	public AdminVo getAdmin(AdminVo vo) {
		
		return adminSQLMapper.getAdminByIdAndPw(vo);		
	}
	

	public ArrayList<HashMap<String, Object>> getCaseList( HashMap<String, Object> param ) {
		
		ArrayList<HashMap<String, Object>> list = adminSQLMapper.getcaseList(param);
		
		for(HashMap<String, Object> data : list) {
			
			String caseNo = (String) data.get("CASE_NO");
			
			ArrayList<PlaintiffVo> PlaintiffList = documentSQLMapper.getPlaintiffListByCaseNo(caseNo);
			ArrayList<DefendantVo> DefendantList = documentSQLMapper.getDefendantListByCaesNo(caseNo);
			
			String plaintiffName = "";
			if ( PlaintiffList.size() != 0 ) {
				
				PlaintiffVo Pvo = PlaintiffList.get(0);
				
				int plaintiffNum = PlaintiffList.size();
				
				if (plaintiffNum == 1) {
					
					plaintiffName = Pvo.getPlaintiff_name();
					
				} else {
					
					plaintiffName = Pvo.getPlaintiff_name() + " 외 " + (plaintiffNum-1) + "명";
					
				}
			}
			String defendantName = "";
			if ( DefendantList.size() != 0 ) {
				
				DefendantVo Dvo = DefendantList.get(0);
				
				int defendantNum = DefendantList.size();
				
				if (defendantNum == 1) {
					
					defendantName = Dvo.getDefendant_name();
					
				} else {
					
					defendantName = Dvo.getDefendant_name() + " 외 " + (defendantNum-1) + "명";
				}
			}
				
			data.put("plaintiffName", plaintiffName);
			data.put("defendantName", defendantName);
			
		}
		
		return list;	
	}
	
	public HashMap<String, Object> getCase(String case_no){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		CaseVo caseVo = documentSQLMapper.getCaseByNo(case_no);
		String caseNo = caseVo.getCase_no();
		
		CaseBasicInfoVo caseBasicInfoVo = documentSQLMapper.getCaseBasicInfoByCaseNo(caseNo);
		DocumentConfirmedVo documentConfirmedVo = documentSQLMapper.getDocumentConfirmedByCaseNo(caseNo);
		ArrayList<ProofFileVo> proofFileVo = documentSQLMapper.getProofFileList(caseNo);
		ArrayList<PlaintiffVo> PlaintiffList = documentSQLMapper.getPlaintiffListByCaseNo(caseNo);
		ArrayList<DefendantVo> DefendantList = documentSQLMapper.getDefendantListByCaesNo(caseNo);
		
		String plaintiffName = "";
		if ( PlaintiffList.size() != 0 ) {
			
			PlaintiffVo Pvo = PlaintiffList.get(0);
			
			int plaintiffNum = PlaintiffList.size();
			
			if (plaintiffNum == 1) {
				
				plaintiffName = Pvo.getPlaintiff_name();
				
			} else {
				
				plaintiffName = Pvo.getPlaintiff_name() + " 외 " + (plaintiffNum-1) + "명";
				
			}
		}
		String defendantName = "";
		if ( DefendantList.size() != 0 ) {
			
			DefendantVo Dvo = DefendantList.get(0);
			
			int defendantNum = DefendantList.size();
			
			if (defendantNum == 1) {
				
				defendantName = Dvo.getDefendant_name();
				
			} else {
				
				defendantName = Dvo.getDefendant_name() + " 외 " + (defendantNum-1) + "명";
			}
		}
		
				
		int courtNo = caseBasicInfoVo.getMin_sj_court_category_no();
		int sgnNo = caseBasicInfoVo.getMin_sj_sgn_category_no();
		Min_Sj_Court_CategoryVo min_Sj_Court_CategoryVo = documentSQLMapper.getCourtCategoryNameByNo(courtNo); 
		Min_Sj_Sgn_CategoryVo min_Sj_Sgn_CategoryVo = documentSQLMapper.getSgnCateoryNameByNo(sgnNo);
		
		map.put("caseVo", caseVo);
		map.put("cbiVo", caseBasicInfoVo);
		map.put("dcVo", documentConfirmedVo);
		map.put("pfVo", proofFileVo);
		map.put("courtVo", min_Sj_Court_CategoryVo);
		map.put("sgnVo", min_Sj_Sgn_CategoryVo);
		map.put("plaintiffName", plaintiffName);
		map.put("defendantName", defendantName);
		
		return map;
	}
	
	public String insertCaseConfirmed(CaseConfirmedVo vo , int price) {
		
		String cPk = adminSQLMapper.createCaseConfrimedPk();
		Date day = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy");
		String year = date.format(day);
		
		if(price <= 30000000) {
		vo.setCase_confirmed_no(year + "가소" + cPk);		
		}else if(price > 30000000 && price < 200000000) {
		vo.setCase_confirmed_no(year + "가단" + cPk);
		}else if(price >= 200000000) {
		vo.setCase_confirmed_no(year + "가합" + cPk);	
		}
		System.out.println("[system] 재판부에 사건 배당");
		
		adminSQLMapper.insertCaseConfirmed(vo);
	
	    return cPk;
	}
	
	public void updateCaseStatus(String case_no) {
		
		System.out.println("[system] 소장 승인"+ case_no);
		
		adminSQLMapper.updateCaseStatus(case_no);
	}
	
	public void refuseCaseStatus(CaseVo vo) {
		
		System.out.println("[system] 소장 반려" + vo);
		adminSQLMapper.refuseCaseStatus(vo);
	}

	public ArrayList<HashMap<String, Object>> getCaseConfirmedAndAnsweredList (HashMap<String, Object> param) {
		
		return adminSQLMapper.getCaseConfirmedAndAnsweredList(param);
	}
	
	public ArrayList<CaseConfirmedStatusVo> getCaseConfirmedStatusList () {
		
		return adminSQLMapper.getCaseConfirmedStatusList();

	}
	
	public ArrayList<String> getCaseConfirmedByStatus (int status) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		if ( status == 2) {
			
			list = adminSQLMapper.getCaseConfirmedAgreeList();
			return list;
		} else {
			
			list = adminSQLMapper.getCaseConfiremdJudgeList();
			return list;
		}
	}
	
	public void insertTrial (HashMap<String, Object> param) {
		
		int trialNo = adminSQLMapper.createTrialPk();
		String confirmedNo = (String) param.get("confirmedNo");
		param.put("trialNo", trialNo);
		
		adminSQLMapper.insertTrial(param);
		documentSQLMapper.updateConfirmedStatusAfterJudgment(confirmedNo);
	}
	
}
