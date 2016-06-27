package com.malihong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malihong.dao.AccountDao;
import com.malihong.entity.Account;

@Service("accountService")
public class AccountServiceimpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void addNewUser(Account account) {
		accountDao.save(account);
	}

}
