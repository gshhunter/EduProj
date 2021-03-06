package com.malihong.dao;

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
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<College> findCollegesByType(int type) {
		String str="select c from College c where c.type= ?1";
		Query query = em.createQuery(str, College.class);
		query.setParameter(1, type);
		List<College> list = query.getResultList();
		if(list.isEmpty()){
			return null;
		}else{
			return list;
		}
		
	}

	@Override
	@Transactional
	public College findCollegeById(int id) {
		return (College)em.find(College.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<College> findUniversityByPage (int type, Integer pageIndex, Integer pageSize) {
		String str = "select c from College c where c.type = ?1 order by c.aus_rank";
		Query query = em.createQuery(str, College.class);
		query.setParameter(1, type);
		query.setFirstResult((pageIndex-1)*pageSize);
		query.setMaxResults(pageSize);
		List<College> clist = query.getResultList();
		return clist;
	}
	
	@Override
	@Transactional
	public Integer getTotalCountOfUniversity(int type) {
	    return Integer.valueOf(em.createQuery(
	            "SELECT COUNT(*) FROM College c WHERE c.type = ?1")
	.setParameter(1,type).getSingleResult().toString());
	}
}
