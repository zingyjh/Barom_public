package com.ja.barom.Vo;

import java.util.Date;

public class DefenseVo {

	private int defense_no;
	private String case_confirmed_no;
	private int user_no;
	private String cause_answer_content;
	private String purpose_answer_content;
	private Date defense_date;
	
	public DefenseVo() {
		super();
	}

	public DefenseVo(int defense_no, String case_confirmed_no, int user_no, String cause_answer_content,
			String purpose_answer_content, Date defense_date) {
		super();
		this.defense_no = defense_no;
		this.case_confirmed_no = case_confirmed_no;
		this.user_no = user_no;
		this.cause_answer_content = cause_answer_content;
		this.purpose_answer_content = purpose_answer_content;
		this.defense_date = defense_date;
	}

	public int getDefense_no() {
		return defense_no;
	}

	public void setDefense_no(int defense_no) {
		this.defense_no = defense_no;
	}

	public String getCase_confirmed_no() {
		return case_confirmed_no;
	}

	public void setCase_confirmed_no(String case_confirmed_no) {
		this.case_confirmed_no = case_confirmed_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getCause_answer_content() {
		return cause_answer_content;
	}

	public void setCause_answer_content(String cause_answer_content) {
		this.cause_answer_content = cause_answer_content;
	}

	public String getPurpose_answer_content() {
		return purpose_answer_content;
	}

	public void setPurpose_answer_content(String purpose_answer_content) {
		this.purpose_answer_content = purpose_answer_content;
	}

	public Date getDefense_date() {
		return defense_date;
	}

	public void setDefense_date(Date defense_date) {
		this.defense_date = defense_date;
	}

	

	
	
}
