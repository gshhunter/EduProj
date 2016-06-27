package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.malihong.entity.Profile;

public class ProfileDaoImpl implements ProfileDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Profile profile) {
		em.persist(profile);
	}

}
