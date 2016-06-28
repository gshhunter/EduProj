/**
 * 
 */
package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Creditcard;

/**
 * @author GSH1
 *
 */
@Component
public class CreditCardDaoImpl implements CreditCardDao{

	private static final Logger logger = LoggerFactory.getLogger(CreditCardDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(Creditcard c) {
		em.persist(c);
	}

	@Override
	@Transactional
	public void delete(Creditcard c) {
		em.remove(em.merge(c));
		em.flush();
	}

	@Override
	@Transactional
	public void update(Creditcard c) {
		logger.info(c.getCardno());
		em.merge(c);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Creditcard> findByUserId(int uid) {
		String str = "SELECT c FROM Creditcard c WHERE c.idAccount = ?1";
		Query query = em.createQuery(str, Creditcard.class);
		query.setParameter(1, uid);
		return query.getResultList();
	}
	
	
}
