package com.ja.barom.Vo;

public class FAQ_CategoryVo {
	
	private int faq_category_no;
	private String faq_category_name;
	
	public FAQ_CategoryVo() {
		super();
	}

	public FAQ_CategoryVo(int faq_category_no, String faq_category_name) {
		super();
		this.faq_category_no = faq_category_no;
		this.faq_category_name = faq_category_name;
	}

	public int getFaq_category_no() {
		return faq_category_no;
	}

	public void setFaq_category_no(int faq_category_no) {
		this.faq_category_no = faq_category_no;
	}

	public String getFaq_category_name() {
		return faq_category_name;
	}

	public void setFaq_category_name(String faq_category_name) {
		this.faq_category_name = faq_category_name;
	}
	
	

}
