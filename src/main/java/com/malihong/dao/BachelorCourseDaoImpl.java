package com.malihong.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.BachelorCourse;
import com.malihong.entity.DiplomaCourse;

@Component
public class BachelorCourseDaoImpl implements BachelorCourseDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public BachelorCourse findCourseById(int cid) {
		return em.find(BachelorCourse.class,cid);
	}

	@Override
	@Transactional
	public Object[] findCoursesByDiplomaIdAndField(int did, String field) {
		String str = "SELECT bc FROM BachelorCourse bc WHERE bc.diplomaId = ?1 AND bc.field like ?2";
		Query query = em.createQuery(str, BachelorCourse.class);
		query.setParameter(1, did);
		query.setParameter(2, "%&"+field+"&%");
		List<BachelorCourse> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			Object[] objs=new Object[3];
			HashMap<Integer,String> bcs= new HashMap<Integer,String>();
			for(BachelorCourse bc:list){
				bcs.put(bc.getCourseId(), bc.getName());
			}
			objs[0]=bcs;
			objs[1]=list.get(0).getUniversityId();
			objs[2]=list.get(0).getUniversityName();
			return objs;
		}
	}

	@Override
	@Transactional
	public List<BachelorCourse> findCourseByUniversityId(int uid) {
		String str = "SELECT bc FROM BachelorCourse bc WHERE bc.universityId = ?1";
		Query query = em.createQuery(str, BachelorCourse.class);
		query.setParameter(1, uid);
		List<BachelorCourse> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	@Override
	@Transactional
	public List<BachelorCourse> findCoursesByField(String field) {
		String str = "SELECT bc FROM BachelorCourse bc WHERE bc.field like ?1";
		Query query = em.createQuery(str, BachelorCourse.class);
		String s="%&"+field+"&%";
		query.setParameter(1, s);
		List<BachelorCourse> list = query.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

}
