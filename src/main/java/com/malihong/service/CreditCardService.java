package com.malihong.service;

import java.util.List;

import com.malihong.entity.Creditcard;

public interface CreditCardService {
public void add(Creditcard c);
	
	public void delete(Creditcard c);
	
	public void update(Creditcard c);
	
	public List<Creditcard> findByUserId(int uid);
}
