package com.ja.barom.Vo;

public class CauseVo {

	private int cause_no;
	private String case_no;
	private String cause_content;
	private String cause_attach;
	
	public CauseVo() {
		super();
	}

	public CauseVo(int cause_no, String case_no, String cause_content, String cause_attach) {
		super();
		this.cause_no = cause_no;
		this.case_no = case_no;
		this.cause_content = cause_content;
		this.cause_attach = cause_attach;
	}

	public int getCause_no() {
		return cause_no;
	}

	public void setCause_no(int cause_no) {
		this.cause_no = cause_no;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public String getCause_content() {
		return cause_content;
	}

	public void setCause_content(String cause_content) {
		this.cause_content = cause_content;
	}

	public String getCause_attach() {
		return cause_attach;
	}

	public void setCause_attach(String cause_attach) {
		this.cause_attach = cause_attach;
	}

	

	
	
}
