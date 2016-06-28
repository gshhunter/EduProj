/**
 * 
 */
package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Option;

/**
 * @author GSH1
 *
 */

@Component
public class OptionDaoImpl implements OptionDao{

	private static final Logger logger = LoggerFactory.getLogger(OptionDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Option o) {
		em.persist(o);
	}

	@Override
	@Transactional
	public void delete(Option o) {
		em.remove(em.merge(o));
		em.flush();
	}

	@Override
	@Transactional
	public void update(Option o) {
		em.merge(o);
		em.flush();
	}

}
