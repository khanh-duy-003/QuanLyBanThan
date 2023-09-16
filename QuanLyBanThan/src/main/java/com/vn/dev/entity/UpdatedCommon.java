package com.vn.dev.entity;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatedCommon extends DeletedCommon {
	
	@Column(name = "UPDATED_BY")
	String updatedBy;
	
	@Column(name = "UPDATED_DATE")
	Date updatedDate;

}
