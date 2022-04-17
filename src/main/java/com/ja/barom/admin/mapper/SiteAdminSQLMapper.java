package com.ja.barom.admin.mapper;

import java.util.ArrayList;

import com.ja.barom.Vo.AnncmFilesVo;
import com.ja.barom.Vo.AnnouncementVo;
import com.ja.barom.Vo.FAQ_CategoryVo;
import com.ja.barom.Vo.FaqVo;

public interface SiteAdminSQLMapper {
	
	//// FAQ 관련
	
	public void insertFaq(FaqVo vo);
	
	public ArrayList<FAQ_CategoryVo> getFAQ_CategoryList();
	
	public FAQ_CategoryVo getFaq_category_no(int no);
		
	public ArrayList<FaqVo> getFaqList();
		
	public FaqVo getFaqByNo(int faqNo);
	
	
	
	
	//// 공지사항 관련
	
	
	// (관리자-공통) 공지사항 목록을 조회한다
			public ArrayList<AnnouncementVo> getAnncmList();
		// (관리자-공통) 첨부파일 유무를 확인한다 
			public int getCountIsExistAnncmFiles (int anncmNo);
		// (관리자-공통) 공지사항 상세 내용(파일, 첨부)을 조회한다 
			public AnnouncementVo getAnncmByNo(int anncmNo);
			public ArrayList<AnncmFilesVo> getAnncmFiles(int anncmNo);
		
			
		// (관리자) 공지사항 글번호를 생성한다
			public int createAnncmNo();
			
					
		// (관리자) 공지사항을 작성한다, 파일을 첨부한다
			public void insertAnncm(AnnouncementVo vo);
			public void insertAnncmFiles(AnncmFilesVo vo);
		// (관리자) 공지사항 본문, 첨부를 삭제한다
			public void deleteAnncm(int anncmNo);
			public void deleteAnncmFiles(int anncmNo);
		// (관리자) 공지사항의 본문을 수정한다
			public void updateAnncm(AnnouncementVo vo);
	

}