package com.ja.barom.user.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.ja.barom.Vo.QuestionVo;
import com.ja.barom.Vo.UserVo;

public interface UserSQLMapper {

	public HashMap<String, Object> getUserInfoByUserNo (int user_no);
	public ArrayList<QuestionVo> getJoinQuestionList ();
	public UserVo getUserByIdAndPw (UserVo vo);
	public String getUserIdByUserNo(int no);
	public HashMap<String, Object> getUserIdByNameAndJumin2 (UserVo vo);
	public HashMap<String, Object> getUserPwByIdAndJumin2(UserVo vo);
	public HashMap<String, Object> getUserQuestionById(UserVo vo);
	public UserVo getUserPwByfindAnswer(UserVo vo);
	public int checkId(String user_id);
	public int checkUser(UserVo vo);
	
	public void getUserUpdatePw(UserVo vo);
	public void updateUserInfoByUserNo (UserVo vo);
	public void deleteUserInfoByUserNo (UserVo vo);
	public void recoveryUserByInfo (UserVo vo);
	public void insertUser(UserVo vo);
	public UserVo getUserByNo(int no);
	
	
	public void testcode(@Param("id") String id, @Param("title") String title, @Param("date") Date date);
	public void testcode1(HashMap<String, Object> testmap);
}
