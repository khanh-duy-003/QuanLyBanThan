package com.vn.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vn.dev.constant.UrlConstant;
import com.vn.dev.entity.Account;
import com.vn.dev.service.AccountService;

@Controller
public class HandleController {
	
	 private static final String MESSENGER = "messenger";
	
	@Autowired
	AccountService accountService;

	//Handle đăng ký
	@RequestMapping(value = UrlConstant.REGISTER_HANDEL)
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
	
	// Get form quên passwword
	@RequestMapping(value = UrlConstant.FORGOT_PASSWORD)
	public ModelAndView forgotPassword() {
		ModelAndView mav = new ModelAndView("handle/forgotPassword.html");
		
		return mav;
	}
	
	// Handle quên passwword
	@RequestMapping(value = UrlConstant.FORGOT_PASSWORD +  UrlConstant.HANDLE)
	public ModelAndView handelForgotPassword(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "email", required = true) String email) {
		ModelAndView mav = new ModelAndView("handle/forgotPassword.html");

		Account account = accountService.findById(username);
		
		if (account != null && account.getUsername() != null) {
			if (email.equals(account.getEmail())) {
				account.setPassword("123");
				accountService.save(account);
				mav.addObject(MESSENGER , "Đổi mật khẩu thành công");
			} else {
				mav.addObject(MESSENGER , "Email không đúng");
				return mav;
			}
		} else {
			mav.addObject(MESSENGER , "Tài khoản không tồn tại");
			return mav;
		}
			
		return mav;
	}
	

	// Get form đổi password
	@RequestMapping("/change")
	public String changepass() {
		return "handle/changePassword.html";
	}
}
