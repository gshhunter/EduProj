package com.malihong.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.malihong.entity.Order;

@Component
public class OrderDaoImpl implements OrderDao {

	private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Order findOrderById(int id) {
		return em.find(Order.class, id);
	}

	@Override
	@Transactional
	public Order findOrderByAgencyId(int agencyId) {
		Query q = em.createQuery("select * from Order where idAgency=?1");
		q.setParameter(1, agencyId);
		return  (Order) q.getSingleResult();
	}

	@Override
	@Transactional
	public Order findOrderByStudentId(int studentId) {
		Query q = em.createQuery("select * from Order where idStudent=?1");
		q.setParameter(1, studentId);
		return  (Order) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Order> findOrderbyPriceRange(Double minPrice,Double maxPrice) {
		Query q = em.createQuery("select * from University where price between ?1 and ?2");
		q.setParameter(1, minPrice);
		q.setParameter(2, maxPrice);
		return q.getResultList();
	}

	@Override
	@Transactional
	public void add(Order o) {
		em.persist(o);
	}

	@Override
	@Transactional
	public void update(Order o) {
		em.merge(o);
		em.flush();
	}

	@Override
	@Transactional
	public Order findOrderByPurchaserAndType(int pid, int type) {
		String str = "SELECT o FROM Order o WHERE o.idPurchaser = ?1 AND o.type = ?2";
		Query query = em.createQuery(str, Order.class);
		query.setParameter(1, pid);
		query.setParameter(2, type);
		List<Order> list = query.getResultList();
		if (list.isEmpty() == true) {
			return null;
		} else {
			return list.get(0);
		}
	}

}
