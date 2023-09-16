package com.vn.dev.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatedCommon extends UpdatedCommon {
	
	@Column(name = "CREATED_BY")
	String createdBy;
	
	@Column(name = "CREATED_DATE")
	Date createdDate;

}
