package com.malihong.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.malihong.entity.Account;
import com.malihong.entity.Profile;
import com.malihong.service.AccountService;

public class AddUserTest {

	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		Account account = new Account();
		account.setEmail("asdadadada");
		account.setUsername("Shuhao");
		
		Profile profile = new Profile();
		profile.setPostcode(1234);
		
		
	}

}
