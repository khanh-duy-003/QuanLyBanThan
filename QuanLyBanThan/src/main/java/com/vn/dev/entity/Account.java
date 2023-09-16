package com.vn.dev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "ACCOUNTS")
public class Account extends CreatedCommon implements Serializable {
	
	@Id
	@NotBlank(message = "Tên đăng nhập không được để trống")
	@Column(name = "USERNAME")
	private String username;
	
	@NotBlank(message = "Mật khẩu không được để trống")
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@NotBlank(message = "Email không để được trống")
	@Email(message = "Email không đúng định dạng")
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "ACTIVE")
	private Boolean active;
	
	@Column(name = "LDAP_FLAG")
	private Boolean ldapFlag;
	
}
