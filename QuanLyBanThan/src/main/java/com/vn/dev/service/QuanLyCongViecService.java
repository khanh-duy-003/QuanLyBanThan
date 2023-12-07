package com.vn.dev.service;

import java.util.Date;

import com.vn.dev.entity.QuanLyCongViec;

public interface QuanLyCongViecService {
	
	public QuanLyCongViec findByTodayDate(Date todayDate);

}
