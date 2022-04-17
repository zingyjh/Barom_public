package com.ja.barom.Vo;

public class AnncmFilesVo {

			private int anncm_files_no;
			private int anncm_no;
			private String anncm_files_url;
			private String anncm_original_filename	;
	
	
			
			public AnncmFilesVo(){
				super();
			}
			
			public AnncmFilesVo(int anncm_files_no, int anncm_no, String anncm_files_url, String anncm_original_filename){
				this.anncm_files_no = anncm_files_no;
				this.anncm_no = anncm_no;
				this.anncm_files_url = anncm_files_url;
				this.anncm_original_filename = anncm_original_filename;
			}
			
			
			public int getAnncm_files_no() {
				return anncm_files_no;
			}
			
			public void setAnncm_files_no(int anncm_files_no) {
				this.anncm_files_no = anncm_files_no;
			}

			public int getAnncm_no() {
				return anncm_no;
			}

			public void setAnncm_no(int anncm_no) {
				this.anncm_no = anncm_no;
			}

			public String getAnncm_files_url() {
				return anncm_files_url;
			}

			public void setAnncm_files_url(String anncm_files_url) {
				this.anncm_files_url = anncm_files_url;
			}

			public String getAnncm_original_filename() {
				return anncm_original_filename;
			}

			public void setAnncm_original_filename(String anncm_original_filename) {
				this.anncm_original_filename = anncm_original_filename;
			}
			
			
			
			
			
			
}
