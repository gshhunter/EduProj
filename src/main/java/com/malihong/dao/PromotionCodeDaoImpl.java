package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.PromotionCode;

@Component("PromotionCodeDao")

public class PromotionCodeDaoImpl implements PromotionCodeDao{

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void add(PromotionCode pc) {
		em.persist(pc);
	}

	@Override
	@Transactional
	public void delete(PromotionCode pc) {
		em.remove(em.merge(pc));
		em.flush();		
	}

	@Override
	@Transactional
	public void update(PromotionCode pc) {
		em.merge(pc);
		em.flush();		
	}

	@Override
	@Transactional
	public PromotionCode getEntityByCodeAndType(String code, int type) {
		String str = "SELECT pc FROM PromotionCode pc WHERE pc.code = ?1 AND pc.type = ?2 AND pc.status=0";
		Query query = em.createQuery(str, PromotionCode.class);
		query.setParameter(1, code);
		query.setParameter(2, type);
		List<PromotionCode> list = query.getResultList();
		if (list.isEmpty() == true) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
