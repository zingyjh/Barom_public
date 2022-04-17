package com.ja.barom.Vo;

public class DocumentPayVo {

	private int documentpay_no;
	private String case_no;
	private String pay_name;
	private String pay_user_id;
	private String pay_method;
	private int pay_price;
	private String pg_token;
	private String pay_date;
	
	public DocumentPayVo() {
		super();
	}

	public DocumentPayVo(int documentpay_no, String case_no, String pay_name, String pay_user_id, String pay_method,
			int pay_price, String pg_token, String pay_date) {
		super();
		this.documentpay_no = documentpay_no;
		this.case_no = case_no;
		this.pay_name = pay_name;
		this.pay_user_id = pay_user_id;
		this.pay_method = pay_method;
		this.pay_price = pay_price;
		this.pg_token = pg_token;
		this.pay_date = pay_date;
	}

	public int getDocumentpay_no() {
		return documentpay_no;
	}

	public void setDocumentpay_no(int documentpay_no) {
		this.documentpay_no = documentpay_no;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public String getPay_name() {
		return pay_name;
	}

	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}

	public String getPay_user_id() {
		return pay_user_id;
	}

	public void setPay_user_id(String pay_user_id) {
		this.pay_user_id = pay_user_id;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public int getPay_price() {
		return pay_price;
	}

	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}

	public String getPg_token() {
		return pg_token;
	}

	public void setPg_token(String pg_token) {
		this.pg_token = pg_token;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	
	
	
	
}
