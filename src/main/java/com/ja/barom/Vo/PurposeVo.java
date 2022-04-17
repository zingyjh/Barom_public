package com.ja.barom.Vo;

public class PurposeVo {

	private int purpose_no;
	private String case_no;
	private String purpose_content;
	private String purpose_attach;
	
	public PurposeVo() {
		super();
	}

	public PurposeVo(int purpose_no, String case_no, String purpose_content, String purpose_attach) {
		super();
		this.purpose_no = purpose_no;
		this.case_no = case_no;
		this.purpose_content = purpose_content;
		this.purpose_attach = purpose_attach;
	}

	public int getPurpose_no() {
		return purpose_no;
	}

	public void setPurpose_no(int purpose_no) {
		this.purpose_no = purpose_no;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public String getPurpose_content() {
		return purpose_content;
	}

	public void setPurpose_content(String purpose_content) {
		this.purpose_content = purpose_content;
	}

	public String getPurpose_attach() {
		return purpose_attach;
	}

	public void setPurpose_attach(String purpose_attach) {
		this.purpose_attach = purpose_attach;
	}

	
	
}
