package com.ja.barom.Vo;

public class ApprovalStatusVo {

	private int approval_no;
	private String approval_name;
	
	public ApprovalStatusVo() {
		super();
	}

	public ApprovalStatusVo(int approval_no, String approval_name) {
		super();
		this.approval_no = approval_no;
		this.approval_name = approval_name;
	}

	public int getApproval_no() {
		return approval_no;
	}

	public void setApproval_no(int approval_no) {
		this.approval_no = approval_no;
	}

	public String getApproval_name() {
		return approval_name;
	}

	public void setApproval_name(String approval_name) {
		this.approval_name = approval_name;
	}
	
	
}
