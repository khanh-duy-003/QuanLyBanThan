package com.vn.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vn.dev.entity.QuanLyCongViecDetail;

public interface QuanLyCongViecDetailRepository extends JpaRepository<QuanLyCongViecDetail, Long> {
	
	@Query("SELECT a FROM QuanLyCongViecDetail a WHERE a.qlcvId = ?1")
	List<QuanLyCongViecDetail> getQuanLyCongViecDetailByQlcvId(Long qlcvId);

}
