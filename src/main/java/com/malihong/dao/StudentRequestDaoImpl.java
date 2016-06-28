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

import com.malihong.entity.Request;

/**
 * @author GSH1
 *
 */

@Component
public class StudentRequestDaoImpl implements StudentRequestDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Request r) {
		em.persist(r);
	}

	@Override
	@Transactional
	public void delete(Request r) {
		em.remove(em.merge(r));
		em.flush();
	}

	@Override
	@Transactional
	public void update(Request r) {
		System.out.println(r);
		em.merge(r);
		em.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Request> findRequestsByUserId(int uid) {
		String str = "SELECT r FROM Request r WHERE r.idAccount = ?1";
		Query query = em.createQuery(str, Request.class);
		query.setParameter(1, uid);
		return query.getResultList();
	}

}
