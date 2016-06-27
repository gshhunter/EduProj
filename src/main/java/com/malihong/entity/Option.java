package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the e_option database table.
 * 
 */
@Entity
@Table(name="e_option")
@NamedQuery(name="Option.findAll", query="SELECT o FROM Option o")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_option")
	private int idOption;

	private String advice;

	private String course;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	private String entry;

	@Column(name="is_foundation")
	private String isFoundation;

	@Column(name="no_of_week")
	private int noOfWeek;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	private String university;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name="id_plan")
	private Plan EPlan;

	public Option() {
	}

	public int getIdOption() {
		return this.idOption;
	}

	public void setIdOption(int idOption) {
		this.idOption = idOption;
	}

	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEntry() {
		return this.entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getIsFoundation() {
		return this.isFoundation;
	}

	public void setIsFoundation(String isFoundation) {
		this.isFoundation = isFoundation;
	}

	public int getNoOfWeek() {
		return this.noOfWeek;
	}

	public void setNoOfWeek(int noOfWeek) {
		this.noOfWeek = noOfWeek;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Plan getEPlan() {
		return this.EPlan;
	}

	public void setEPlan(Plan EPlan) {
		this.EPlan = EPlan;
	}

}