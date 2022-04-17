package com.ja.barom.Vo;

public class AdminCategoryVo {

	private int admin_category_no;
	private String admin_category_name;
	
	public AdminCategoryVo() {
		super();
	}

	public AdminCategoryVo(int admin_category_no, String admin_category_name) {
		super();
		this.admin_category_no = admin_category_no;
		this.admin_category_name = admin_category_name;
	}

	public int getAdmin_category_no() {
		return admin_category_no;
	}

	public void setAdmin_category_no(int admin_category_no) {
		this.admin_category_no = admin_category_no;
	}

	public String getAdmin_category_name() {
		return admin_category_name;
	}

	public void setAdmin_category_name(String admin_category_name) {
		this.admin_category_name = admin_category_name;
	}
	
	
}
