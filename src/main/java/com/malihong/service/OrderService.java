package com.malihong.service;

import java.util.List;

import com.malihong.entity.Order;

public interface OrderService {
	public Order findOrderById(int id);	
	public Order findOrderByAgencyId(int agencyId);
	public Order findOrderByStudentId(int studentId);
	public List<Order> findOrderbyPriceRange(Double minPrice,Double maxPrice);
}
