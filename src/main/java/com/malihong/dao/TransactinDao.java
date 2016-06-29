package com.malihong.dao;

import com.malihong.entity.Transaction;

public interface TransactinDao {
	public Transaction findTransactionById(int id);
	public Transaction findTransactionByOrderId(int orderId);
}
