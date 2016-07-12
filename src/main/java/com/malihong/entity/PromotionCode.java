package com.malihong.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="promotion_code")
@NamedQuery(name="PromotionCode.findAll", query="SELECT p FROM PromotionCode p")
public class PromotionCode implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_promotion_code")
	private int idPromotionCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expired_time")
	private Date expiredTime;
	
	@Column(name="type")
	private int type;
	
	@Column(name="status")
	private int status;
	
	@Column(name="code")
	private String code;
	
	public PromotionCode() {
	}

	public int getIdPromotionCode() {
		return this.idPromotionCode;
	}

	public void setIdPromotionCode(int idPromotionCode) {
		this.idPromotionCode = idPromotionCode;
	}
	
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	public Date getExpiredTime() {
		return this.expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
