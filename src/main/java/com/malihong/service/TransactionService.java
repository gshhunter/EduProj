package com.malihong.service;

import com.malihong.entity.Transaction;

public interface TransactionService {
	public Transaction findTransactionById(int id);
	public Transaction findTransactionByOrderId(int orderId);
}
