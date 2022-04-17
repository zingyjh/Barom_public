package com.ja.barom.Vo;

public class AttorneyVo {

	private int attorney_no;
	private String attorney_personal;
	private String attorney_resident_num;
	private String attorney_name;
	private int attorney_zipcode;
	private String attorney_address;
	private String attorney_send_address;
	private String attorney_phone;
	private String attorney_email;
	
	public AttorneyVo() {
		super();
	}

	public AttorneyVo(int attorney_no, String attorney_personal, String attorney_resident_num, String attorney_name,
			int attorney_zipcode, String attorney_address, String attorney_send_address, String attorney_phone,
			String attorney_email) {
		super();
		this.attorney_no = attorney_no;
		this.attorney_personal = attorney_personal;
		this.attorney_resident_num = attorney_resident_num;
		this.attorney_name = attorney_name;
		this.attorney_zipcode = attorney_zipcode;
		this.attorney_address = attorney_address;
		this.attorney_send_address = attorney_send_address;
		this.attorney_phone = attorney_phone;
		this.attorney_email = attorney_email;
	}

	public int getAttorney_no() {
		return attorney_no;
	}

	public void setAttorney_no(int attorney_no) {
		this.attorney_no = attorney_no;
	}

	public String getAttorney_personal() {
		return attorney_personal;
	}

	public void setAttorney_personal(String attorney_personal) {
		this.attorney_personal = attorney_personal;
	}

	public String getAttorney_resident_num() {
		return attorney_resident_num;
	}

	public void setAttorney_resident_num(String attorney_resident_num) {
		this.attorney_resident_num = attorney_resident_num;
	}

	public String getAttorney_name() {
		return attorney_name;
	}

	public void setAttorney_name(String attorney_name) {
		this.attorney_name = attorney_name;
	}

	public int getAttorney_zipcode() {
		return attorney_zipcode;
	}

	public void setAttorney_zipcode(int attorney_zipcode) {
		this.attorney_zipcode = attorney_zipcode;
	}

	public String getAttorney_address() {
		return attorney_address;
	}

	public void setAttorney_address(String attorney_address) {
		this.attorney_address = attorney_address;
	}

	public String getAttorney_send_address() {
		return attorney_send_address;
	}

	public void setAttorney_send_address(String attorney_send_address) {
		this.attorney_send_address = attorney_send_address;
	}

	public String getAttorney_phone() {
		return attorney_phone;
	}

	public void setAttorney_phone(String attorney_phone) {
		this.attorney_phone = attorney_phone;
	}

	public String getAttorney_email() {
		return attorney_email;
	}

	public void setAttorney_email(String attorney_email) {
		this.attorney_email = attorney_email;
	}
	
	
	
}
