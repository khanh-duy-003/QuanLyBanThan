package com.vn.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vn.dev.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
