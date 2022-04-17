package com.ja.barom.commons;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.ja.barom.Vo.DefenseProofFileVo;
import com.ja.barom.Vo.ProofFileVo;

public class UploadFiles {

	// 파일 여러개 업로드
	public static ArrayList<ProofFileVo> uploadProofFilesToFolder(MultipartFile[] uploadFiles){
		
		ArrayList<ProofFileVo> proofFileList = new ArrayList<ProofFileVo>();
		//로컬 설정
		// String uploadFolder = "C:/uploadFolder/";
		//서버 설정
		String uploadFolder = "/uploadFolder/";
		
		int fileCount = 1;
		
		for(MultipartFile uploadFile : uploadFiles) {
			
			if(uploadFile.isEmpty()) {
				continue;
			}
			
			String folderPath = getFolderPath(uploadFolder);
	
			String originalFileName = uploadFile.getOriginalFilename();
			String[] fileNames = getFileName(originalFileName);
			
			try {
				System.out.println("[System] 파일 " + originalFileName + " 업로드");
				uploadFile.transferTo(new File(uploadFolder + folderPath + fileNames[0]));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ProofFileVo proofFileVo = new ProofFileVo();
			proofFileVo.setFile_name(folderPath + fileNames[0]);
			proofFileVo.setFile_original_name(originalFileName);
			proofFileVo.setFile_extension(fileNames[1]);
			proofFileList.add(proofFileVo);
		}
		
		return proofFileList;
	}
	
	// 파일 하나 업로드
	public static ProofFileVo uploadProofFileToFolder(MultipartFile uploadFile) {
		
		//로컬 설정
		// String uploadFolder = "C:/uploadFolder/";
		//서버 설정
		String uploadFolder = "/uploadFolder/";
		
		String folderPath = getFolderPath(uploadFolder);
		
		String originalFileName = uploadFile.getOriginalFilename();
		String[] fileNames = getFileName(originalFileName);
		
		try {
			System.out.println("[System] 파일 " + originalFileName + " 업로드");
			uploadFile.transferTo(new File(uploadFolder + folderPath + fileNames[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ProofFileVo proofFileVo = new ProofFileVo();
		proofFileVo.setFile_name(folderPath + fileNames[0]);
		proofFileVo.setFile_original_name(originalFileName);
		proofFileVo.setFile_extension(fileNames[1]);
		
		return proofFileVo;
	}
	
	// 답변서 파일 업로드
	public static ArrayList<DefenseProofFileVo> uploadDefenseProofFilesToFolder (MultipartFile[] uploadFiles) {
		
		ArrayList<DefenseProofFileVo> fileList = new ArrayList<DefenseProofFileVo>();
		
		//로컬 설정
		String uploadFolder = "C:/uploadFolder/DefenseDoc";
		//서버설정
//		String uploadFolder = "/uploadFolder/DefenseDoc";
		
		int fileCount = 1;
		
		for(MultipartFile uploadFile : uploadFiles) {
			
			if(uploadFile.isEmpty()) {
				continue;
			}
			
			String folderPath = getFolderPath(uploadFolder);
	
			String originalFileName = uploadFile.getOriginalFilename();
			String[] fileNames = getFileName(originalFileName);
			
			try {
				System.out.println("[System] 파일 " + originalFileName + " 업로드");
				uploadFile.transferTo(new File(uploadFolder + folderPath + fileNames[0]));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			DefenseProofFileVo defenseProofFileVo = new DefenseProofFileVo();
			defenseProofFileVo.setFile_name(folderPath + fileNames[0]);
			defenseProofFileVo.setFile_original_name(originalFileName);
			defenseProofFileVo.setFile_extension(fileNames[1]);
			fileList.add(defenseProofFileVo);
		}
		
		return fileList;
		
	}
	
	public static String getFolderPath(String uploadFolder) {
		// 날짜별 폴더 생성
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
		String folderPath = sdf.format(today);
		File todayFolder = new File(uploadFolder + folderPath);
		
		if(!todayFolder.exists()) {
			todayFolder.mkdirs();
		}
		
		return folderPath;
	}
	
	public static String[] getFileName(String originalFileName) {
		String[] fileNames = new String[2];
		
		// 파일이름 중복 회피 (랜덤코드 + 시간으로 파일명 생성)
		String fileName = "";
		UUID uuid = UUID.randomUUID();	// 랜덤 문자열
		fileName += uuid.toString();
		
		long currentTime = System.currentTimeMillis();
		fileName += "_" + currentTime;
		
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		fileName += ext;
		
		fileNames[0] = fileName;
		fileNames[1] = ext;
		
		return fileNames;
	}
	
	
}