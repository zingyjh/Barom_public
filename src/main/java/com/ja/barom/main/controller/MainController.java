package com.ja.barom.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@RequestMapping("main")
	public String main() {
		
		return "main/main";
	}
	
	@RequestMapping("renewUISample")
	public String renewUISample() {
		
		return "main/renewUISample";
	}
	
	@RequestMapping("testPage")
	public String testPage () {
		
		return "main/testPage";
	}

	@RequestMapping("renewAdminUISample")
	public String renewAdminUISample() {
		
		return "main/renewAdminUISample";
	}

}
