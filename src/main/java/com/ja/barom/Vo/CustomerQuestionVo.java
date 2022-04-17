package com.ja.barom.Vo;

import java.util.Date;

public class CustomerQuestionVo {
	private int cus_question_no;
	private int user_no;
	private String cus_question_title;
	private String cus_question_content;
	private int cus_question_readcount;
	private String cus_question_secret;
	private Date cus_question_writedate;

	public CustomerQuestionVo() {
		super();
	}

	public CustomerQuestionVo(int cus_question_no, int user_no, String cus_question_title, String cus_question_content,
			int cus_question_readcount, String cus_question_secret, Date cus_question_writedate) {
		super();
		this.cus_question_no = cus_question_no;
		this.user_no = user_no;
		this.cus_question_title = cus_question_title;
		this.cus_question_content = cus_question_content;
		this.cus_question_readcount = cus_question_readcount;
		this.cus_question_secret = cus_question_secret;
		this.cus_question_writedate = cus_question_writedate;
	}

	public int getCus_question_no() {
		return cus_question_no;
	}

	public void setCus_question_no(int cus_question_no) {
		this.cus_question_no = cus_question_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getCus_question_title() {
		return cus_question_title;
	}

	public void setCus_question_title(String cus_question_title) {
		this.cus_question_title = cus_question_title;
	}

	public String getCus_question_content() {
		return cus_question_content;
	}

	public void setCus_question_content(String cus_question_content) {
		this.cus_question_content = cus_question_content;
	}

	public int getCus_question_readcount() {
		return cus_question_readcount;
	}

	public void setCus_question_readcount(int cus_question_readcount) {
		this.cus_question_readcount = cus_question_readcount;
	}

	public String getCus_question_secret() {
		return cus_question_secret;
	}

	public void setCus_question_secret(String cus_question_secret) {
		this.cus_question_secret = cus_question_secret;
	}

	public Date getCus_question_writedate() {
		return cus_question_writedate;
	}

	public void setCus_question_writedate(Date cus_question_writedate) {
		this.cus_question_writedate = cus_question_writedate;
	}
}