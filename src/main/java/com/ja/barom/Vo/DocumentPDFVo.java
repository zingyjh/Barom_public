package com.ja.barom.Vo;

import java.util.ArrayList;
import java.util.Date;

public class DocumentPDFVo {

	private ArrayList<PlaintiffVo> PvoList;
	private ArrayList<DefendantVo> DvoList;
	private String case_no;
	private Date CASE_SAVE_DATE;
	private String MIN_SJ_SGN_CATEGORY_NAME;
	private String MIN_SJ_COURT_CATEGORY_NAME;
	private String PURPOSE_CONTENT;
	private String CAUSE_CONTENT;
	private ArrayList<ProofFileVo> FvoList;
	
	public DocumentPDFVo() {
		super();
	}

	public DocumentPDFVo(ArrayList<PlaintiffVo> pvoList, ArrayList<DefendantVo> dvoList, String case_no,
			Date cASE_SAVE_DATE, String mIN_SJ_SGN_CATEGORY_NAME, String mIN_SJ_COURT_CATEGORY_NAME,
			String pURPOSE_CONTENT, String cAUSE_CONTENT, ArrayList<ProofFileVo> fvoList) {
		super();
		PvoList = pvoList;
		DvoList = dvoList;
		this.case_no = case_no;
		CASE_SAVE_DATE = cASE_SAVE_DATE;
		MIN_SJ_SGN_CATEGORY_NAME = mIN_SJ_SGN_CATEGORY_NAME;
		MIN_SJ_COURT_CATEGORY_NAME = mIN_SJ_COURT_CATEGORY_NAME;
		PURPOSE_CONTENT = pURPOSE_CONTENT;
		CAUSE_CONTENT = cAUSE_CONTENT;
		FvoList = fvoList;
	}

	public ArrayList<PlaintiffVo> getPvoList() {
		return PvoList;
	}

	public void setPvoList(ArrayList<PlaintiffVo> pvoList) {
		PvoList = pvoList;
	}

	public ArrayList<DefendantVo> getDvoList() {
		return DvoList;
	}

	public void setDvoList(ArrayList<DefendantVo> dvoList) {
		DvoList = dvoList;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public Date getCASE_SAVE_DATE() {
		return CASE_SAVE_DATE;
	}

	public void setCASE_SAVE_DATE(Date cASE_SAVE_DATE) {
		CASE_SAVE_DATE = cASE_SAVE_DATE;
	}

	public String getMIN_SJ_SGN_CATEGORY_NAME() {
		return MIN_SJ_SGN_CATEGORY_NAME;
	}

	public void setMIN_SJ_SGN_CATEGORY_NAME(String mIN_SJ_SGN_CATEGORY_NAME) {
		MIN_SJ_SGN_CATEGORY_NAME = mIN_SJ_SGN_CATEGORY_NAME;
	}

	public String getMIN_SJ_COURT_CATEGORY_NAME() {
		return MIN_SJ_COURT_CATEGORY_NAME;
	}

	public void setMIN_SJ_COURT_CATEGORY_NAME(String mIN_SJ_COURT_CATEGORY_NAME) {
		MIN_SJ_COURT_CATEGORY_NAME = mIN_SJ_COURT_CATEGORY_NAME;
	}

	public String getPURPOSE_CONTENT() {
		return PURPOSE_CONTENT;
	}

	public void setPURPOSE_CONTENT(String pURPOSE_CONTENT) {
		PURPOSE_CONTENT = pURPOSE_CONTENT;
	}

	public String getCAUSE_CONTENT() {
		return CAUSE_CONTENT;
	}

	public void setCAUSE_CONTENT(String cAUSE_CONTENT) {
		CAUSE_CONTENT = cAUSE_CONTENT;
	}

	public ArrayList<ProofFileVo> getFvoList() {
		return FvoList;
	}

	public void setFvoList(ArrayList<ProofFileVo> fvoList) {
		FvoList = fvoList;
	}

	

	
	
	

	
	
	
	
	
}


