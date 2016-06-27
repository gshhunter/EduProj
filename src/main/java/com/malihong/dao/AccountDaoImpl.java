package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Account;

@Component
public class AccountDaoImpl implements AccountDao {

	private static final Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(Account account) {
		em.persist(account);
	}

	@Override
	@Transactional
	public Account findById(int id) {
		Account account = (Account)em.find(Account.class, id);
		return account;
	}

	@Override
	public void delete(Account account) {
		em.remove(em.merge(account));
		em.flush();
	}

	@Override
	public void update(Account account) {
		System.out.println(account);
		em.merge(account);
		em.flush();
	}
	
	
}
