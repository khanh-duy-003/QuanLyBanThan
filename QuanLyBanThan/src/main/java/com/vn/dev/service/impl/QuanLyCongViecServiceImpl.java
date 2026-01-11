package com.vn.dev.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.dev.entity.QuanLyCongViec;
import com.vn.dev.repository.QuanLyCongViecRepository;
import com.vn.dev.service.QuanLyCongViecService;

@Service
public class QuanLyCongViecServiceImpl implements QuanLyCongViecService {
	
	@Autowired
	QuanLyCongViecRepository qlcvRepo;

	@Override
	public QuanLyCongViec findByTodayDate(Date todayDate) {
		return qlcvRepo.getQuanLyCongViecByTodayDate(todayDate);
	}

}
