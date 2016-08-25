package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.FoundationCourse;

@Component
public class FoundationCourseDaoIpmpl implements FoundationCourseDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public FoundationCourse findCourseById(int cid) {
		return em.find(FoundationCourse.class,cid);
	}

	@Override
	@Transactional
	public List<FoundationCourse> findCourseByCollegeId(int cid) {
		String str = "SELECT fc FROM FoundationCourse fc WHERE fc.collegeId like ?1";
		Query query = em.createQuery(str, FoundationCourse.class);
		query.setParameter(1, cid);
		List<FoundationCourse> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

}
