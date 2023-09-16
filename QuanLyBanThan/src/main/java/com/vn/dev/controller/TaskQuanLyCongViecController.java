package com.vn.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/task/qlcv")
public class TaskQuanLyCongViecController {
	
	@RequestMapping("/list")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView("task-quanLyCongViec/qlcv-list.html");
		
		
		return mav;
	}

}
