package com.ja.barom.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.beans.factory.annotation.Autowired;

import com.ja.barom.Vo.CaseBasicInfoVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DefenseVo;
import com.ja.barom.Vo.DocumentConfirmedVo;
import com.ja.barom.Vo.DocumentPDFVo;
import com.ja.barom.Vo.Min_Sj_Sgn_CategoryVo;
import com.ja.barom.Vo.PlaintiffVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.PurposeVo;
import com.ja.barom.Vo.TrialDocumentVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.document.mapper.DocumentSQLMapper;
import com.sun.corba.se.impl.orbutil.DenseIntMapImpl;
import com.ja.barom.Vo.DefenseDocumentVo;
import com.ja.barom.Vo.DefenseProofFileVo;

public class CreatePdf {
	
	public static DocumentConfirmedVo insertPdf (DocumentPDFVo PdfVo) throws IOException {
		
	String CaseNo = PdfVo.getCase_no();
	
	//로컬 설정
	// String uploadFolder = "C:/uploadFolder/PDF/Document/";
	//서버 설정
	String uploadFolder = "/uploadFolder/PDF/Document/";

	String urlFolder = "PDF/Document/";
	
	Date today = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
	String folderPath = sdf.format(today);
	File todayFolder = new File(uploadFolder + folderPath);
	
	if(!todayFolder.exists()) {
		todayFolder.mkdirs();
	}
	
	String fileName = "";
	fileName += CaseNo + "_";
	
	long currentTime = System.currentTimeMillis();
	fileName += "_" + currentTime;
	
	UUID uuid = UUID.randomUUID();	// 랜덤 문자열
	fileName += uuid.toString();
	
	// PDF 생성
	// 문서 객체 생성
	PDDocument document = new PDDocument();

	// 빈페이지 생성
	PDPage newPage = new PDPage();

	// 빈페이지 문서에 추가
	document.addPage(newPage);

	// 컨텐츠 스트림 열기

	PDPageContentStream contentStream = new PDPageContentStream(document, newPage);

	// ttf 폰트 사용하기
//	 InputStream fontStream = new FileInputStream("C:/tmp/main.ttf");
	// 로컬 설정
	//  InputStream fontStream = new FileInputStream("C:/font/main.ttf");
	// 서버 설정
	InputStream fontStream = new FileInputStream("/font/main.ttf");

	
	PDType0Font fontGulim = PDType0Font.load(document, fontStream);
	
	//
	contentStream.setLeading(41.5f); //행간
	contentStream.beginText();
	
	// 넣을 정보들 
	
	// 1. 원고
	ArrayList<PlaintiffVo> PlaintifList = PdfVo.getPvoList();
	PlaintiffVo firstPlaintif = PlaintifList.get(0);
	String plaintifNationalName = firstPlaintif.getPlaintiff_name();
	String plaintiffZipcode = firstPlaintif.getPlaintiff_zipcode();
	String plaintiffAddress = firstPlaintif.getPlaintiff_address();
	String plaintiffSendAddress = firstPlaintif.getPlaintiff_send_address();
	String plaintiffPhone = firstPlaintif.getPlaintiff_phone();
	String plaintiffEmail = firstPlaintif.getPlaintiff_email();
	
	// 2. 피고
	ArrayList<DefendantVo> DefendantList = PdfVo.getDvoList();
	DefendantVo firstDefendant = DefendantList.get(0);
	String defendantName = firstDefendant.getDefendant_name();
	String defendantAddress = firstDefendant.getDefendant_address();
	
	// 3. 제출 서류
	ArrayList<ProofFileVo> FileList = PdfVo.getFvoList();
	System.out.println(FileList);
	
	// 4. Case 기본정보
	String caseName = PdfVo.getMIN_SJ_SGN_CATEGORY_NAME();
	String casePurpose = PdfVo.getPURPOSE_CONTENT();
	String caseCause = PdfVo.getCAUSE_CONTENT();
	String court = PdfVo.getMIN_SJ_COURT_CATEGORY_NAME();
	Date writeDate = PdfVo.getCASE_SAVE_DATE();
	String dateToStr = DateFormatUtils.format(writeDate, "yyyy-MM-dd");
	
	int number = casePurpose.indexOf("\n");
	System.out.println("db에서 가져온 목적 "+number);
	
	
	// 원고 
	contentStream.newLineAtOffset(230, 720);  // 가로 max 500 세로 max 약 700
	contentStream.setFont(fontGulim, 45);
	contentStream.showText("소      장");
	contentStream.endText();

	contentStream.beginText();
	contentStream.newLineAtOffset(50, 640);
	contentStream.setFont(fontGulim, 10);
	contentStream.showText(dateToStr);
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(50, 620);
	contentStream.setFont(fontGulim, 10);
	contentStream.showText(court + "귀중");
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(50, 570);
	contentStream.setFont(fontGulim, 10);
	contentStream.showText("원      고");
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(200, 570);
	contentStream.setFont(fontGulim, 10);
	if (PlaintifList.size() == 1) {
		contentStream.showText(plaintifNationalName);
	} else {
		contentStream.showText(plaintifNationalName+"외 "+ (PlaintifList.size()-1) +"명");
	}
	
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(200, 550);
	contentStream.setFont(fontGulim, 10);
	contentStream.showText(plaintiffAddress + " " + plaintiffZipcode);
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(200, 530); 
	contentStream.setFont(fontGulim, 10);
	contentStream.showText("휴대전화 : " + plaintiffPhone +", 이메일 : " + plaintiffEmail);
	contentStream.endText();
	
	// 피고 
	contentStream.beginText();
	contentStream.newLineAtOffset(50, 490);  
	contentStream.setFont(fontGulim, 10);
	contentStream.showText("피      고");
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(200, 490);
	contentStream.setFont(fontGulim, 10);
	if (DefendantList.size() == 1) {
		contentStream.showText(defendantName);
	} else {
		contentStream.showText(defendantName+"외 "+ (DefendantList.size()-1) +"명");
	}
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(200, 470);
	contentStream.setFont(fontGulim, 10);
	contentStream.showText(defendantAddress);
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(50, 410);  
	contentStream.setFont(fontGulim, 18);
	contentStream.showText(caseName);
	contentStream.endText();
	
	contentStream.beginText();
	contentStream.newLineAtOffset(260, 360);  
	contentStream.setFont(fontGulim, 25);
	contentStream.showText("청 구 취 지");
	contentStream.endText();
	
	int startHeight = 330;
	String word = "\n";
	
	Integer startIndex = 0;
	ArrayList<Integer> indexList1 = new ArrayList<Integer> ();
	int index = casePurpose.indexOf(word); 
	
	while(index != -1) { 
		indexList1.add(index); 
		index = casePurpose.indexOf(word, index+word.length()); 
	}
	
	for (int i = 0; i <= indexList1.size(); i++) {
		
		System.out.println(indexList1.size());
		
		if ( i != indexList1.size() ) {
			
			System.out.println(indexList1.get(i)+" 번째 줄바꿈 위치");
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50, startHeight);  
			contentStream.setFont(fontGulim, 10);
			contentStream.showText(casePurpose.substring(startIndex, indexList1.get(i) - 1));
			contentStream.endText();
			
			startIndex = indexList1.get(i) + 1;
			startHeight = startHeight - 15;
			
		} else {
			
			System.out.println("마지막 줄바꿈 위치");
			System.out.println("마지막 단어 index : " + casePurpose.length());
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50, startHeight);  
			contentStream.setFont(fontGulim, 10);
			contentStream.showText(casePurpose.substring(startIndex, casePurpose.length() ));
			contentStream.endText();
			
			startHeight = startHeight - 15;
			
		}
		
	}
	
	startHeight = startHeight - 30;
	
	contentStream.beginText();
	contentStream.newLineAtOffset(260, startHeight);  
	contentStream.setFont(fontGulim, 25);
	contentStream.showText("청 구 원 인");
	contentStream.endText();
	
	startHeight = startHeight - 30;
	
	startIndex = 0;
	ArrayList<Integer> indexList2 = new ArrayList<Integer> ();
	index = caseCause.indexOf(word); 
	
	while(index != -1) { 
		indexList2.add(index); 
		index = caseCause.indexOf(word, index+word.length()); 
	}
	
	for (int i = 0; i <= indexList2.size(); i++) {
		
		System.out.println(indexList2.size() + "원인 사이즈");
		
		if ( i != indexList2.size() ) {
			
			System.out.println(indexList2.get(i)+" 번째 원인 줄바꿈 위치");
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50, startHeight);  
			contentStream.setFont(fontGulim, 10);
			contentStream.showText(caseCause.substring(startIndex, indexList2.get(i) - 1));
			contentStream.endText();
			
			startIndex = indexList2.get(i) + 1;
			startHeight = startHeight - 15;
			
		} else {
			
			System.out.println("마지막 원인 줄바꿈 위치");
			System.out.println("마지막 단어 index : " + caseCause.length());
			
			contentStream.beginText();
			contentStream.newLineAtOffset(50, startHeight);  
			contentStream.setFont(fontGulim, 10);
			contentStream.showText(caseCause.substring(startIndex, caseCause.length() ));
			contentStream.endText();
			
			startHeight = startHeight - 15;
			
		}
		
	}
	
	startHeight = startHeight - 30;
	
	contentStream.beginText();
	contentStream.newLineAtOffset(260, startHeight);  
	contentStream.setFont(fontGulim, 25);
	contentStream.showText("첨 부 서 류");
	contentStream.endText();
	
	startHeight = startHeight - 30;
	
	if (FileList != null) {
		int StartHeight = startHeight;
		for (ProofFileVo list : FileList) {
			contentStream.beginText();
			contentStream.newLineAtOffset(480, StartHeight);  
			contentStream.setFont(fontGulim, 10);
			contentStream.showText(list.getFile_original_name());
			contentStream.endText();
			StartHeight -= 15;
		}
	}
	
	contentStream.close();
	
	// 문서 저장 및 생성완료 출력
	document.save(uploadFolder + folderPath + fileName + ".pdf");
	System.out.println("1="+ uploadFolder + "1="+ folderPath + "1="+ fileName + ".pdf");
	System.out.println("PDF created / 소장 PDF 생성됨");

	// 문서 닫기
	document.close();			
	
	DocumentConfirmedVo documentConfirmedVo = new DocumentConfirmedVo();
	
	documentConfirmedVo.setCase_no(CaseNo);
	documentConfirmedVo.setConfirmed_url(urlFolder + folderPath + fileName+ ".pdf");
	
	return documentConfirmedVo;
	}
	
	
	
	public static DefenseDocumentVo inserAnswertPdf (
			DefenseVo PdfVo, 
			UserVo uvo, 
			String courtName, 
			String PLAINTIFF_NAME, 
			String DEFENDANT_NAME, 
			ArrayList<DefenseProofFileVo> fileList,
			Date writeDate
			) throws IOException {
		
		String confirmedNo = PdfVo.getCase_confirmed_no();
		
		//로컬 설정
		// String uploadFolder = "C:/uploadFolder/PDF/Answer/";
		//서버 설정
		String uploadFolder = "/uploadFolder/PDF/Answer/";

		String urlFolder = "PDF/Answer/";
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		String folderPath = sdf.format(today);
		File todayFolder = new File(uploadFolder + folderPath);
		
		if(!todayFolder.exists()) {
			todayFolder.mkdirs();
		}
		
		String fileName = "";
		fileName += confirmedNo + "_";
		
		long currentTime = System.currentTimeMillis();
		fileName += "_" + currentTime;
		
		UUID uuid = UUID.randomUUID();	// 랜덤 문자열
		fileName += uuid.toString();
		
		// PDF 생성
		// 문서 객체 생성
		PDDocument document = new PDDocument();

		// 빈페이지 생성
		PDPage newPage = new PDPage();

		// 빈페이지 문서에 추가
		document.addPage(newPage);

		// 컨텐츠 스트림 열기

		PDPageContentStream contentStream = new PDPageContentStream(document, newPage);

		// ttf 폰트 사용하기
//		InputStream fontStream = new FileInputStream("C:/tmp/main.ttf");
		// 로컬 설정
		// InputStream fontStream = new FileInputStream("C:/font/main.ttf");
		// 서버 설정
		InputStream fontStream = new FileInputStream("/font/main.ttf");
		
		PDType0Font fontGulim = PDType0Font.load(document, fontStream);
		
		//
		contentStream.setLeading(41.5f); //행간
		contentStream.beginText();
		
		// 넣을 정보들 
		
		// 2. 답변서 작성자 (피고 정보)
		int defendantZipcode = uvo.getUser_zipcode();
		String zipcode = Integer.toString(defendantZipcode);
		String address = uvo.getUser_address();
		String lastAddress = uvo.getUser_send_address();
		
		// 3. 제출 서류
		
		// 4. Case 기본정보
		String dateToStr = DateFormatUtils.format(writeDate, "yyyy-MM-dd");
		String purposeAnswer = PdfVo.getPurpose_answer_content();
		String causeAnswer = PdfVo.getCause_answer_content();
		String court = courtName;
		
		
		// 원고 
		contentStream.newLineAtOffset(230, 720);  // 가로 max 500 세로 max 약 700
		contentStream.setFont(fontGulim, 45);
		contentStream.showText("답  변  서");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 620);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText(court + "귀중");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 600);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText(dateToStr);
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 550);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("원      고");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(200, 550);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText(PLAINTIFF_NAME);
		contentStream.endText();
		
		// 피고 
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 470);  
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("피      고");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(200, 470);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText(DEFENDANT_NAME);
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(200, 450);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("휴대전화 : " + uvo.getUser_phone());
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(200, 430);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("주소 : " + zipcode + " " + address + " " + lastAddress);
		contentStream.endText();
		
//		contentStream.beginText();
//		contentStream.newLineAtOffset(50, 390);  
//		contentStream.setFont(fontGulim, 18);
//		contentStream.showText(caseName);
//		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(250, 385);  
		contentStream.setFont(fontGulim, 25);
		contentStream.showText("청구취지 답변");
		contentStream.endText();
		
		int startHeight = 330;
		String word = "\n";
		
		Integer startIndex = 0;
		ArrayList<Integer> indexList1 = new ArrayList<Integer> ();
		int index = purposeAnswer.indexOf(word); 
		
		while(index != -1) { 
			indexList1.add(index); 
			index = purposeAnswer.indexOf(word, index+word.length()); 
		}
		
		for (int i = 0; i <= indexList1.size(); i++) {
			
			System.out.println(indexList1.size());
			
			if ( i != indexList1.size() ) {
				
				System.out.println(indexList1.get(i)+" 번째 줄바꿈 위치");
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(purposeAnswer.substring(startIndex, indexList1.get(i) - 1));
				contentStream.endText();
				
				startIndex = indexList1.get(i) + 1;
				startHeight = startHeight - 15;
				
			} else {
				
				System.out.println("마지막 줄바꿈 위치");
				System.out.println("마지막 단어 index : " + purposeAnswer.length());
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(purposeAnswer.substring(startIndex, purposeAnswer.length() ));
				contentStream.endText();
				
				startHeight = startHeight - 15;
				
			}
			
		}
		
		startHeight = startHeight - 30;
		
		contentStream.beginText();
		contentStream.newLineAtOffset(250, startHeight);  
		contentStream.setFont(fontGulim, 25);
		contentStream.showText("청구원인 답변");
		contentStream.endText();
		
		startHeight = startHeight - 30;
		
		startIndex = 0;
		ArrayList<Integer> indexList2 = new ArrayList<Integer> ();
		index = causeAnswer.indexOf(word); 
		
		while(index != -1) { 
			indexList2.add(index); 
			index = causeAnswer.indexOf(word, index+word.length()); 
		}
		
		for (int i = 0; i <= indexList2.size(); i++) {
			
			System.out.println(indexList2.size() + "원인 사이즈");
			
			if ( i != indexList2.size() ) {
				
				System.out.println(indexList2.get(i)+" 번째 원인 줄바꿈 위치");
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(causeAnswer.substring(startIndex, indexList2.get(i) - 1));
				contentStream.endText();
				
				startIndex = indexList2.get(i) + 1;
				startHeight = startHeight - 15;
				
			} else {
				
				System.out.println("마지막 원인 줄바꿈 위치");
				System.out.println("마지막 단어 index : " + causeAnswer.length());
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(causeAnswer.substring(startIndex, causeAnswer.length() ));
				contentStream.endText();
				
				startHeight = startHeight - 15;
				
			}
			
		}
		
		startHeight = startHeight - 30;
		
		contentStream.beginText();
		contentStream.newLineAtOffset(260, startHeight);  
		contentStream.setFont(fontGulim, 25);
		contentStream.showText("첨 부 서 류");
		contentStream.endText();
		
		startHeight = startHeight - 30;
		
		if (fileList != null) {
			int StartHeight = startHeight;
			for (DefenseProofFileVo list : fileList) {
				contentStream.beginText();
				contentStream.newLineAtOffset(450, StartHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(list.getFile_original_name());
				contentStream.endText();
				StartHeight -= 20;
			}
		}
		
		contentStream.close();
		
		// 문서 저장 및 생성완료 출력
		document.save(uploadFolder + folderPath + fileName + ".pdf");
		System.out.println("1="+ uploadFolder + "1="+ folderPath + "1="+ fileName + ".pdf");
		System.out.println("PDF created / 답변서 PDF 생성됨");

		// 문서 닫기
		document.close();			
		
		DefenseDocumentVo ddvo = new DefenseDocumentVo();
		
		ddvo.setDocument_url(urlFolder + folderPath + fileName+ ".pdf");
		
		return ddvo;
		}
	
	public static TrialDocumentVo inserTrialPdf (HashMap<String, Object> param, HashMap<String, Object> trialData) throws IOException {
		
		String confirmedNo = (String) param.get("confirmedNo");
		
		//로컬 설정
		//String uploadFolder = "C:/uploadFolder/PDF/Trial/";
		//서버 설정
		String uploadFolder = "/uploadFolder/PDF/Trial/";
		
		String urlFolder = "PDF/Trial/";
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		String folderPath = sdf.format(today);
		File todayFolder = new File(uploadFolder + folderPath);
		
		if(!todayFolder.exists()) {
			todayFolder.mkdirs();
		}
		
		String fileName = "";
		fileName += confirmedNo + "_";
		
		long currentTime = System.currentTimeMillis();
		fileName += "_" + currentTime;
		
		UUID uuid = UUID.randomUUID();	// 랜덤 문자열
		fileName += uuid.toString();
		
		// PDF 생성
		// 문서 객체 생성
		PDDocument document = new PDDocument();

		// 빈페이지 생성
		PDPage newPage = new PDPage();

		// 빈페이지 문서에 추가
		document.addPage(newPage);

		// 컨텐츠 스트림 열기

		PDPageContentStream contentStream = new PDPageContentStream(document, newPage);

		// ttf 폰트 사용하기
		//InputStream fontStream = new FileInputStream("C:/tmp/main.ttf");
		// 로컬 설정
		// InputStream fontStream = new FileInputStream("C:/font/main.ttf");
		// 서버 설정
		InputStream fontStream = new FileInputStream("/font/main.ttf");
		 PDType0Font fontGulim = PDType0Font.load(document, fontStream);
		
		//
		contentStream.setLeading(41.5f); //행간
		contentStream.beginText();
		
		// 넣을 정보들 
		
		// 2. 답변서 작성자 (피고 정보)
		String PLAINTIFF_NAME = (String) trialData.get("PLAINTIFF_NAME");
		String DEFENDANT_NAME = (String) trialData.get("DEFENDANT_NAME");
		
		// 3. 제출 서류
		
		// 4. Case 기본정보
		String trialResult = (String) param.get("trialResult");
		String trialOrder = (String) param.get("trialOrder");
		String trialReason = (String) param.get("trialReason");
		String trialCourt = (String) trialData.get("MIN_SJ_COURT_CATEGORY_NAME");
		String trialCase = (String) trialData.get("MIN_SJ_SGN_CATEGORY_NAME");
		String dateToStr = (String) param.get("trialDate");
		
		System.out.println("[PDF]" + confirmedNo);
		System.out.println("[PDF]" + dateToStr);
		System.out.println("[PDF]" + trialResult);
		System.out.println("[PDF]" + trialOrder);
		System.out.println("[PDF]" + trialCourt);
		System.out.println("[PDF]" + trialCase);
		
		
		// 원고 
		contentStream.newLineAtOffset(230, 700);  // 가로 max 500 세로 max 약 700
		contentStream.setFont(fontGulim, 45);
		contentStream.showText("판  결  문");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 640);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("사건번호 : " + confirmedNo + "    사건명 : " + trialCase);
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 620);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("종국일자 : " + dateToStr);
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 600);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText(trialCourt);
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 550);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("원      고");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(200, 550);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText(PLAINTIFF_NAME);
		contentStream.endText();
		
		// 피고 
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 470);  
		contentStream.setFont(fontGulim, 10);
		contentStream.showText("피      고");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(200, 470);
		contentStream.setFont(fontGulim, 10);
		contentStream.showText(DEFENDANT_NAME);
		contentStream.endText();
		
		
//		contentStream.beginText();
//		contentStream.newLineAtOffset(50, 390);  
//		contentStream.setFont(fontGulim, 18);
//		contentStream.showText(caseName);
//		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(260, 420);  
		contentStream.setFont(fontGulim, 25);
		contentStream.showText("종 국 결 과");
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(50, 350);  
		contentStream.setFont(fontGulim, 18);
		contentStream.showText(trialResult);
		contentStream.endText();
		
		contentStream.beginText();
		contentStream.newLineAtOffset(275, 320);  
		contentStream.setFont(fontGulim, 25);
		contentStream.showText("주    문");
		contentStream.endText();
		
		int startHeight = 280;
		String word = "\n";
		
		Integer startIndex = 0;
		ArrayList<Integer> indexList1 = new ArrayList<Integer> ();
		int index = trialOrder.indexOf(word); 
		
		while(index != -1) { 
			indexList1.add(index); 
			index = trialOrder.indexOf(word, index+word.length()); 
		}
		
		for (int i = 0; i <= indexList1.size(); i++) {
			
			System.out.println(indexList1.size());
			
			if ( i != indexList1.size() ) {
				
				System.out.println(indexList1.get(i)+" 번째 줄바꿈 위치");
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(trialOrder.substring(startIndex, indexList1.get(i) - 1));
				contentStream.endText();
				
				startIndex = indexList1.get(i) + 1;
				startHeight = startHeight - 15;
				
			} else {
				
				System.out.println("마지막 줄바꿈 위치");
				System.out.println("마지막 단어 index : " + trialOrder.length());
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(trialOrder.substring(startIndex, trialOrder.length() ));
				contentStream.endText();
				
				startHeight = startHeight - 15;
				
			}
			
		}
		
		startHeight = startHeight - 30;
		
		contentStream.beginText();
		contentStream.newLineAtOffset(275, startHeight);  
		contentStream.setFont(fontGulim, 25);
		contentStream.showText("이    유");
		contentStream.endText();
		
		startHeight = startHeight - 30;
		
		startIndex = 0;
		ArrayList<Integer> indexList2 = new ArrayList<Integer> ();
		index = trialReason.indexOf(word); 
		
		while(index != -1) { 
			indexList2.add(index); 
			index = trialReason.indexOf(word, index+word.length()); 
		}
		
		for (int i = 0; i <= indexList2.size(); i++) {
			
			System.out.println(indexList2.size() + "원인 사이즈");
			
			if ( i != indexList2.size() ) {
				
				System.out.println(indexList2.get(i)+" 번째 원인 줄바꿈 위치");
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(trialReason.substring(startIndex, indexList2.get(i) - 1));
				contentStream.endText();
				
				startIndex = indexList2.get(i) + 1;
				startHeight = startHeight - 15;
				
			} else {
				
				System.out.println("마지막 원인 줄바꿈 위치");
				System.out.println("마지막 단어 index : " + trialReason.length());
				
				contentStream.beginText();
				contentStream.newLineAtOffset(50, startHeight);  
				contentStream.setFont(fontGulim, 10);
				contentStream.showText(trialReason.substring(startIndex, trialReason.length() ));
				contentStream.endText();
				
				startHeight = startHeight - 15;
				
			}
			
		}
		
		startHeight = startHeight - 30;
		
		contentStream.close();
		
		// 문서 저장 및 생성완료 출력
		document.save(uploadFolder + folderPath + fileName + ".pdf");
		System.out.println("1="+ uploadFolder + "1="+ folderPath + "1="+ fileName + ".pdf");
		System.out.println("PDF created / 판결문 PDF 생성됨");

		// 문서 닫기
		document.close();			
		
		TrialDocumentVo tdv = new TrialDocumentVo();
		
		tdv.setTrial_document_url(urlFolder + folderPath + fileName+ ".pdf");
		
		return tdv;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}