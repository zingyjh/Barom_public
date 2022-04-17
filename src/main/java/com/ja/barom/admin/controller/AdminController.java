package com.ja.barom.admin.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.barom.Vo.AdminVo;
import com.ja.barom.admin.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("adminLoginPage")
    public String adminLoginPage() {
    	
		
    	return "admin/adminLoginPage";
    }

	@ResponseBody
	@RequestMapping("adminLoginProcess")
	public HashMap<String, Object> adminLoginProcess(AdminVo vo ,HttpSession sessionAdmin) {
		
		
		HashMap<String, Object> data = new HashMap<String, Object>();
    	 
		AdminVo adminSession = adminService.getAdmin(vo);
    	
    	 System.out.println("@@" + vo.getAdmin_id());
    	 System.out.println("@@" + vo.getAdmin_pw());  
    	 
    	 if(adminSession != null && vo.getAdmin_id().contains("site")) {    		    		
    		 sessionAdmin.setAttribute("adminSession", adminSession);    		 
    		 
    		 data.put("result", "site");
    	
    	 }else if(adminSession != null &&  vo.getAdmin_id().contains("staff")){
    		 sessionAdmin.setAttribute("adminSession", adminSession);   		 
    		 
    		 data.put("result", "staff");
    	
    	 }else if(adminSession != null &&  vo.getAdmin_id().contains("court")){
    		 sessionAdmin.setAttribute("adminSession", adminSession);

    		 data.put("result", "court");
    	 }else {
    		 data.put("result", "fail");
    	 }
    	 return data;
    	    	
	}
    @RequestMapping("adminLoginFailPage")
    public String adminLoginFailPage() {
    	
    	return "admin/adminLoginFailPage";
    }
    
    @RequestMapping("adminLogoutProcess")
    public String adminLogoutProcess(HttpSession session) {
    	
    	session.invalidate();
    	
    	return "redirect:/admin/adminLoginPage";
    }
}

