package com.vn.dev.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vn.dev.constant.TableConstant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = TableConstant.QUAN_LY_CONG_VIEC)
public class QuanLyCongViec extends CommonCreated implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "TODAY_DATE")
	private Date todayDate;
	
	@Column(name = "ACTIVE")
	private Boolean active;
	
	@Column(name = "LDAP_FLAG")
	private Boolean ldapFlag;

}
