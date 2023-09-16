package com.vn.dev.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vn.dev.entity.QuanLyCongViecDetail;
import com.vn.dev.service.QuanLyCongViecDetailService;
import com.vn.dev.service.QuanLyCongViecService;

@Controller
@RequestMapping("/task/qlcv")
public class TaskQuanLyCongViecController {
	
	@Autowired
	QuanLyCongViecService qlcvService;
	
	@Autowired
	QuanLyCongViecDetailService qlcvDetailService;
	
	@RequestMapping("/list")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView("task-quanLyCongViec/qlcv-list.html");
		
		Date dateToday = new Date();
		
		List<QuanLyCongViecDetail> a =  qlcvDetailService.findAll();
		
		return mav;
	}

}
