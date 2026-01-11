package com.vn.dev.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vn.dev.constant.UrlConstant;
import com.vn.dev.entity.QuanLyCongViec;
import com.vn.dev.entity.QuanLyCongViecDetail;
import com.vn.dev.service.CommonService;
import com.vn.dev.service.QuanLyCongViecDetailService;
import com.vn.dev.service.QuanLyCongViecService;

@Controller
@RequestMapping(value = UrlConstant.URL_TASK + UrlConstant.QLCV)
public class TaskQuanLyCongViecController {
	
	@Autowired
	QuanLyCongViecService qlcvService;
	
	@Autowired
	QuanLyCongViecDetailService qlcvDetailService;
	
	@Autowired
	CommonService commonService;
	
	@GetMapping(value = UrlConstant.LIST)
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView("task-quanLyCongViec/qlcv-list.html");
		
		Date dateToday = commonService.getDayMonthYear();
		
		
		QuanLyCongViec qlcv = qlcvService.findByTodayDate(dateToday);
		
		if (qlcv != null && qlcv.getId() != null) {
			List<QuanLyCongViecDetail> a =  qlcvDetailService.getQuanLyCongViecDetailByQlcvId(qlcv.getId());			
		}
		
		return mav;
	}

}
