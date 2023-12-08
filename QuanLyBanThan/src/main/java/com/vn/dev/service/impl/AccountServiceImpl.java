package com.vn.dev.service.impl;

import java.util.Optional;

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
		
		Optional<Account> acc = accountRe.findById(username);
		if (acc.isPresent())
			return acc.get();
		else
			return new Account();
	}
	
	@Override
	public void save(Account account) {
		accountRe.save(account);
	}

}
