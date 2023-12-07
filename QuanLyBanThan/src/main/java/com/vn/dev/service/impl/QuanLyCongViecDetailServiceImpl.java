package com.vn.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.dev.entity.QuanLyCongViecDetail;
import com.vn.dev.repository.QuanLyCongViecDetailRepository;
import com.vn.dev.service.QuanLyCongViecDetailService;

@Service
public class QuanLyCongViecDetailServiceImpl implements QuanLyCongViecDetailService {
	
	@Autowired
	QuanLyCongViecDetailRepository qlcvDetailRepo;

	@Override
	public List<QuanLyCongViecDetail> getQuanLyCongViecDetailByQlcvId(Long qlcvId) {
		return qlcvDetailRepo.getQuanLyCongViecDetailByQlcvId(qlcvId);
	}

}
