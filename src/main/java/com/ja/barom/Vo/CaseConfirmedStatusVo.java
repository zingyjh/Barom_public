package com.ja.barom.Vo;

public class CaseConfirmedStatusVo {

	private int caseconfirmed_status_no;
	private String caseconfirmed_status_name;
	
	public CaseConfirmedStatusVo() {
		super();
	}

	public CaseConfirmedStatusVo(int caseconfirmed_status_no, String caseconfirmed_status_name) {
		super();
		this.caseconfirmed_status_no = caseconfirmed_status_no;
		this.caseconfirmed_status_name = caseconfirmed_status_name;
	}
	
	public int getCaseconfirmed_status_no() {
		return caseconfirmed_status_no;
	}
	public void setCaseconfirmed_status_no(int caseconfirmed_status_no) {
		this.caseconfirmed_status_no = caseconfirmed_status_no;
	}
	public String getCaseconfirmed_status_name() {
		return caseconfirmed_status_name;
	}
	public void setCaseconfirmed_status_name(String caseconfirmed_status_name) {
		this.caseconfirmed_status_name = caseconfirmed_status_name;
	}
	
	
}
