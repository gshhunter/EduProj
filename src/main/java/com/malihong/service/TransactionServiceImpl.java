package com.malihong.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.malihong.entity.Transaction;

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionService transactionService;
	@Override
	public Transaction findTransactionById(int id) {
		return this.transactionService.findTransactionById(id);
	}

	@Override
	public Transaction findTransactionByOrderId(int orderId) {
		return this.findTransactionByOrderId(orderId);
	}

}
