package com.vn.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demo {
	
	@RequestMapping("/")
	public String tesst() {
		return "demo";
	}

}
