package com.ja.barom.Vo;

public class DefendantVo {

	private int defendant_no;
	private String case_no;
	private String defendant_personal;
	private String defendant_resident_num;
	private String defendant_name;
	private String defendant_zipcode;
	private String defendant_address;
	private String defendant_send_address;
	private String defendant_nationality;
	private String defendant_phone;
	private String defendant_email;
	
	public DefendantVo() {
		super();
	}

	public DefendantVo(int defendant_no, String case_no, String defendant_personal, String defendant_resident_num,
			String defendant_name, String defendant_zipcode, String defendant_address, String defendant_send_address,
			String defendant_nationality, String defendant_phone, String defendant_email) {
		super();
		this.defendant_no = defendant_no;
		this.case_no = case_no;
		this.defendant_personal = defendant_personal;
		this.defendant_resident_num = defendant_resident_num;
		this.defendant_name = defendant_name;
		this.defendant_zipcode = defendant_zipcode;
		this.defendant_address = defendant_address;
		this.defendant_send_address = defendant_send_address;
		this.defendant_nationality = defendant_nationality;
		this.defendant_phone = defendant_phone;
		this.defendant_email = defendant_email;
	}

	public int getDefendant_no() {
		return defendant_no;
	}

	public void setDefendant_no(int defendant_no) {
		this.defendant_no = defendant_no;
	}

	public String getCase_no() {
		return case_no;
	}

	public void setCase_no(String case_no) {
		this.case_no = case_no;
	}

	public String getDefendant_personal() {
		return defendant_personal;
	}

	public void setDefendant_personal(String defendant_personal) {
		this.defendant_personal = defendant_personal;
	}

	public String getDefendant_resident_num() {
		return defendant_resident_num;
	}

	public void setDefendant_resident_num(String defendant_resident_num) {
		this.defendant_resident_num = defendant_resident_num;
	}

	public String getDefendant_name() {
		return defendant_name;
	}

	public void setDefendant_name(String defendant_name) {
		this.defendant_name = defendant_name;
	}

	public String getDefendant_zipcode() {
		return defendant_zipcode;
	}

	public void setDefendant_zipcode(String defendant_zipcode) {
		this.defendant_zipcode = defendant_zipcode;
	}

	public String getDefendant_address() {
		return defendant_address;
	}

	public void setDefendant_address(String defendant_address) {
		this.defendant_address = defendant_address;
	}

	public String getDefendant_send_address() {
		return defendant_send_address;
	}

	public void setDefendant_send_address(String defendant_send_address) {
		this.defendant_send_address = defendant_send_address;
	}

	public String getDefendant_nationality() {
		return defendant_nationality;
	}

	public void setDefendant_nationality(String defendant_nationality) {
		this.defendant_nationality = defendant_nationality;
	}

	public String getDefendant_phone() {
		return defendant_phone;
	}

	public void setDefendant_phone(String defendant_phone) {
		this.defendant_phone = defendant_phone;
	}

	public String getDefendant_email() {
		return defendant_email;
	}

	public void setDefendant_email(String defendant_email) {
		this.defendant_email = defendant_email;
	}

	
}
