package com.vn.dev.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.vn.dev.entity.QuanLyCongViec;

public interface QuanLyCongViecRepository extends JpaRepository<QuanLyCongViec, Long>{
	
	public QuanLyCongViec getQuanLyCongViecByTodayDate(@Param("todayDate") Date todayDate);

}
