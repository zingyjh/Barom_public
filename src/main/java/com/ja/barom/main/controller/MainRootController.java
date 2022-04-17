package com.ja.barom.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainRootController {

	@Autowired
	private MainController mainController;
	
	
	@RequestMapping("/")
	public String main() {
		return mainController.main();
	}
}