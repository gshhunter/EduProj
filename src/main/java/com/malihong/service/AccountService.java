package com.malihong.service;

import com.malihong.entity.Account;
import com.malihong.entity.Identification;
import com.malihong.entity.Profile;

public interface AccountService {

	public void addNewUser(Account account, Profile profile, Identification identification);
}
