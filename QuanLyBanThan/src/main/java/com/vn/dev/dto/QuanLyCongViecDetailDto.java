package com.vn.dev.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuanLyCongViecDetailDto extends CommonCreatedDto {
	
	private Long id;
	private Long qlcvId;
	private String name;
	private String workplace;
	private String dateStart;
	private String dateEnd;
	private String describe;
	private Boolean ldapFlag;

}
