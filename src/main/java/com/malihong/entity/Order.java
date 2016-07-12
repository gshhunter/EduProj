package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the e_order database table.
 * 
 */
@Entity
@Table(name="e_order")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_order")
	private int idOrder;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="complete_time")
	private Date completeTime;
	
	@Column(name="id_agency")
	private int idAgency;

	@Column(name="id_plan")
	private int idPlan;

	@Column(name="id_student")
	private int idStudent;

	@Column(name="status")
	private int status;

	@Column(name="transaction_count")
	private int transactionCount;
	
	private Double price;

	public Order() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	
	public int getIdAgency() {
		return this.idAgency;
	}

	public void setIdAgency(int idAgency) {
		this.idAgency = idAgency;
	}

	public int getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getTransactionCount() {
		return this.transactionCount;
	}

	public void setTransactionCount(int transactionCount) {
		this.transactionCount = transactionCount;
	}
	
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}