package com.ja.barom.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.barom.Vo.AdminVo;
import com.ja.barom.Vo.CaseConfirmedVo;
import com.ja.barom.Vo.CaseVo;
import com.ja.barom.Vo.Min_Sj_Court_CategoryVo;
import com.ja.barom.admin.service.AdminService;
import com.ja.barom.document.service.DocumentService;

@Controller
@RequestMapping("/admin/staffAdmin/*")
public class StaffAdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DocumentService documentService;
	
	
	

	
	@RequestMapping("staffAdminPage")
	public String staffAdminPage() {
		
		return "admin/staffAdmin/staffAdminPage";
	}
	
	@RequestMapping("screenPage")
    public String screenPage() {
    	
    	return "admin/staffAdmin/screenPage";
    }
	
	@RequestMapping("petitionListPage")
	public String petitionListPage(Model model) {
		
		
		ArrayList<Min_Sj_Court_CategoryVo> courtList = documentService.getCourtCategory();
		
		model.addAttribute("courtList", courtList);
		
		return "admin/staffAdmin/petitionListPage";
	}
	
	@RequestMapping("approvePage")
	public String approvePage(Model model , String case_no) {
		
		System.out.println("@@" + case_no);
		HashMap<String, Object> map = adminService.getCase(case_no);
		model.addAttribute("data" , map);
		
		
		
		return "admin/staffAdmin/approvePage";
	}
	@RequestMapping("insertCaseConfirmedProcess")

	public String insertCaseConfirmedProcess(CaseConfirmedVo vo, String case_no , int price) {
		
		adminService.insertCaseConfirmed(vo, price);
		adminService.updateCaseStatus(case_no);
		
		return "redirect:/admin/staffAdmin/petitionListPage";
	}
	
	@RequestMapping("refusePage")
	public String refusePage(Model model , String case_no) {
		
		HashMap<String, Object> map = adminService.getCase(case_no);
		model.addAttribute("data" , map);
		
		return "admin/staffAdmin/refusePage";
	}
	
	@RequestMapping("caseRefuseProcess")
	public String caseRefuseProcess(CaseVo vo) {
		
		adminService.refuseCaseStatus(vo);
		
		return "redirect:/admin/staffAdmin/petitionListPage";
	}
	
	
	
    
}
