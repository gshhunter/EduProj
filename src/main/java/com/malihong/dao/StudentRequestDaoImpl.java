/**
 * 
 */
package com.malihong.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Request;

/**
 * @author GSH1
 *
 */

@Component("requestDao")
public class StudentRequestDaoImpl implements StudentRequestDao {

	private static final Logger logger = LoggerFactory.getLogger(StudentRequestDaoImpl.class);

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
		String str = "SELECT r FROM Request r WHERE r.idAccount = ?1 and (r.isCancel = 0 OR r.isCancel = 1)";
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
		String str = "SELECT r FROM Request r WHERE r.idAccount = ?1 and (r.isCancel = 3 OR r.isCancel = 4)";
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
		String str = "SELECT r FROM Request r WHERE r.idAccount = ?1 and r.isCancel = 4";
		Query query = em.createQuery(str, Request.class);
		query.setParameter(1, uid);
		List<Request> list = query.getResultList();
		return list.size();
	}

	@Override
	@Transactional
	public List<Request> findActiveRequests() {
		logger.info("dao start");
		Date date=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, -2);
		Date last2Day=c.getTime();
				
		String str = "SELECT r FROM Request r WHERE (r.isCancel = 0 OR r.isCancel = 1) And r.createdTime between ?1 and ?2";
		Query query = em.createQuery(str, Request.class);
		query.setParameter(1, last2Day);
		query.setParameter(2, date);
		List<Request> list = query.getResultList();
		if(list.isEmpty()){
			logger.info("empty");
		}else{
			logger.info("dao end");
		}
		return list;
	}

}
