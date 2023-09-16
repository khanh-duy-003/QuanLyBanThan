package com.vn.dev.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonCreatedDto extends CommonUpdatedDto{
	
	private String createdBy;
	private Date createdDate;

}
