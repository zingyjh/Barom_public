package com.ja.barom.Vo;

import java.util.Date;

public class UserVo {
	
	private int user_no;
	private int findQuestion_no;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_jumin1;
	private String user_jumin2;
	private int user_zipcode;
	private String user_address;
	private String user_send_address;
	private String user_phone;
	private String user_email;
	private String user_state;
	private Date user_latestAccess;
	private String user_findAnswer;
	
	
	public UserVo() {
		super();
	}

	public UserVo(int user_no, int findQuestion_no, String user_id, String user_pw, String user_name,
			String user_jumin1, String user_jumin2, int user_zipcode, String user_address, String user_send_address,
			String user_phone, String user_email, String user_state, Date user_latestAccess, String user_findAnswer) {
		super();
		this.user_no = user_no;
		this.findQuestion_no = findQuestion_no;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_jumin1 = user_jumin1;
		this.user_jumin2 = user_jumin2;
		this.user_zipcode = user_zipcode;
		this.user_address = user_address;
		this.user_send_address = user_send_address;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_state = user_state;
		this.user_latestAccess = user_latestAccess;
		this.user_findAnswer = user_findAnswer;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getFindQuestion_no() {
		return findQuestion_no;
	}

	public void setFindQuestion_no(int findQuestion_no) {
		this.findQuestion_no = findQuestion_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_jumin1() {
		return user_jumin1;
	}

	public void setUser_jumin1(String user_jumin1) {
		this.user_jumin1 = user_jumin1;
	}

	public String getUser_jumin2() {
		return user_jumin2;
	}

	public void setUser_jumin2(String user_jumin2) {
		this.user_jumin2 = user_jumin2;
	}

	public int getUser_zipcode() {
		return user_zipcode;
	}

	public void setUser_zipcode(int user_zipcode) {
		this.user_zipcode = user_zipcode;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_send_address() {
		return user_send_address;
	}

	public void setUser_send_address(String user_send_address) {
		this.user_send_address = user_send_address;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public Date getUser_latestAccess() {
		return user_latestAccess;
	}

	public void setUser_latestAccess(Date user_latestAccess) {
		this.user_latestAccess = user_latestAccess;
	}

	public String getUser_findAnswer() {
		return user_findAnswer;
	}

	public void setUser_findAnswer(String user_findAnswer) {
		this.user_findAnswer = user_findAnswer;
	}
	
	
	
}