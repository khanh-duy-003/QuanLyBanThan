package com.vn.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.dev.entity.Account;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("")
	public String loginForm(Model model) {
		//Login
//		model.addAttribute("messageLogin", "Vui lòng đăng nhập!");
		
		// Đăng ký
		model.addAttribute("item", new Account());
		model.addAttribute("createAccount", new Account());
		
		// init Tab
//		model.addAttribute("tabLogin", true);
//		model.addAttribute("tabRegister", false);
		return "handle/login.html";
	}
	
	@RequestMapping("/success")
	public String loginSuccess(RedirectAttributes model) {
		model.addFlashAttribute("messageLogin", "Đăng nhập thành công!");
		return "redirect:/pk/home";
	}
	
	@RequestMapping("/error")
	public String loginError(RedirectAttributes model) {
		model.addFlashAttribute("messageLogin", "Sai thông tin đăng nhập!");
		return "redirect:/login";
	}
	
	@RequestMapping("/unauthoried")
	public String unauthoried(RedirectAttributes model) {
		model.addFlashAttribute("messageLogin", "không có quyền truy xuất!");
		return "redirect:/login";
	}
	
	@RequestMapping("/logoff/success")
	public String logoffSuccess(RedirectAttributes model) {
		model.addFlashAttribute("messageLogin", "Bạn đã đăng xuất!");
		return "redirect:/login";
	}

}
