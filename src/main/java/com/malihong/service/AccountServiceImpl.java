/**
 * 
 */
package com.malihong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malihong.dao.AccountDao;
import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;

/**
 * @author GSH1
 *
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void addNewUser(Account account, Profile profile, Identification identification) {
		account.setProfile(profile);
		account.setIdentification(identification);
		accountDao.save(account);
	}

	@Override
	public Account findUserById(int uid) {
		Account account = accountDao.findById(uid);
		return account;
	}

	@Override
	public void delete(Account account) {
		accountDao.delete(account);
	}

	@Override
	public void update(Account account) {
		accountDao.update(account);
	}

}