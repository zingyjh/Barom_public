package com.ja.barom.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.barom.Vo.AdminVo;
import com.ja.barom.Vo.AnncmFilesVo;
import com.ja.barom.Vo.AnnouncementVo;
import com.ja.barom.Vo.FAQ_CategoryVo;
import com.ja.barom.Vo.FaqVo;
import com.ja.barom.admin.mapper.SiteAdminSQLMapper;

@Service
public class SiteAdminService {

		@Autowired
		private SiteAdminSQLMapper siteAdminSQLMapper;
		
	
		

	//// FAQ 관련
		
		
				public void writeFaq(FaqVo vo) {
					siteAdminSQLMapper.insertFaq(vo);
							
				}
				
				
				public ArrayList<FAQ_CategoryVo> getFAQ_CategoryList(){
					return siteAdminSQLMapper.getFAQ_CategoryList();
				}
				
				
				
				
				public ArrayList<HashMap<String, Object>> getFaqList() {
					
					ArrayList<HashMap<String, Object>> faqlist = new ArrayList<HashMap<String, Object>>();
					
					ArrayList<FaqVo> faqVoList = siteAdminSQLMapper.getFaqList();
					
					for(FaqVo faqVo : faqVoList) {			
						
						
						int faq_category_no = faqVo.getFaq_category_no();
						FAQ_CategoryVo faq_categoryVo = siteAdminSQLMapper.getFaq_category_no(faq_category_no);
						
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("faq_categoryVo", faq_categoryVo);
						map.put("faqVo", faqVo);
						
						faqlist.add(map);
					}
					
					return faqlist;
					
				}
				
				
				public HashMap<String,Object> getFaq(int faq_no){
					
					HashMap<String,Object> map = new HashMap<String,Object>();
					
					FaqVo faqVo = siteAdminSQLMapper.getFaqByNo(faq_no);
					
					int faq_category_no = faqVo.getFaq_category_no();
					FAQ_CategoryVo faq_categoryVo = siteAdminSQLMapper.getFaq_category_no(faq_category_no);
					
					map.put("faqVo", faqVo);
					map.put("FAQ_CategoryVo", faq_categoryVo);
					
					return map;
					
				}
			
			
		
		
				//// 공지사항 관련
				
				
//				(공통-관리자) 공지사항 목록 조회, 첨부파일 유무 확인
				public ArrayList<HashMap<String, Object>> getAnncmList() {
					
					ArrayList<HashMap<String, Object>> AnncmLines = new ArrayList<HashMap<String, Object>>();
					
						ArrayList<AnnouncementVo> AnncmVoList = siteAdminSQLMapper.getAnncmList();
								
								for (AnnouncementVo announcementVo : AnncmVoList) {
									int anncmNo = announcementVo.getAnncm_no();
									int isExistFiles = siteAdminSQLMapper.getCountIsExistAnncmFiles(anncmNo);

									HashMap<String, Object> map = new HashMap<String, Object>();
									map.put("announcementVo", announcementVo);
									map.put("isExistFiles", isExistFiles);
									AnncmLines.add(map);
								}

						return AnncmLines;
				}
			
//				(공통-관리자) 공지사항 상세 내용 조회
				public HashMap<String, Object> getAnncm(int anncm_no){
					
						AnnouncementVo announcementVo =  siteAdminSQLMapper.getAnncmByNo(anncm_no);
						ArrayList<AnncmFilesVo> anncmFilesVo = siteAdminSQLMapper.getAnncmFiles(anncm_no);
					
						HashMap<String, Object> map = new HashMap<String, Object>();
								
								map.put("announcementVo", announcementVo);
								map.put("anncmFilesVo", anncmFilesVo);
					
					return map;
				}
				
//		  	(관리자) 공지사항을 작성한다, 파일을 첨부한다
				public void writeAnncm(AnnouncementVo AnncmVo, ArrayList<AnncmFilesVo> anncmFilesVoList) {
						
					int AnncmNo = siteAdminSQLMapper.createAnncmNo();	
					
					AnncmVo.setAnncm_no(AnncmNo);
					siteAdminSQLMapper.insertAnncm(AnncmVo);
						
						for (AnncmFilesVo anncmFilesVo : anncmFilesVoList)	{
							
								anncmFilesVo.setAnncm_no(AnncmNo);
								siteAdminSQLMapper.insertAnncmFiles(anncmFilesVo);
						}
					
				}
				
//				(관리자) 공지사항 본문, 첨부를 삭제한다
				public void deleteAnncm(int anncm_no) {
						siteAdminSQLMapper.deleteAnncm(anncm_no);
						siteAdminSQLMapper.deleteAnncmFiles(anncm_no);
				}
				
//				(관리자) 공지사항 본문을 수정한다
				public void updateAnncm(AnnouncementVo vo) {
						siteAdminSQLMapper.updateAnncm(vo);
				}
		
}