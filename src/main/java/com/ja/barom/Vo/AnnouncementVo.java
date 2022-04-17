package com.ja.barom.Vo;

import java.sql.Date;

public class AnnouncementVo {

	 	private int anncm_no;
	 	private int admin_no;
	 	private String anncm_title;
	 	private String anncm_content;
	 	private Date anncm_writedate;
	 	private int anncm_readcount;
	
	 	
	 	public AnnouncementVo() {
	 		super();
	 	}
	
	 	public AnnouncementVo(int anncm_no,  int admin_no, String anncm_title, String anncm_content, Date anncm_writedate, int anncm_readcount) {
	 		super();
	 		this.anncm_no = anncm_no;
	 		this.admin_no = admin_no;
	 		this.anncm_title = anncm_title;
	 		this.anncm_content = anncm_content;
	 		this.anncm_writedate = anncm_writedate;
	 		this.anncm_readcount = anncm_readcount;
	 	}

	 	
	 	public int getAnncm_no() {
	 		return anncm_no;
	 	}
	 	
	 	public void setAnncm_no(int anncm_no) {
	 		this.anncm_no = anncm_no;
	 	}

		public int getAdmin_no() {
			return admin_no;
		}

		public void setAdmin_no(int admin_no) {
			this.admin_no = admin_no;
		}

		public String getAnncm_title() {
			return anncm_title;
		}

		public void setAnncm_title(String anncm_title) {
			this.anncm_title = anncm_title;
		}

		public String getAnncm_content() {
			return anncm_content;
		}

		public void setAnncm_content(String anncm_content) {
			this.anncm_content = anncm_content;
		}

		public Date getAnncm_writedate() {
			return anncm_writedate;
		}

		public void setAnncm_writedate(Date anncm_writedate) {
			this.anncm_writedate = anncm_writedate;
		}

		public int getAnncm_readcount() {
			return anncm_readcount;
		}

		public void setAnncm_readcount(int anncm_readcount) {
			this.anncm_readcount = anncm_readcount;
		}
	 	
	 	
	 	// 작업 계속 확인
	 	
	 	
	 	
	 	
}
