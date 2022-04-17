package com.ja.barom.Vo;

public class CaseBasicInfoVo {

	private int caseBasicInfo_no;
	private String case_no;
	private int min_sj_sgn_category_no;
	private int min_sj_court_category_no;
	private String caseBasicInfo_claim_method;
	private String caseBasicInfo_price_method;
	private int caseBasicInfo_price;
	
	public CaseBasicInfoVo() {
		super();
	}
	
	public CaseBasicInfoVo(int caseBasicInfo_no, String case_no, int min_sj_sgn_category_no,
			int min_sj_court_category_no, String caseBasicInfo_claim_method, String caseBasicInfo_price_method,
			int caseBasicInfo_price) {
		super();
		this.caseBasicInfo_no = caseBasicInfo_no;
		this.case_no = case_no;
		this.min_sj_sgn_category_no = min_sj_sgn_category_no;
		this.min_sj_court_category_no = min_sj_court_category_no;
		this.caseBasicInfo_claim_method = caseBasicInfo_claim_method;
		this.caseBasicInfo_price_method = caseBasicInfo_price_method;
		this.caseBasicInfo_price = caseBasicInfo_price;
	}

	public int getCaseBasicInfo_no() {
		return caseBasicInfo_no;
	}
	public void setCaseBasicInfo_no(int caseBasicInfo_no) {
		this.caseBasicInfo_no = caseBasicInfo_no;
	}
	public String getCase_no() {
		return case_no;
	}
	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}
	public int getMin_sj_sgn_category_no() {
		return min_sj_sgn_category_no;
	}
	public void setMin_sj_sgn_category_no(int min_sj_sgn_category_no) {
		this.min_sj_sgn_category_no = min_sj_sgn_category_no;
	}
	public int getMin_sj_court_category_no() {
		return min_sj_court_category_no;
	}
	public void setMin_sj_court_category_no(int min_sj_court_category_no) {
		this.min_sj_court_category_no = min_sj_court_category_no;
	}
	public String getCaseBasicInfo_claim_method() {
		return caseBasicInfo_claim_method;
	}
	public void setCaseBasicInfo_claim_method(String caseBasicInfo_claim_method) {
		this.caseBasicInfo_claim_method = caseBasicInfo_claim_method;
	}
	public String getCaseBasicInfo_price_method() {
		return caseBasicInfo_price_method;
	}
	public void setCaseBasicInfo_price_method(String caseBasicInfo_price_method) {
		this.caseBasicInfo_price_method = caseBasicInfo_price_method;
	}
	public int getCaseBasicInfo_price() {
		return caseBasicInfo_price;
	}
	public void setCaseBasicInfo_price(int caseBasicInfo_price) {
		this.caseBasicInfo_price = caseBasicInfo_price;
	}
	
	
}
