package com.malihong.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.malihong.dao.AccountDaoImpl;
import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;
import com.malihong.service.AccountServiceimpl;

public class AddUserTest {

	public static void main(String[] args) {
		
		Profile pf = new Profile();
		Identification identity = new Identification();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		Account account = new Account();
		
		
		AccountDaoImpl aServ = new AccountDaoImpl();
		aServ.addNewUser(account);
	}

}
