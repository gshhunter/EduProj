/**
 * 
 */
package com.malihong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.AccountDao;
import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;
import com.malihong.entity.ResetPwd;

/**
 * @author GSH1
 *
 */
@Service
@Qualifier("accountService")
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

	@Override
	public boolean checkAccountByEmail(String email) {
		Account account = null;
		account = accountDao.findByEmail(email);
		if (account == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Account findUserByEmail(String email) {
		return accountDao.findByEmail(email);
	}

	@Override
	public ResetPwd findResetPwdByCode(String code) {
		return accountDao.findResetByCode(code);
	}

	@Override
	public void addResetCode(ResetPwd resetPwd) {
		accountDao.addResetCode(resetPwd);
	}

	@Override
	public List<ResetPwd> findResetListByEmail(String email) {
		return accountDao.findResetListByEmail(email);
	}
}