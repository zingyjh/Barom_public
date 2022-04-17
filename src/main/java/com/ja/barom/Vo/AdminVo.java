package com.ja.barom.Vo;

public class AdminVo {

	private int admin_no;
	private int min_sj_court_category_no;
	private int admin_category_no;
	private String admin_id;
	private String admin_pw;
	
	public AdminVo() {
		super();
	}

	public AdminVo(int admin_no, int min_sj_court_category_no, int admin_category_no, String admin_id,
			String admin_pw) {
		super();
		this.admin_no = admin_no;
		this.min_sj_court_category_no = min_sj_court_category_no;
		this.admin_category_no = admin_category_no;
		this.admin_id = admin_id;
		this.admin_pw = admin_pw;
	}

	public int getAdmin_no() {
		return admin_no;
	}

	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}

	public int getMin_sj_court_category_no() {
		return min_sj_court_category_no;
	}

	public void setMin_sj_court_category_no(int min_sj_court_category_no) {
		this.min_sj_court_category_no = min_sj_court_category_no;
	}

	public int getAdmin_category_no() {
		return admin_category_no;
	}

	public void setAdmin_category_no(int admin_category_no) {
		this.admin_category_no = admin_category_no;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_pw() {
		return admin_pw;
	}

	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	
	
}
