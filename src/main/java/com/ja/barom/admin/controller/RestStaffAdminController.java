package com.ja.barom.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ja.barom.admin.service.AdminService;

@RestController
@RequestMapping("/admin/staffAdmin/*")
public class RestStaffAdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("getStaffCaseList")
	public HashMap<String, Object> getStaffCaseList (@RequestBody @RequestParam HashMap<String, Object> param) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		System.out.println(param.get("docOption"));
		System.out.println("court : " + param.get("courtOption"));
		
		ArrayList<HashMap<String, Object>> list = adminService.getCaseList(param);
		
		data.put("list", list);
		
		return data;
	}

}
