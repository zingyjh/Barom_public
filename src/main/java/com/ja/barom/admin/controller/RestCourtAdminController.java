package com.ja.barom.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ja.barom.Vo.AdminVo;
import com.ja.barom.Vo.TrialVo;
import com.ja.barom.admin.service.AdminService;
import com.ja.barom.user.service.UserService;

@RestController
@RequestMapping("/admin/courtAdmin/*")
public class RestCourtAdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("getCaseConfirmedAndAnsweredList")
	public HashMap<String, Object> getCaseConfirmedAndAnsweredList (@RequestBody @RequestParam HashMap<String, Object> param ,HttpSession session) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		AdminVo adminSession = (AdminVo) session.getAttribute("adminSession");
		int courtOption = adminSession.getMin_sj_court_category_no();
		
		param.put("courtOption", courtOption);
		
		System.out.println("status : " + param.get("statusOption"));
		System.out.println("trialOption : " + param.get("trialOption"));
		
		ArrayList<HashMap<String, Object>> list = adminService.getCaseConfirmedAndAnsweredList(param);
		
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("getCaseConfirmedByStatus")
	public HashMap<String, Object> getCaseConfirmedByStatus (int statusNo) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		ArrayList<String> list = adminService.getCaseConfirmedByStatus(statusNo);
		data.put("list", list);
		
		return data;
	}
	
	@RequestMapping("getCaseConfirmedByNo")
	public HashMap<String, Object> getCaseConfirmedByNo (String confirmedNo) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		HashMap<String, Object> info = userService.getCaseConfirmed(confirmedNo);
		
		data.put("info", info);
		
		return data;
	}
	
	@RequestMapping("insertTrial")
	public HashMap<String, Object> insertTrial (@RequestBody @RequestParam HashMap<String, Object> param) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		adminService.insertTrial(param);
		
		
		data.put("result", "success");
		
		return data;
	}
	
}
