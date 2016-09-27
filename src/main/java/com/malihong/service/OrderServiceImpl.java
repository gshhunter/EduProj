package com.malihong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.OrderDao;
import com.malihong.entity.Order;

@Service
@Qualifier("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	@Override
	public Order findOrderById(int id) {
		return this.orderDao.findOrderById(id);
	}

	@Override
	public Order findOrderByAgencyId(int agencyId) {
		return this.orderDao.findOrderByAgencyId(agencyId);
	}

	@Override
	public Order findOrderByStudentId(int studentId) {
		return this.orderDao.findOrderByStudentId(studentId);
	}

	@Override
	public List<Order> findOrderbyPriceRange(Double minPrice, Double maxPrice) {
		return this.orderDao.findOrderbyPriceRange(minPrice, maxPrice);
	}

	@Override
	public void add(Order o) {
		this.orderDao.add(o);
	}

	@Override
	public void update(Order o) {
		this.orderDao.update(o);
	}

	@Override
	public boolean isPaid(int accountId, int type) {
		if(this.orderDao.findOrderByPurchaserAndType(accountId, type)==null){
			return false;
		}else{
			return true;
		}
	}

}
