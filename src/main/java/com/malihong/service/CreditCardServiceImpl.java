package com.malihong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.malihong.dao.CreditCardDao;
import com.malihong.entity.Creditcard;

public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	private CreditCardDao creditcardDao;
	@Override
	public void add(Creditcard c) {
		this.creditcardDao.add(c);
	}

	@Override
	public void delete(Creditcard c) {
		this.creditcardDao.delete(c);
	}

	@Override
	public void update(Creditcard c) {
		this.creditcardDao.update(c);
	}

	@Override
	public List<Creditcard> findByUserId(int uid) {
		return this.creditcardDao.findByUserId(uid);
	}

}
