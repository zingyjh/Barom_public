package com.ja.barom.Vo;

import java.util.Date;

public class CaseConfirmedProofFileVo {

	private int file_no;
	private String case_confirmed_no;
	private String file_name;
	private String file_original_name;
	private String file_extension;
	private Date file_date;
	
	public CaseConfirmedProofFileVo() {
		super();
	}

	public CaseConfirmedProofFileVo(int file_no, String case_confirmed_no, String file_name, String file_original_name,
			String file_extension, Date file_date) {
		super();
		this.file_no = file_no;
		this.case_confirmed_no = case_confirmed_no;
		this.file_name = file_name;
		this.file_original_name = file_original_name;
		this.file_extension = file_extension;
		this.file_date = file_date;
	}

	public int getFile_no() {
		return file_no;
	}

	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}

	public String getCase_confirmed_no() {
		return case_confirmed_no;
	}

	public void setCase_confirmed_no(String case_confirmed_no) {
		this.case_confirmed_no = case_confirmed_no;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_original_name() {
		return file_original_name;
	}

	public void setFile_original_name(String file_original_name) {
		this.file_original_name = file_original_name;
	}

	public String getFile_extension() {
		return file_extension;
	}

	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}

	public Date getFile_date() {
		return file_date;
	}

	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	
	
}
