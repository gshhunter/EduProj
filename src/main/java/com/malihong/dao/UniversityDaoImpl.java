package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.malihong.entity.University;

@Component
public class UniversityDaoImpl implements UniversityDao {

	private static final Logger logger = LoggerFactory.getLogger(UniversityDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	/*
	 * @Override
	 * 
	 * @Transactional public University findUniversityById(int uid) { String str
	 * = "SELECT u FROM University u WHERE u.id = ?1"; Query query =
	 * em.createQuery(str, University.class); query.setParameter(1, uid);
	 * 
	 * University u = null; try { u = (University)query.getSingleResult(); }
	 * catch (NoResultException e) { // TODO Auto-generated catch block //
	 * e.printStackTrace(); logger.info("There is no result"); } return u; }
	 */

	@Override
	@Transactional
	public University findUniversityById(int uid) {
		University u = em.find(University.class, uid);
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<University> findAllUniversity(int start) {
		Query query = em.createQuery("from University");
		query.setFirstResult(start);
		query.setMaxResults(100);
		return query.getResultList();
	}

	@Override
	@Transactional
	public University addUniversity(University u) {
		try {
			em.persist(u);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	@Transactional
	public boolean deleteUniversityById(int uid) {
		try {
			em.remove(uid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public University updateUniversity(University u) {
		return em.merge(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<University> findUniversityByCity(String city) {
		Query q = em.createQuery("select * from University where city=?1");
		q.setParameter(1, city);
		return q.getResultList();
	}

	@Override
	@Transactional
	public List<String> getAllCity() {
		return null;
	}

}
