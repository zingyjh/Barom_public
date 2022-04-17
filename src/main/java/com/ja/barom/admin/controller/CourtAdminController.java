package com.ja.barom.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.barom.Vo.CaseConfirmedStatusVo;
import com.ja.barom.admin.service.AdminService;

@Controller
@RequestMapping("/admin/courtAdmin/*")
public class CourtAdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("courtAdminPage")
	public String courtAdminPage() {
		
		return "admin/courtAdmin/courtAdminPage";
	}
	
	@RequestMapping("courtCaseListPage")
	public String courtCaseListPage(Model model) {
		
		ArrayList<CaseConfirmedStatusVo> list = adminService.getCaseConfirmedStatusList();
		
		model.addAttribute("list", list);
		
		return "admin/courtAdmin/courtCaseListPage";
	}
	
	@RequestMapping("registJudgmentPage")
	public String registJudgmentPage () {
		
		
		
		return "admin/courtAdmin/registJudgmentPage";
	}
	
	
}
