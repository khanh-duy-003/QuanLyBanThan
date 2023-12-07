package com.vn.dev.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.vn.dev.config.DbRepository;
import com.vn.dev.entity.QuanLyCongViecDetail;

public interface QuanLyCongViecDetailRepository extends DbRepository<QuanLyCongViecDetail, Long> {
	
	List<QuanLyCongViecDetail> getQuanLyCongViecDetailByQlcvId(@Param("qlcvId") Long qlcvId);

}
