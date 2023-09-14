package com.vn.dev.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.dev.entity.Account;
import com.vn.dev.service.AccountService;
import com.vn.dev.service.MenuTaskService;

@Controller
@RequestMapping("/pk")
public class Home {
	
	@Autowired
	MenuTaskService menuTaskService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping("/home")
	public String home(Model model, HttpServletRequest request) {
		
		String remoteUser = request.getRemoteUser();
		
		if (!"".equals(remoteUser) && remoteUser != null) {
			model.addAttribute("acc", accountService.findById(remoteUser));			
		} else {
			model.addAttribute("acc", new Account());
		}
		model.addAttribute("menuTask", menuTaskService.findAll());
		return "layout/index.html";
	}

}
