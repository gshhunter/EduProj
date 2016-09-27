package com.malihong.dao;

import com.malihong.entity.Order;

import java.util.List;

public interface OrderDao {
	public Order findOrderById(int id);	
	public Order findOrderByAgencyId(int agencyId);
	public Order findOrderByStudentId(int studentId);
	public List<Order> findOrderbyPriceRange(Double minPrice,Double maxPrice);
	
	public void add(Order o);
	public void update(Order o);
	
	public Order findOrderByPurchaserAndType(int pid, int type);
}
