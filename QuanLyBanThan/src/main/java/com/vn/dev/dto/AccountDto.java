package com.vn.dev.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto extends CommonCreatedDto{
	
	private String username;
	private String password;
	private String fullName;
	private String email;
	private String phone;
	private Boolean active;
	private Boolean ldapFlag;

}
