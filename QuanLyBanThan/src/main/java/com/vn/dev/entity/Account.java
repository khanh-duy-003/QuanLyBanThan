package com.vn.dev.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	
	@Id
	@NotBlank(message = "Tên đăng nhập không được để trống")
	@Column(name = "Username")
	private String username;
	
	@NotBlank(message = "Mật khẩu không được để trống")
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Fullname")
	private String fullName;
	
	@NotBlank(message = "Email không để được trống")
	@Email(message = "Email không đúng định dạng")
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Active")
	private Boolean active;
	

}
