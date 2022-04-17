package com.ja.barom.user.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ja.barom.Vo.CaseConfirmedVo;
import com.ja.barom.Vo.DefendantCaseVo;
import com.ja.barom.Vo.DefendantVo;
import com.ja.barom.Vo.DefenseDocumentVo;
import com.ja.barom.Vo.DefenseProofFileVo;
import com.ja.barom.Vo.DefenseVo;
import com.ja.barom.Vo.PlaintiffVo;
import com.ja.barom.Vo.ProofFileVo;
import com.ja.barom.Vo.QuestionVo;
import com.ja.barom.Vo.SubmitListVo;
import com.ja.barom.Vo.UserVo;
import com.ja.barom.commons.CreatePdf;
import com.ja.barom.commons.MessageDigestUtil;
import com.ja.barom.commons.UploadFiles;
import com.ja.barom.document.mapper.DocumentSQLMapper;
import com.ja.barom.document.service.DocumentService;
import com.ja.barom.user.mapper.UserSQLMapper;

@Service
public class UserService {
	
	@Autowired
	private UserSQLMapper userSQLMapper;
	
	@Autowired
	private DocumentSQLMapper documentSQLMapper;

	public HashMap<String, Object> getUserInfoByUserNo (int user_no) {
		
		HashMap<String, Object> userData = userSQLMapper.getUserInfoByUserNo(user_no);
		
		
		
		return userData;
	}
	
	public void recoveryUserByInfo (UserVo vo) {
		
		String password = vo.getUser_pw();
		password = MessageDigestUtil.getPasswordHashCode(password);
		vo.setUser_pw(password);
		userSQLMapper.recoveryUserByInfo(vo);
	}
	
	public void updateUserInfoByUserNo (UserVo vo) {
		
		
		String password = vo.getUser_pw();
		password = MessageDigestUtil.getPasswordHashCode(password);
		vo.setUser_pw(password);
		userSQLMapper.updateUserInfoByUserNo(vo);
	}
	
	public void deleteUserInfoByUserNo (UserVo vo) {
		
		
		userSQLMapper.deleteUserInfoByUserNo(vo);
	}
	
	public void insertUser (UserVo vo) {
		
		String password = vo.getUser_pw();
		password = MessageDigestUtil.getPasswordHashCode(password);
		vo.setUser_pw(password);
		
		userSQLMapper.insertUser(vo);
	}
	
	public ArrayList<QuestionVo> getJoinQuestionList () {
		
		ArrayList<QuestionVo> questionList = userSQLMapper.getJoinQuestionList();
		
		return questionList;
	}
	
	public UserVo getUserByIdAndPw (UserVo vo) {
		
		String password = vo.getUser_pw();
		password = MessageDigestUtil.getPasswordHashCode(password);
		vo.setUser_pw(password);
		UserVo userVo = userSQLMapper.getUserByIdAndPw(vo);
		
		return userVo;
	}
	
	public HashMap<String, Object> getUserIdByNameAndJumin2 (UserVo vo) {
		
		HashMap<String, Object> userInfo = userSQLMapper.getUserIdByNameAndJumin2(vo);
		
		return userInfo;
	}
		
	
	public HashMap<String, Object> getUserQquestionById (UserVo vo) {
		
		HashMap<String, Object> userInfo = userSQLMapper.getUserQuestionById(vo);
		
		return userInfo;
	}
	
	public UserVo getUserPwByfindAnswer (UserVo vo){
		
		
		return userSQLMapper.getUserPwByfindAnswer(vo);
	}
	
	public void getUserUpdatePw(UserVo vo) {
		
		userSQLMapper.getUserUpdatePw(vo);
	}
     public int checkUser (UserVo vo) {
		
		return userSQLMapper.checkUser(vo);
	}
	
	public int checkId (String user_id) {
		
		return userSQLMapper.checkId(user_id);
	}
	
	public ArrayList<HashMap<String, Object>> getMyCaseList (HashMap<String, Object> param) {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		ArrayList<HashMap<String, Object>> datalist = new ArrayList<HashMap<String, Object>>();
		
			
		datalist = documentSQLMapper.getMyCaseList(param);
			
		for (HashMap<String, Object> data : datalist) {
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			String caseno = (String) data.get("CASE_NO");
			
			ArrayList<PlaintiffVo> PlaintiffList = documentSQLMapper.getPlaintiffListByCaseNo(caseno);
			ArrayList<DefendantVo> DefendantList = documentSQLMapper.getDefendantListByCaesNo(caseno);
			
			if ( PlaintiffList.size() != 0 ) {
				
				PlaintiffVo Pvo = PlaintiffList.get(0);
				
				String plaintiffName = "";
				
				int plaintiffNum = PlaintiffList.size();
				
				if (plaintiffNum == 1) {
					plaintiffName = Pvo.getPlaintiff_name();
				} else {
					plaintiffName = Pvo.getPlaintiff_name() + " 외 " + (plaintiffNum-1) + "명";
				}
				map.put("plaintiffName", plaintiffName);
			} else {
				
				map.put("plaintiffName", "");
				
			}
			
			if ( DefendantList.size() != 0 ) {
				
				DefendantVo Dvo = DefendantList.get(0);
				
				String defendantName = "";
				
				int defendantNum = DefendantList.size();
				
				if (defendantNum == 1) {
					defendantName = Dvo.getDefendant_name();
				} else {
					defendantName = Dvo.getDefendant_name() + " 외 " + (defendantNum-1) + "명";
				}
				map.put("defendantName", defendantName);
			} else {
				
				map.put("defendantName", "");
				
			}
			
			map.put("submitInfo", data);
			
			list.add(map);
		}
		
		return list;
	}
	
	public String getCaseRefuseReason (String caseNo) {
		
		return documentSQLMapper.getCaseRefuseReason(caseNo);
	}
	
	public String getUserIdByUserNo(int no) {
		return userSQLMapper.getUserIdByUserNo(no);
	}
	
	// 사건관련 
	public ArrayList<HashMap<String, Object>> getCaseConfirmedList (int userNo, int searchOption) {
		
		ArrayList<HashMap<String, Object>> caseCofirmed = documentSQLMapper.getCaseConfirmedList(userNo, searchOption);
		
		for (HashMap<String, Object> data : caseCofirmed) {
			
			String caseConfirmedNo = (String) data.get("CASE_CONFIRMED_NO");
			
			int defendantCount = documentSQLMapper.getDefendantCountByConfirmedNo(caseConfirmedNo);
			int plaintiffCount = documentSQLMapper.getPlaintiffCountByConfirmedNo(caseConfirmedNo);
			
			String DEFENDANT_NAME = "";
			String PLAINTIFF_NAME = "";
			
			
			if ( defendantCount == 1) {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo);
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			} else {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo) + "외 " + (defendantCount-1) + "명";
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			}
			
			if ( plaintiffCount == 1) {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo);
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			} else {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo) + "외 " + (plaintiffCount-1) + "명";
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			}
			
			if (documentSQLMapper.checkAnswerRegist(caseConfirmedNo, userNo) == 0) {
				data.put("Answerd", 0);
			} else {
				data.put("Answerd", 1);
			}
			
		}
		
		return caseCofirmed;
	}
	
	public void insertCaseConfirmed (HashMap<String, Object> caseInfo) {
		
		documentSQLMapper.insertDefendantCase(caseInfo);
		
	}
	
	public void updateConfirmedStatusAfterAnswer (String confirmedNo) {
		
		documentSQLMapper.updateConfirmedStatusAfterAnswer(confirmedNo);
	}
	
	public void updateConfirmedStatusAfter (String statusNo, String confirmedNo) {
		
		documentSQLMapper.updateConfirmedStatusAfter(statusNo, confirmedNo);
	}
	
	public int getCaseConfirmedCount (HashMap<String, Object> caseInfo) {
		
		
		return documentSQLMapper.getCaseConfirmedCount(caseInfo);
	}
	
	public int getDefendantCaseCount (DefendantCaseVo vo) {
		
		return documentSQLMapper.getDefendantCaseCount(vo);
	}
	
	// 답변서 관련
	public ArrayList<String> getWriteAnswerList (int userNo) {
		
		return documentSQLMapper.getWriteAnswerList(userNo);
	}
	
	public HashMap<String, Object> getCaseConfirmed (String confirmedNo) {
		
		HashMap<String, Object> data = documentSQLMapper.getCaseConfirmed(confirmedNo);
		
		String caseConfirmedNo = (String) data.get("CASE_CONFIRMED_NO");
		
		int defendantCount = documentSQLMapper.getDefendantCountByConfirmedNo(caseConfirmedNo);
		int plaintiffCount = documentSQLMapper.getPlaintiffCountByConfirmedNo(caseConfirmedNo);
		
		String DEFENDANT_NAME = "";
		String PLAINTIFF_NAME = "";
		
		if ( defendantCount == 1) {
			DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo);
			data.put("DEFENDANT_NAME", DEFENDANT_NAME);
		} else {
			DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo) + "외 " + (defendantCount-1) + "명";
			data.put("DEFENDANT_NAME", DEFENDANT_NAME);
		}
		
		if ( plaintiffCount == 1) {
			PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo);
			data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
		} else {
			PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo) + "외 " + (plaintiffCount-1) + "명";
			data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
		}
		
		return data;
	}
	
	public int insertAnswer (DefenseVo vo, UserVo sessionUser, ArrayList<DefenseProofFileVo> fileList) throws IOException {
		
		int defensNo = documentSQLMapper.createDefensePk();
		String confirmedNo = vo.getCase_confirmed_no();
		vo.setDefense_no(defensNo);
		
		documentSQLMapper.insertAnswer(vo);
		
		String courtName = documentSQLMapper.getCourtByDefenseNo(defensNo);
		
		int defendantCount = documentSQLMapper.getDefendantCountByConfirmedNo(confirmedNo);
		int plaintiffCount = documentSQLMapper.getPlaintiffCountByConfirmedNo(confirmedNo);
		
		String DEFENDANT_NAME = "";
		String PLAINTIFF_NAME = "";
		
		if ( defendantCount == 1) {
			DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(confirmedNo);
		} else {
			DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(confirmedNo) + "외 " + (defendantCount-1) + "명";
		}
		
		if ( plaintiffCount == 1) {
			PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(confirmedNo);
		} else {
			PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(confirmedNo) + "외 " + (plaintiffCount-1) + "명";
		}
		
		DefenseVo writeDefense = documentSQLMapper.getDefenseByNo(defensNo);
		Date writeDate = writeDefense.getDefense_date();
		
		DefenseDocumentVo dvo = CreatePdf.inserAnswertPdf(vo, sessionUser, courtName, PLAINTIFF_NAME, DEFENDANT_NAME, fileList, writeDate);
		dvo.setDefense_no(defensNo);
		
		documentSQLMapper.insertDefenseDocument(dvo);
		
		return defensNo;
	}
	
	public void insertDefenseProofFiles(int Defense_no, ArrayList<DefenseProofFileVo> vo) {
		int i = 1;
		for(DefenseProofFileVo defenseProofFile : vo) {
			System.out.println("[System] " + i + "번째 파일정보 DB에 입력");
			defenseProofFile.setDefense_no(Defense_no);
			documentSQLMapper.insertDefenseProofFile(defenseProofFile);
			i++;
		}
	}
	
	public ArrayList<String> getConfirmedList (int userNo) {
		
		return documentSQLMapper.getConfirmedList(userNo);
	}
	
	// 나의사건 현황 관련
	
	public ArrayList<HashMap<String, Object>> getMyAllCasePrif (HashMap<String, Object> param) {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
			
		System.out.println("원고가져오기실행");
		list = documentSQLMapper.getConfirmedListForPlaintiff(param);
		
		for (HashMap<String, Object> data : list) {
			
			String caseConfirmedNo = (String) data.get("CASE_CONFIRMED_NO");
			
			int defendantCount = documentSQLMapper.getDefendantCountByConfirmedNo(caseConfirmedNo);
			int plaintiffCount = documentSQLMapper.getPlaintiffCountByConfirmedNo(caseConfirmedNo);
			
			String DEFENDANT_NAME = "";
			String PLAINTIFF_NAME = "";
			
			
			if ( defendantCount == 1) {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo);
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			} else {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo) + "외 " + (defendantCount-1) + "명";
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			}
			
			if ( plaintiffCount == 1) {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo);
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			} else {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo) + "외 " + (plaintiffCount-1) + "명";
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			}
			
		}
		
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> getMyAllCaseDef (HashMap<String, Object> param) {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		System.out.println("피고가져오기실행");
		list = documentSQLMapper.getConfirmedListForDeffendant(param);
		
		for (HashMap<String, Object> data : list) {
			
			String caseConfirmedNo = (String) data.get("CASE_CONFIRMED_NO");
			
			int defendantCount = documentSQLMapper.getDefendantCountByConfirmedNo(caseConfirmedNo);
			int plaintiffCount = documentSQLMapper.getPlaintiffCountByConfirmedNo(caseConfirmedNo);
			
			String DEFENDANT_NAME = "";
			String PLAINTIFF_NAME = "";
			
			
			if ( defendantCount == 1) {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo);
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			} else {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo) + "외 " + (defendantCount-1) + "명";
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			}
			
			if ( plaintiffCount == 1) {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo);
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			} else {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo) + "외 " + (plaintiffCount-1) + "명";
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			}
			
		}
		
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> getMyAllCaseSubOption (
			int personOption,
			HashMap<String, Object> param) {
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		if (personOption == 1 ) {
			
			list = documentSQLMapper.getConfirmedListForPlaintiffSub(param);
			
		} else {
			
			list = documentSQLMapper.getConfirmedListForDefendantffSub(param);
			
		}
		
		for (HashMap<String, Object> data : list) {
			
			String caseConfirmedNo = (String) data.get("CASE_CONFIRMED_NO");
			
			int defendantCount = documentSQLMapper.getDefendantCountByConfirmedNo(caseConfirmedNo);
			int plaintiffCount = documentSQLMapper.getPlaintiffCountByConfirmedNo(caseConfirmedNo);
			
			String DEFENDANT_NAME = "";
			String PLAINTIFF_NAME = "";
			
			
			if ( defendantCount == 1) {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo);
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			} else {
				DEFENDANT_NAME = documentSQLMapper.getDefendanOneByConfirmedNo(caseConfirmedNo) + "외 " + (defendantCount-1) + "명";
				data.put("DEFENDANT_NAME", DEFENDANT_NAME);
			}
			
			if ( plaintiffCount == 1) {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo);
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			} else {
				PLAINTIFF_NAME = documentSQLMapper.getPlaintiffOneByConfirmedNo(caseConfirmedNo) + "외 " + (plaintiffCount-1) + "명";
				data.put("PLAINTIFF_NAME", PLAINTIFF_NAME);
			}
			
		}
		
		return list;
	}
	
	
	public void testcode (String id, String title, HashMap<String, Object> testmap, Date date) {
		
		userSQLMapper.testcode(id, title, date);
		userSQLMapper.testcode1(testmap);
	}
	
}
