package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the e_plan database table.
 * 
 */
@Entity
@Table(name="e_plan")
@NamedQuery(name="Plan.findAll", query="SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_plan")
	private int idPlan;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="id_agency")
	private int idAgency;

	@Column(name="id_request")
	private int idRequest;

	@Column(name="id_student")
	private int idStudent;

	//bi-directional many-to-one association to Option
	@OneToMany(mappedBy="EPlan")
	private List<Option> EOptions;

	public Plan() {
	}

	public int getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getIdAgency() {
		return this.idAgency;
	}

	public void setIdAgency(int idAgency) {
		this.idAgency = idAgency;
	}

	public int getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public int getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public List<Option> getEOptions() {
		return this.EOptions;
	}

	public void setEOptions(List<Option> EOptions) {
		this.EOptions = EOptions;
	}

	public Option addEOption(Option EOption) {
		getEOptions().add(EOption);
		EOption.setEPlan(this);

		return EOption;
	}

	public Option removeEOption(Option EOption) {
		getEOptions().remove(EOption);
		EOption.setEPlan(null);

		return EOption;
	}

}