package com.ja.barom.Vo;

public class DefendantCaseVo {

	private int defendant_case_no;
	private String case_confirmed_no;
	private int user_no;
	
	public DefendantCaseVo() {
		super();
	}

	public DefendantCaseVo(int defendant_case_no, String case_confirmed_no, int user_no) {
		super();
		this.defendant_case_no = defendant_case_no;
		this.case_confirmed_no = case_confirmed_no;
		this.user_no = user_no;
	}

	public int getDefendant_case_no() {
		return defendant_case_no;
	}

	public void setDefendant_case_no(int defendant_case_no) {
		this.defendant_case_no = defendant_case_no;
	}

	public String getCase_confirmed_no() {
		return case_confirmed_no;
	}

	public void setCase_confirmed_no(String case_confirmed_no) {
		this.case_confirmed_no = case_confirmed_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	
	
}
