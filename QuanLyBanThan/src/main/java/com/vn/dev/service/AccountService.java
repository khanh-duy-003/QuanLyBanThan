package com.vn.dev.service;

import com.vn.dev.entity.Account;

public interface AccountService {
	
	public Account findById(String username);
	
	public Account findById1(String username);

	public void save(Account account);

}
