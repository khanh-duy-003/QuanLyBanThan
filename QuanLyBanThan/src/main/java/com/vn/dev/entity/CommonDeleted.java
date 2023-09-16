package com.vn.dev.entity;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDeleted {
	
	@Column(name = "DELETED_BY")
	private String deletedBy;
	
	@Column(name = "DELETED_DATE")
	private Date deletedDate;

}
