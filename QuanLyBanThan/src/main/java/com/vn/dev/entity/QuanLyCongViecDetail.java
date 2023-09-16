package com.vn.dev.entity;

import java.io.Serializable;

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
@Table(name = TableConstant.QUAN_LY_CONG_VIEC_DETAIL)
public class QuanLyCongViecDetail extends CommonCreated implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "QLCV_ID")
	private Long qlcvId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "WORKPLACE")
	private String workplace;
	
	@Column(name = "DATE_START")
	private String dateStart;
	
	@Column(name = "DATE_END")
	private String dateEnd;
	
	@Column(name = "DESCRIBE")
	private String describe;
	
	@Column(name = "LDAP_FLAG")
	private Boolean ldapFlag;

}
