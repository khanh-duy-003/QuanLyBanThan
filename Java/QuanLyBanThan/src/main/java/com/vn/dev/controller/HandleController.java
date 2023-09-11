package com.vn.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandleController {
	
	@RequestMapping("login")
	public String login() {
		return "login/login.html";
	}

}
