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
	public int addNewUser(Account account) {
		
		try {
			em.persist(account);
			logger.info("Register successfully!");
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Failed to register!");
			return 0;
		}
	}
	
}
