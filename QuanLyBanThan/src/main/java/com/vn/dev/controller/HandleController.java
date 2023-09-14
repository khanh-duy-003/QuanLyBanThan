package com.vn.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.dev.entity.Account;
import com.vn.dev.service.AccountService;

@Controller
public class HandleController {
	
	@Autowired
	AccountService accountService;

	@RequestMapping("/forgotPassword")
	public String forgotPassword() {
		return "handle/forgotPassword.html";
	}

	@RequestMapping("/change")
	public String changepass() {
		return "handle/changePassword.html";
	}
	
	@RequestMapping("/registerHandel")
	public String registerHandel(RedirectAttributes model,Account acc,@Validated @ModelAttribute("sv") Account form,Errors errors) {
		
		if(errors.hasErrors()) {
			// init Tab
			model.addFlashAttribute("tabLogin", false);
			model.addFlashAttribute("tabRegister", true);
			
			model.addFlashAttribute("messageRegister", "Vui lòng sửa các lỗi sau: ");
			return "redirect:/login";
		}
		
		if (acc != null && (acc.getUsername() != null && !"".equals(acc.getUsername()))) {
			Account checkAcc = accountService.findById(acc.getUsername());
			if (checkAcc.getUsername() != null) {
				model.addFlashAttribute("tabLogin", false);
				model.addFlashAttribute("tabRegister", true);
				
				model.addFlashAttribute("messageRegister", "Tài khoản đã tồn tại");
				return "redirect:/login";
			}
			acc.setActive(true);
			accountService.save(acc);
			model.addFlashAttribute("messageRegister", "Đăng ký tài khoản thành công!");
		}
		model.addFlashAttribute("tabLogin", false);
		model.addFlashAttribute("tabRegister", true);
		
		return "redirect:/login";
	}
}
