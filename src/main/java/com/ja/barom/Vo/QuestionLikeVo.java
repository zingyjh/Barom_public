package com.ja.barom.Vo;

import java.util.Date;

public class QuestionLikeVo {
	private int like_no;
	private int user_no;
	private int cus_question_no;
	private Date like_date;
	
	public QuestionLikeVo() {
		super();
	}

	public int getLike_no() {
		return like_no;
	}

	public void setLike_no(int like_no) {
		this.like_no = like_no;
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

	public Date getLike_date() {
		return like_date;
	}

	public void setLike_date(Date like_date) {
		this.like_date = like_date;
	}
}
