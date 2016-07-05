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

@Component("requestDao")
public class StudentRequestDaoImpl implements StudentRequestDao {

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Request findValidRequestByUserId(int uid) {
		String str = "SELECT r FROM Request r WHERE r.idAccount = ?1 and r.isCancel = 1";
		Query query = em.createQuery(str, Request.class);
		query.setParameter(1, uid);
		List<Request> list = query.getResultList();
		if (list.isEmpty() == true) {
			return null;
		} else {
			return (Request) list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Request> findCancelledRequestByUserId(int uid) {
		String str = "SELECT r FROM Request r WHERE r.idAccount = ?1 and r.isCancel = 0";
		Query query = em.createQuery(str, Request.class);
		query.setParameter(1, uid);
		List<Request> list = query.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Request> findFinishedRequestsByUserId(int uid) {
		String str = "SELECT r FROM Request r WHERE r.idAccount = ?1 and r.isCancel = 2";
		Query query = em.createQuery(str, Request.class);
		query.setParameter(1, uid);
		List<Request> list = query.getResultList();
		return list;
	}

	@Override
	@Transactional
	public int countResponsedConcelledApplyByUserId(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public boolean setIsConcelStatusById(int id, int status) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public Request findRequestingApplyByUserId(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
