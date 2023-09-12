package com.vn.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập!");
		return "handle/login.html";
	}
	
	@RequestMapping("/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "layout/index";
	}
	
	@RequestMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập!");
		return "handle/login";
	}
	
	@RequestMapping("/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "không có quyền truy xuất!");
		return "handle/login";
	}
	
	@RequestMapping("/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất!");
		return "handle/login";
	}

}
