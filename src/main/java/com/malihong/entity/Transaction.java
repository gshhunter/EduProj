package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the e_transaction database table.
 * 
 */
@Entity
@Table(name="e_transaction")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_transaction")
	private int idTransaction;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="id_order")
	private int idOrder;

	@Column(name="id_payee_card")
	private int idPayeeCard;

	@Column(name="id_payer_card")
	private int idPayerCard;

	@Column(name="is_done")
	private String isDone;

	@Column(name="total_amount")
	private double totalAmount;

	@Column(name="transaction_type")
	private String transactionType;

	public Transaction() {
	}

	public int getIdTransaction() {
		return this.idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdPayeeCard() {
		return this.idPayeeCard;
	}

	public void setIdPayeeCard(int idPayeeCard) {
		this.idPayeeCard = idPayeeCard;
	}

	public int getIdPayerCard() {
		return this.idPayerCard;
	}

	public void setIdPayerCard(int idPayerCard) {
		this.idPayerCard = idPayerCard;
	}

	public String getIsDone() {
		return this.isDone;
	}

	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}