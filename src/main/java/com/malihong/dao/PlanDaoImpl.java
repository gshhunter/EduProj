/**
 * 
 */
package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Plan;

/**
 * @author GSH1
 *
 */

@Component
public class PlanDaoImpl implements PlanDao{
	
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
	public Plan findByRequestIdAndAgencyId(Integer rid, Integer aid) {
		String str = "SELECT p FROM Plan p WHERE p.idRequest = ?1 AND p.idAgency = ?2";
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
		String str = "SELECT p FROM Plan p WHERE p.idAgency = ?1";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, aid);
		List<Plan> list = query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<Plan> findPlansByRequestId(int rid) {
		String str = "SELECT p FROM Plan p WHERE p.idRequest = ?1";
		Query query = em.createQuery(str, Plan.class);
		List<Plan> list=query.setParameter(1, rid).getResultList();	
		return list;
	}

	@Override
	@Transactional
	public Plan findPlanById(int pid) {
		return em.find(Plan.class, pid);
	}

	@Override
	@Transactional
	public List<Plan> findUnprocessedPlanListByPage(int agentId, int pageNum, int listNum) {
		int start = (pageNum - 1)*listNum;
		String str = "SELECT p Plan p WHERE p.idAgency =?1 AND p.status = 1 LIMIT ?2, ?3";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, agentId);
		query.setParameter(2, start);
		query.setParameter(3, listNum);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public int countUnprocessedPlan(int agentId) {
		String str = "SELECT count(p.id_plan) FROM edu.e_plan p WHERE p.id_agency = ?1 AND p.status = 1";
		int count = 0;
		TypedQuery<Integer> query = em.createNamedQuery(str, Integer.class);
		query.setParameter(1, agentId);
		count = query.getSingleResult();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Plan> findProcessedPlanListByPage(int agentId, int pageNum, int listNum) {
		int start = (pageNum - 1)*listNum;
		String str = "SELECT p Plan p WHERE p.idAgency =?1 AND p.status = 2 LIMIT ?2, ?3";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, agentId);
		query.setParameter(2, start);
		query.setParameter(3, listNum);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public int countProcessedPlan(int agentId) {
		String str = "SELECT count(p.id_plan) FROM edu.e_plan p WHERE p.id_agency = ?1 AND p.status = 2";
		int count = 0;
		TypedQuery<Integer> query = em.createNamedQuery(str, Integer.class);
		query.setParameter(1, agentId);
		count = query.getSingleResult();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Plan> findUnprocessedPlanListByAgentId(int agentId) {
		String str = "SELECT p FROM Plan p WHERE p.idAgency =?1 AND p.status = 1";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, agentId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Plan> findProcessedPlanListByAgentId(int agentId) {
		String str = "SELECT p FROM Plan p WHERE p.idAgency =?1 AND p.status = 2";
		Query query = em.createQuery(str, Plan.class);
		query.setParameter(1, agentId);
		return query.getResultList();
	}


}
