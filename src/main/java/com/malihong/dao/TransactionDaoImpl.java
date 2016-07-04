package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Transaction;

@Component
public class TransactionDaoImpl implements TransactinDao{

	private static final Logger logger = LoggerFactory.getLogger(TransactionDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Transaction findTransactionById(int id) {
		return em.find(Transaction.class, id);
	}

	@Override
	@Transactional
	public Transaction findTransactionByOrderId(int orderId) {
		Query q = em.createQuery("select * from Transaction where idOrder=?1");
		q.setParameter(1, orderId);
		return  (Transaction) q.getSingleResult();
	}

}
