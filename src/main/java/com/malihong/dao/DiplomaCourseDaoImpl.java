package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.BachelorCourse;
import com.malihong.entity.DiplomaCourse;

@Component
public class DiplomaCourseDaoImpl implements DiplomaCourseDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public DiplomaCourse findCourseById(int cid) {
		return em.find(DiplomaCourse.class,cid);
	}

	@Override
	@Transactional
	public List<DiplomaCourse> findCoursesByField(String field) {
		String str = "SELECT dc FROM DiplomaCourse dc WHERE dc.field like ?1";
		Query query = em.createQuery(str, DiplomaCourse.class);
		String s="%&"+field+"&%";
		query.setParameter(1, s);
		List<DiplomaCourse> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}	
	}

	@Override
	@Transactional
	public List<DiplomaCourse> findCourseByCollegeId(int cid) {
		String str = "SELECT dc FROM DiplomaCourse dc WHERE dc.collegeId like ?1";
		Query query = em.createQuery(str, DiplomaCourse.class);
		query.setParameter(1, cid);
		List<DiplomaCourse> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}	
	}

}
