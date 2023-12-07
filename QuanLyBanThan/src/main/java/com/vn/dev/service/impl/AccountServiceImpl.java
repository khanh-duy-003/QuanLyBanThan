package com.vn.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.dev.entity.Account;
import com.vn.dev.repository.AccountRepository;
import com.vn.dev.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRe;

	@Override
	public Account findById(String username) {
		return accountRe.findById(username).get();
	}
	
	@Override
	public void save(Account account) {
		accountRe.save(account);
	}

}
