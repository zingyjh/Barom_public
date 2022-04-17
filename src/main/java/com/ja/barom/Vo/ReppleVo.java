package com.ja.barom.Vo;

import java.util.Date;

public class ReppleVo {
	private int repple_no;
	private int user_no;
	private int cus_question_no;
	private String repple_content;
	private Date repple_writedate;

	public ReppleVo() {
		super();
	}

	public ReppleVo(int repple_no, int user_no, int cus_question_no, String repple_content, Date repple_writedate) {
		super();
		this.repple_no = repple_no;
		this.user_no = user_no;
		this.cus_question_no = cus_question_no;
		this.repple_content = repple_content;
		this.repple_writedate = repple_writedate;
	}

	public int getRepple_no() {
		return repple_no;
	}

	public void setRepple_no(int repple_no) {
		this.repple_no = repple_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getCus_question_no() {
		return cus_question_no;
	}

	public void setCus_question_no(int cus_question_no) {
		this.cus_question_no = cus_question_no;
	}

	public String getRepple_content() {
		return repple_content;
	}

	public void setRepple_content(String repple_content) {
		this.repple_content = repple_content;
	}

	public Date getRepple_writedate() {
		return repple_writedate;
	}

	public void setRepple_writedate(Date repple_writedate) {
		this.repple_writedate = repple_writedate;
	}
}