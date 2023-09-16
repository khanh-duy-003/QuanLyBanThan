package com.vn.dev.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuanLyCongViecDto extends CommonCreatedDto {

	private Long id;
	private String username;
	private Date todayDate;
	private Boolean active;
	private Boolean ldapFlag;
	
}
