package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Identification;

@Component
public class IdentDaoImpl implements IdentDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(Identification ident) {
		em.persist(ident);
	}

}
