package com.vn.dev.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDeletedDto {
	
	private String deletedBy;
	private Date deletedDate;

}
