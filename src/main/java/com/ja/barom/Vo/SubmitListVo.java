package com.ja.barom.Vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SubmitListVo {

	private int checkForm;
	private int courtCategoryNo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxDate;
	private String myCaseNo;
	private int myUserNo;
	
	public SubmitListVo() {
		super();
	}

	public SubmitListVo(int checkForm, int courtCategoryNo, Date minDate, Date maxDate, String myCaseNo, int myUserNo) {
		super();
		this.checkForm = checkForm;
		this.courtCategoryNo = courtCategoryNo;
		this.minDate = minDate;
		this.maxDate = maxDate;
		this.myCaseNo = myCaseNo;
		this.myUserNo = myUserNo;
	}

	public int getCheckForm() {
		return checkForm;
	}

	public void setCheckForm(int checkForm) {
		this.checkForm = checkForm;
	}

	public int getCourtCategoryNo() {
		return courtCategoryNo;
	}

	public void setCourtCategoryNo(int courtCategoryNo) {
		this.courtCategoryNo = courtCategoryNo;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public String getMyCaseNo() {
		return myCaseNo;
	}

	public void setMyCaseNo(String myCaseNo) {
		this.myCaseNo = myCaseNo;
	}

	public int getMyUserNo() {
		return myUserNo;
	}

	public void setMyUserNo(int myUserNo) {
		this.myUserNo = myUserNo;
	}
	
	
	
	
	
	
	
	
	
}
