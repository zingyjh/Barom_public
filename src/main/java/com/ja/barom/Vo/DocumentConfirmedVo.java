package com.ja.barom.Vo;

public class DocumentConfirmedVo {

	private int confirmed_no;
	private String case_no;
	private String confirmed_url;
	
	public DocumentConfirmedVo() {
		super();
	}

	public DocumentConfirmedVo(int confirmed_no, String case_no, String confirmed_url) {
		super();
		this.confirmed_no = confirmed_no;
		this.case_no = case_no;
		this.confirmed_url = confirmed_url;
	}

	public int getConfirmed_no() {
		return confirmed_no;
	}

	public void setConfirmed_no(int confirmed_no) {
		this.confirmed_no = confirmed_no;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public String getConfirmed_url() {
		return confirmed_url;
	}

	public void setConfirmed_url(String confirmed_url) {
		this.confirmed_url = confirmed_url;
	}

	
	
	
}
