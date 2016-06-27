package com.malihong.dao;

import com.malihong.entity.Account;

public interface AccountDao {
	
	public void save(Account account);
	
	public Account findById(int id);
	
	public void delete(Account account);
	
	public void update(Account account);
}
