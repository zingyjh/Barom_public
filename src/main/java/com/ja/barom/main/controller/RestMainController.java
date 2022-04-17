package com.ja.barom.main.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.barom.Vo.Min_Sj_Court_CategoryVo;
import com.ja.barom.customer.service.CustomerService;
import com.ja.barom.document.service.DocumentService;

@RestController
@RequestMapping("/main/*")
public class RestMainController {

	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("getMainAnncm")
	public HashMap<String, Object> getMainAnncm(){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> anncmData = customerService.getMainPageAnncm();
		
		data.put("result", "success");
		data.put("anncm", anncmData);
		
		return data;
	}
	
	@RequestMapping("getMainFaQ")
	public HashMap<String, Object> getMainFaQ(){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>>  faqData = customerService.getMainPageFaQ();
		
		data.put("result", "success");
		data.put("faq", faqData);
		
		return data;
	}
	
	@RequestMapping("getCourtList")
	public HashMap<String, Object> getCourtList(){
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		ArrayList<Min_Sj_Court_CategoryVo> court_list = documentService.getCourtCategory();
		
		data.put("result", "success");
		data.put("courtList", court_list);
		
		return data;
	}
	
}
