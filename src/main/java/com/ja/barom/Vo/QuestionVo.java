package com.ja.barom.Vo;

public class QuestionVo {
	
	private int findQuestion_no;
	private String findQuestion_content;
	
	public QuestionVo(int findQuestion_no, String findQuestion_content) {
		super();
		this.findQuestion_no = findQuestion_no;
		this.findQuestion_content = findQuestion_content;
	}
	public QuestionVo() {
		super();
	}
	public int getFindQuestion_no() {
		return findQuestion_no;
	}
	public void setFindQuestion_no(int findQuestion_no) {
		this.findQuestion_no = findQuestion_no;
	}
	public String getFindQuestion_content() {
		return findQuestion_content;
	}
	public void setFindQuestion_content(String findQuestion_content) {
		this.findQuestion_content = findQuestion_content;
	}
	
	
}
