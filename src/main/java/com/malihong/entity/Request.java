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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="current_degree")
	private String currentDegree;

	@Column(name="gaokao_result")
	private int gaokaoResult;

	@Column(name="id_account")
	private int idAccount;

	@Column(name="interest_city")
	private String interestCity;

	@Column(name="interest_major1")
	private String interestMajor1;

	@Column(name="interest_major2")
	private String interestMajor2;

	@Column(name="is_cancel")
	private String isCancel;

	@Column(name="language_testing")
	private String languageTesting;

	@Column(name="listening_score")
	private double listeningScore;

	@Column(name="overall_score")
	private double overallScore;

	@Column(name="reading_score")
	private double readingScore;

	@Column(name="speaking_score")
	private double speakingScore;

	private String status;

	@Column(name="writing_score")
	private double writingScore;

	public Request() {
	}

	public int getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCurrentDegree() {
		return this.currentDegree;
	}

	public void setCurrentDegree(String currentDegree) {
		this.currentDegree = currentDegree;
	}

	public int getGaokaoResult() {
		return this.gaokaoResult;
	}

	public void setGaokaoResult(int gaokaoResult) {
		this.gaokaoResult = gaokaoResult;
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
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

	public String getIsCancel() {
		return this.isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public String getLanguageTesting() {
		return this.languageTesting;
	}

	public void setLanguageTesting(String languageTesting) {
		this.languageTesting = languageTesting;
	}

	public double getListeningScore() {
		return this.listeningScore;
	}

	public void setListeningScore(double listeningScore) {
		this.listeningScore = listeningScore;
	}

	public double getOverallScore() {
		return this.overallScore;
	}

	public void setOverallScore(double overallScore) {
		this.overallScore = overallScore;
	}

	public double getReadingScore() {
		return this.readingScore;
	}

	public void setReadingScore(double readingScore) {
		this.readingScore = readingScore;
	}

	public double getSpeakingScore() {
		return this.speakingScore;
	}

	public void setSpeakingScore(double speakingScore) {
		this.speakingScore = speakingScore;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getWritingScore() {
		return this.writingScore;
	}

	public void setWritingScore(double writingScore) {
		this.writingScore = writingScore;
	}

}