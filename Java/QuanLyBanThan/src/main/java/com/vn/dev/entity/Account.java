package com.vn.dev.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	
	private String username;
	private String password;
	private String role;
	
	public Account(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	

}
