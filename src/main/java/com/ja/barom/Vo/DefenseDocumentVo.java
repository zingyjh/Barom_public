package com.ja.barom.Vo;

public class DefenseDocumentVo {
	
	private int document_no;
	private int Defense_no;
	private String document_url;
	
	public DefenseDocumentVo() {
		super();
	}

	public DefenseDocumentVo(int document_no, int defense_no, String document_url) {
		super();
		this.document_no = document_no;
		Defense_no = defense_no;
		this.document_url = document_url;
	}

	public int getDocument_no() {
		return document_no;
	}

	public void setDocument_no(int document_no) {
		this.document_no = document_no;
	}

	public int getDefense_no() {
		return Defense_no;
	}

	public void setDefense_no(int defense_no) {
		Defense_no = defense_no;
	}

	public String getDocument_url() {
		return document_url;
	}

	public void setDocument_url(String document_url) {
		this.document_url = document_url;
	}
	
	

}
