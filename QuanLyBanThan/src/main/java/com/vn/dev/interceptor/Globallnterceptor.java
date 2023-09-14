package com.vn.dev.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vn.dev.service.MenuTaskService;

@Component
public class Globallnterceptor implements HandlerInterceptor{
	
	@Autowired
	MenuTaskService menuTaskService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		request.setAttribute("menuTask", menuTaskService.findAll());
	}

}