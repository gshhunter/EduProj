package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the e_creditcard database table.
 * 
 */
@Entity
@Table(name="e_creditcard")
@NamedQuery(name="Creditcard.findAll", query="SELECT c FROM Creditcard c")
public class Creditcard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_card")
	private int idCard;

	@Column(name="card_type")
	private String cardType;

	private String cardno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expire_date")
	private Date expireDate;

	private String holdername;

	@Column(name="id_account")
	private int idAccount;

	@Column(name="use_of_card")
	private String useOfCard;

	public Creditcard() {
	}

	public int getIdCard() {
		return this.idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getHoldername() {
		return this.holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getUseOfCard() {
		return this.useOfCard;
	}

	public void setUseOfCard(String useOfCard) {
		this.useOfCard = useOfCard;
	}

}