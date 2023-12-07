package com.vn.dev.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vn.dev.constant.UrlConstant;
import com.vn.dev.entity.Account;
import com.vn.dev.service.AccountService;
import com.vn.dev.service.MenuTaskService;

@Controller
@RequestMapping(value = UrlConstant.URL_PK)
public class Home {
	
	@Autowired
	MenuTaskService menuTaskService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = UrlConstant.HOME)
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index/index.html");
		
		String remoteUser = request.getRemoteUser();
		
		if (!"".equals(remoteUser) && remoteUser != null) {
			mav.addObject("acc", accountService.findById(remoteUser));	
		} else {
			mav.addObject("acc", new Account());
		}
		mav.addObject("menuTask", menuTaskService.findAll());
		
		return mav;
	}

}
