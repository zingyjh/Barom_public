package com.ja.barom.Vo;

import java.util.Date;

public class TrialVo {

	private String trial_no;
	private String case_confirmed_no;
	private Date trial_date;
	private String trial_result_status;
	private String trial_result_order;
	private String trial_result_reason;
	
	public TrialVo() {
		super();
	}

	public TrialVo(String trial_no, String case_confirmed_no, Date trial_date, String trial_result_status,
			String trial_result_order, String trial_result_reason) {
		super();
		this.trial_no = trial_no;
		this.case_confirmed_no = case_confirmed_no;
		this.trial_date = trial_date;
		this.trial_result_status = trial_result_status;
		this.trial_result_order = trial_result_order;
		this.trial_result_reason = trial_result_reason;
	}

	public String getTrial_no() {
		return trial_no;
	}

	public void setTrial_no(String trial_no) {
		this.trial_no = trial_no;
	}

	public String getCase_confirmed_no() {
		return case_confirmed_no;
	}

	public void setCase_confirmed_no(String case_confirmed_no) {
		this.case_confirmed_no = case_confirmed_no;
	}

	public Date getTrial_date() {
		return trial_date;
	}

	public void setTrial_date(Date trial_date) {
		this.trial_date = trial_date;
	}

	public String getTrial_result_status() {
		return trial_result_status;
	}

	public void setTrial_result_status(String trial_result_status) {
		this.trial_result_status = trial_result_status;
	}

	public String getTrial_result_order() {
		return trial_result_order;
	}

	public void setTrial_result_order(String trial_result_order) {
		this.trial_result_order = trial_result_order;
	}

	public String getTrial_result_reason() {
		return trial_result_reason;
	}

	public void setTrial_result_reason(String trial_result_reason) {
		this.trial_result_reason = trial_result_reason;
	}

	
	
	
}
