package com.ja.barom.Vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CaseVo {

	private String case_no;
	private int user_no;
	private int status_no;
	private int approval_no;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date case_save_date;
	private String case_refuse_reason;
    
	public CaseVo() {
		super();
	}

	public CaseVo(String case_no, int user_no, int status_no, int approval_no, Date case_save_date,
			String case_refuse_reason) {
		super();
		this.case_no = case_no;
		this.user_no = user_no;
		this.status_no = status_no;
		this.approval_no = approval_no;
		this.case_save_date = case_save_date;
		this.case_refuse_reason = case_refuse_reason;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getStatus_no() {
		return status_no;
	}

	public void setStatus_no(int status_no) {
		this.status_no = status_no;
	}

	public int getApproval_no() {
		return approval_no;
	}

	public void setApproval_no(int approval_no) {
		this.approval_no = approval_no;
	}

	public Date getCase_save_date() {
		return case_save_date;
	}

	public void setCase_save_date(Date case_save_date) {
		this.case_save_date = case_save_date;
	}

	public String getCase_refuse_reason() {
		return case_refuse_reason;
	}

	public void setCase_refuse_reason(String case_refuse_reason) {
		this.case_refuse_reason = case_refuse_reason;
	}

	

}