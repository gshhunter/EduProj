/**
 * 
 */
package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Plan> findPlansByRequestId(int rid) {
		String str = "SELECT p FROM Plan p WHERE r.idPlan = ?1";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, rid);
		List<Plan> list = query.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Plan findByRequestIdAndAgencyId(int rid, int aid) {
		String str = "SELECT p FROM Plan p WHERE r.idPlan = ?1 AND r.idAgency = ?2";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, rid);
		query.setParameter(2, aid);
		List<Plan> list = query.getResultList();
		if (list.isEmpty() == true) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Plan> findPlansByAgencyId(int aid) {
		String str = "SELECT p FROM Plan p WHERE r.idAgency = ?1";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, aid);
		List<Plan> list = query.getResultList();
		return list;
	}

}
