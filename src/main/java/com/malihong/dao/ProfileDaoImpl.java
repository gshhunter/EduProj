package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Profile;

@Component
public class ProfileDaoImpl implements ProfileDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(Profile profile) {
		em.persist(profile);
	}

}
