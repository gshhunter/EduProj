package com.malihong.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="uni_college")
@NamedQuery(name="College.findAll", query="SELECT c FROM College c")
public class College implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_college")
	private int collegeId;
	@Column(name="type")
	private int type;
	@Column(name="name")
	private String name;
	
	public College() {
	}

	public int getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
