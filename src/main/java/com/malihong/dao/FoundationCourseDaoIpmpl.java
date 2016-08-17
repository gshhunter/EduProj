package com.malihong.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
