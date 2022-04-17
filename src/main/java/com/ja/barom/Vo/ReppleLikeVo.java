package com.ja.barom.Vo;

import java.util.Date;

public class ReppleLikeVo {
	private int like_no;
	private int user_no;
	private int repple_no;
	private Date like_date;

	public ReppleLikeVo() {
		super();
	}

	public ReppleLikeVo(int like_no, int user_no, int repple_no, Date like_date) {
		super();
		this.like_no = like_no;
		this.user_no = user_no;
		this.repple_no = repple_no;
		this.like_date = like_date;
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

	public int getRepple_no() {
		return repple_no;
	}

	public void setRepple_no(int repple_no) {
		this.repple_no = repple_no;
	}

	public Date getLike_date() {
		return like_date;
	}

	public void setLike_date(Date like_date) {
		this.like_date = like_date;
	}
}