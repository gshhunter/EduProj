package com.malihong.dao;

import java.util.List;

import com.malihong.entity.Account;
import com.malihong.entity.ResetPwd;

public interface AccountDao {
	
	public void save(Account account);
	
	public Account findById(int id);
	
	public void delete(Account account);
	
	public void update(Account account);
	
	public Account findByEmail(String email); 
	
	public void addResetCode(ResetPwd resetPwd);
	
	public ResetPwd findResetByCode(String code);
	
	public List<ResetPwd> findResetListByEmail(String email);
	
	public int findAgentIdByRandom();
}
