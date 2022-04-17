package com.ja.barom.admin.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;


import com.ja.barom.Vo.AdminVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.TrialVo;
import com.ja.barom.Vo.CaseConfirmedVo;
import com.ja.barom.Vo.CaseConfirmedStatusVo;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public interface AdminSQLMapper {

	
	public AdminVo getAdminByIdAndPw (AdminVo vo);
	

	public String createCaseConfrimedPk ();
	
	public ArrayList<HashMap<String, Object>> getcaseList(HashMap<String, Object> param);
	
	
	public void insertCaseConfirmed(CaseConfirmedVo vo);
	
	public void updateCaseStatus(String no);
	
	public void refuseCaseStatus(CaseVo vo);

	// CourtAdmin 관련
	public ArrayList<HashMap<String, Object>> getCaseConfirmedAndAnsweredList (HashMap<String, Object> param);
	public ArrayList<CaseConfirmedStatusVo> getCaseConfirmedStatusList ();
	public ArrayList<String> getCaseConfirmedAgreeList ();
	public ArrayList<String> getCaseConfiremdJudgeList ();
	public int createTrialPk ();
	public void insertTrial (HashMap<String, Object> param);

}
