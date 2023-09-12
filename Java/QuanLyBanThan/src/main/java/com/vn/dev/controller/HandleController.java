package com.vn.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandleController {
	
//	@RequestMapping("/login")
//	public String login() {
//		return "handle/login.html";
//	}

	@RequestMapping("/forgotPassword")
	public String forgotPassword() {
		return "handle/forgotPassword.html";
	}
	
	@RequestMapping("/")
	public String home() {
		return "layout/index.html";
	}
	
	@RequestMapping("/change")
	public String changepass() {
		return "handle/changePassword.html";
	}
}
