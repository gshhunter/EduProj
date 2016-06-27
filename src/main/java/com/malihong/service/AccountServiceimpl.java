package com.malihong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malihong.dao.AccountDao;
import com.malihong.dao.IdentDao;
import com.malihong.dao.ProfileDao;
import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;

@Service("accountService")
public class AccountServiceimpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ProfileDao profileDao;
	@Autowired
	private IdentDao identDao;
	
	@Override
	public void addNewUser(Account account, Profile profile, Identification identification) {
		profileDao.save(profile);
		identDao.save(identification);
		account.setProfile(profile);
		account.setIdentification(identification);
		accountDao.save(account);
	}

}
