package com.ja.barom.Vo;

import java.util.Date;

public class DefenseProofFileVo {

	private int file_no;
	private int Defense_no;
	private String file_name;
	private String file_original_name;
	private String file_extension;
	private Date file_date;
	
	public DefenseProofFileVo() {
		super();
	}

	public DefenseProofFileVo(int file_no, int defense_no, String file_name, String file_original_name,
			String file_extension, Date file_date) {
		super();
		this.file_no = file_no;
		Defense_no = defense_no;
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

	public int getDefense_no() {
		return Defense_no;
	}

	public void setDefense_no(int defense_no) {
		Defense_no = defense_no;
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
