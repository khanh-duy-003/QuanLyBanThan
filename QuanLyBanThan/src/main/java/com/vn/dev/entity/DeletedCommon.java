package com.vn.dev.entity;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeletedCommon {
	
	@Column(name = "DELETED_BY")
	String deletedBy;
	
	@Column(name = "DELETED_DATE")
	Date deletedDate;

}
