package com.ja.barom.Vo;

public class TrialDocumentVo {
	
	private int trial_document_no;
	private int trial_no;
	private String trial_document_url;
	
	public TrialDocumentVo() {
		super();
	}

	public TrialDocumentVo(int trial_document_no, int trial_no, String trial_document_url) {
		super();
		this.trial_document_no = trial_document_no;
		this.trial_no = trial_no;
		this.trial_document_url = trial_document_url;
	}

	public int getTrial_document_no() {
		return trial_document_no;
	}

	public void setTrial_document_no(int trial_document_no) {
		this.trial_document_no = trial_document_no;
	}

	public int getTrial_no() {
		return trial_no;
	}

	public void setTrial_no(int trial_no) {
		this.trial_no = trial_no;
	}

	public String getTrial_document_url() {
		return trial_document_url;
	}

	public void setTrial_document_url(String trial_document_url) {
		this.trial_document_url = trial_document_url;
	}
	
	

}
