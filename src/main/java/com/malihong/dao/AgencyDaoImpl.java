package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Agency;

@Component
public class AgencyDaoImpl implements AgencyDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public List<Agency> getAgencyList(int count) {
		String str="select a from Agency a order by rand()";
		Query query =em.createQuery(str).setMaxResults(count);
		return query.getResultList();
	}

}
