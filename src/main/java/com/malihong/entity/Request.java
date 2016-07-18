package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the e_request database table.
 * 
 */
@Entity
@Table(name="e_request")
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_request")
	private int idRequest;

	@Column(name="id_account")
	private int idAccount;

	@Column(name="is_cancel")
	private int isCancel;	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="current_degree")
	private int currentDegree;

	@Column(name="gaokao_result")
	private double gaokaoResult;

	@Column(name="gaokao_location")
	private String gaokaoLocation;

	@Column(name="gaokao_year")
	private int gaokaoYear;
	
	@Column(name="interest_city")
	private String interestCity;

	@Column(name="interest_major1")
	private String interestMajor1;

	@Column(name="interest_major2")
	private String interestMajor2;

	public Request() {
	}

	public int getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	
	public int getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}
	
	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getCurrentDegree() {
		return this.currentDegree;
	}

	public void setCurrentDegree(int currentDegree) {
		this.currentDegree = currentDegree;
	}

	public double getGaokaoResult() {
		return this.gaokaoResult;
	}

	public void setGaokaoResult(double gaokaoResult) {
		this.gaokaoResult = gaokaoResult;
	}

	public String getGaokaoLocation() {
		return this.gaokaoLocation;
	}

	public void setGaokaoLocation(String gaokaoLocation) {
		this.gaokaoLocation = gaokaoLocation;
	}
	
	public int getGaokaoYear() {
		return this.gaokaoYear;
	}

	public void setGaokaoYear(int gaokaoYear) {
		this.gaokaoYear = gaokaoYear;
	}
	public String getInterestCity() {
		return this.interestCity;
	}

	public void setInterestCity(String interestCity) {
		this.interestCity = interestCity;
	}

	public String getInterestMajor1() {
		return this.interestMajor1;
	}

	public void setInterestMajor1(String interestMajor1) {
		this.interestMajor1 = interestMajor1;
	}

	public String getInterestMajor2() {
		return this.interestMajor2;
	}

	public void setInterestMajor2(String interestMajor2) {
		this.interestMajor2 = interestMajor2;
	}


}