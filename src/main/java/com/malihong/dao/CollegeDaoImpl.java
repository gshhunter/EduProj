package com.malihong.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.College;

@Component
public class CollegeDaoImpl implements CollegeDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public List<College> findCollegesByType(int type) {
		String str="select c from College c where c.type= ?1";
		Query query = em.createQuery(str, College.class);
		query.setParameter(1, type);
		List<College> list =query.getResultList();
		if(list.isEmpty()){
			return null;
		}else{
			return list;
		}
		
	}

}
