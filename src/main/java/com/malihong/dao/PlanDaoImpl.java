/**
 * 
 */
package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Plan;

/**
 * @author GSH1
 *
 */

@Component
public class PlanDaoImpl implements PlanDao{

	//private static final Logger logger = LoggerFactory.getLogger(PlanDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Plan p) {
		em.persist(p);
	}

	@Override
	@Transactional
	public void delete(Plan p) {
		em.remove(em.merge(p));
		em.flush();
	}

	@Override
	@Transactional
	public void update(Plan p) {
		em.merge(p);
		em.flush();
	}

}
