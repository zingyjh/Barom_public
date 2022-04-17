package com.ja.barom.Vo;

public class PlaintiffVo {

	private int plaintiff_no;
	private String case_no;
	private String plaintiff_personal;
	private String plaintiff_selected;
	private String plaintiff_resident_num;
	private String plaintiff_name;
	private String plaintiff_zipcode;
	private String plaintiff_address;
	private String plaintiff_send_address;
	private String plaintiff_nationality;
	private String plaintiff_phone;
	private String plaintiff_email;
	
	public PlaintiffVo() {
		super();
	}

	public PlaintiffVo(int plaintiff_no, String case_no, String plaintiff_personal, String plaintiff_selected,
			String plaintiff_resident_num, String plaintiff_name, String plaintiff_zipcode, String plaintiff_address,
			String plaintiff_send_address, String plaintiff_nationality, String plaintiff_phone,
			String plaintiff_email) {
		super();
		this.plaintiff_no = plaintiff_no;
		this.case_no = case_no;
		this.plaintiff_personal = plaintiff_personal;
		this.plaintiff_selected = plaintiff_selected;
		this.plaintiff_resident_num = plaintiff_resident_num;
		this.plaintiff_name = plaintiff_name;
		this.plaintiff_zipcode = plaintiff_zipcode;
		this.plaintiff_address = plaintiff_address;
		this.plaintiff_send_address = plaintiff_send_address;
		this.plaintiff_nationality = plaintiff_nationality;
		this.plaintiff_phone = plaintiff_phone;
		this.plaintiff_email = plaintiff_email;
	}

	public int getPlaintiff_no() {
		return plaintiff_no;
	}

	public void setPlaintiff_no(int plaintiff_no) {
		this.plaintiff_no = plaintiff_no;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public String getPlaintiff_personal() {
		return plaintiff_personal;
	}

	public void setPlaintiff_personal(String plaintiff_personal) {
		this.plaintiff_personal = plaintiff_personal;
	}

	public String getPlaintiff_selected() {
		return plaintiff_selected;
	}

	public void setPlaintiff_selected(String plaintiff_selected) {
		this.plaintiff_selected = plaintiff_selected;
	}

	public String getPlaintiff_resident_num() {
		return plaintiff_resident_num;
	}

	public void setPlaintiff_resident_num(String plaintiff_resident_num) {
		this.plaintiff_resident_num = plaintiff_resident_num;
	}

	public String getPlaintiff_name() {
		return plaintiff_name;
	}

	public void setPlaintiff_name(String plaintiff_name) {
		this.plaintiff_name = plaintiff_name;
	}

	public String getPlaintiff_zipcode() {
		return plaintiff_zipcode;
	}

	public void setPlaintiff_zipcode(String plaintiff_zipcode) {
		this.plaintiff_zipcode = plaintiff_zipcode;
	}

	public String getPlaintiff_address() {
		return plaintiff_address;
	}

	public void setPlaintiff_address(String plaintiff_address) {
		this.plaintiff_address = plaintiff_address;
	}

	public String getPlaintiff_send_address() {
		return plaintiff_send_address;
	}

	public void setPlaintiff_send_address(String plaintiff_send_address) {
		this.plaintiff_send_address = plaintiff_send_address;
	}

	public String getPlaintiff_nationality() {
		return plaintiff_nationality;
	}

	public void setPlaintiff_nationality(String plaintiff_nationality) {
		this.plaintiff_nationality = plaintiff_nationality;
	}

	public String getPlaintiff_phone() {
		return plaintiff_phone;
	}

	public void setPlaintiff_phone(String plaintiff_phone) {
		this.plaintiff_phone = plaintiff_phone;
	}

	public String getPlaintiff_email() {
		return plaintiff_email;
	}

	public void setPlaintiff_email(String plaintiff_email) {
		this.plaintiff_email = plaintiff_email;
	}

	

}
