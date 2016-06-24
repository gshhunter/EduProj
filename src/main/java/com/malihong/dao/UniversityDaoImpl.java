package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.malihong.entity.University;

@Component
public class UniversityDaoImpl implements UniversityDao{

	private static final Logger logger = LoggerFactory.getLogger(UniversityDaoImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public University findUniversityById(int uid) {
		String str = "SELECT u FROM University u WHERE u.id_eUni = ?1";
		Query query = em.createQuery(str, University.class);
		query.setParameter(1, uid);
		
		University u = null;
		try {
			u = (University)query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("There is no result");
		}
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<University> findAllUniversity() {
		Query query = em.createQuery("FROM University");
		return query.getResultList();
	}

}
