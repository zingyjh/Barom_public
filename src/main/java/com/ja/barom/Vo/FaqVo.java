package com.ja.barom.Vo;

public class FaqVo {
	private int admin_no;
	private int faq_no;
	private int faq_category_no;
	private String faq_title;
	private String faq_content;
	private int faq_readcount;
	public FaqVo() {
		super();
	}
	public FaqVo(int admin_no, int faq_no, int faq_category_no, String faq_title, String faq_content,
			int faq_readcount) {
		super();
		this.admin_no = admin_no;
		this.faq_no = faq_no;
		this.faq_category_no = faq_category_no;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_readcount = faq_readcount;
	}
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public int getFaq_category_no() {
		return faq_category_no;
	}
	public void setFaq_category_no(int faq_category_no) {
		this.faq_category_no = faq_category_no;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public int getFaq_readcount() {
		return faq_readcount;
	}
	public void setFaq_readcount(int faq_readcount) {
		this.faq_readcount = faq_readcount;
	}
	
	
	
}
