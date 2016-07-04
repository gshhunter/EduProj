package com.malihong.service;

import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;

/**
 * 
 * @author GSH1
 *
 * Account设置使用了Cascade Type（Persist or Merge）所以对Identification和Profile的修改可以直接使用Account的update()方法来进行
 */
public interface AccountService {

	public void addNewUser(Account account, Profile profile, Identification identification);
	
	public Account findUserById(int uid);
	
	public void delete(Account account);
	
	public void update(Account account);
	
	public boolean checkAccountByEmail(String email);
}
