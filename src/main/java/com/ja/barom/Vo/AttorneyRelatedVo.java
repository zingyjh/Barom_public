package com.ja.barom.Vo;

public class AttorneyRelatedVo {

	private int attorney_related_no;
	private int concerned_no;
	private int attorney_no;
	private String attorney_related_for;
	
	public AttorneyRelatedVo() {
		super();
	}

	public AttorneyRelatedVo(int attorney_related_no, int concerned_no, int attorney_no, String attorney_related_for) {
		super();
		this.attorney_related_no = attorney_related_no;
		this.concerned_no = concerned_no;
		this.attorney_no = attorney_no;
		this.attorney_related_for = attorney_related_for;
	}

	public int getAttorney_related_no() {
		return attorney_related_no;
	}

	public void setAttorney_related_no(int attorney_related_no) {
		this.attorney_related_no = attorney_related_no;
	}

	public int getConcerned_no() {
		return concerned_no;
	}

	public void setConcerned_no(int concerned_no) {
		this.concerned_no = concerned_no;
	}

	public int getAttorney_no() {
		return attorney_no;
	}

	public void setAttorney_no(int attorney_no) {
		this.attorney_no = attorney_no;
	}

	public String getAttorney_related_for() {
		return attorney_related_for;
	}

	public void setAttorney_related_for(String attorney_related_for) {
		this.attorney_related_for = attorney_related_for;
	}
	
	
	
	
}
