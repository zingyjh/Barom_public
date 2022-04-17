package com.ja.barom.Vo;

import java.util.Date;

public class CaseConfirmedVo {

	private String case_confirmed_no;
	private String case_no;
	private int min_sj_sgn_category_no;
	private int min_sj_court_category_no;
	private int caseconfirmed_status_no;
	private Date case_confirmed_date;
	private String case_status_reason;
	
	public CaseConfirmedVo() {
		super();
	}

	public CaseConfirmedVo(String case_confirmed_no, String case_no, int min_sj_sgn_category_no,
			int min_sj_court_category_no, int caseconfirmed_status_no, Date case_confirmed_date,
			String case_status_reason) {
		super();
		this.case_confirmed_no = case_confirmed_no;
		this.case_no = case_no;
		this.min_sj_sgn_category_no = min_sj_sgn_category_no;
		this.min_sj_court_category_no = min_sj_court_category_no;
		this.caseconfirmed_status_no = caseconfirmed_status_no;
		this.case_confirmed_date = case_confirmed_date;
		this.case_status_reason = case_status_reason;
	}

	public String getCase_confirmed_no() {
		return case_confirmed_no;
	}

	public void setCase_confirmed_no(String case_confirmed_no) {
		this.case_confirmed_no = case_confirmed_no;
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

	public int getCaseconfirmed_status_no() {
		return caseconfirmed_status_no;
	}

	public void setCaseconfirmed_status_no(int caseconfirmed_status_no) {
		this.caseconfirmed_status_no = caseconfirmed_status_no;
	}

	public Date getCase_confirmed_date() {
		return case_confirmed_date;
	}

	public void setCase_confirmed_date(Date case_confirmed_date) {
		this.case_confirmed_date = case_confirmed_date;
	}

	public String getCase_status_reason() {
		return case_status_reason;
	}

	public void setCase_status_reason(String case_status_reason) {
		this.case_status_reason = case_status_reason;
	}
	
	
}
