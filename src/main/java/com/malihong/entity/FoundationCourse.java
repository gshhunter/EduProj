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
@Table(name="uni_foundation_course")
@NamedQuery(name="FoundationCourse.findAll", query="SELECT fc FROM FoundationCourse fc")
public class FoundationCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_course")
	private int courseId;
	private int type;
	private String name;
	@Column(name="id_college")
	private int collegeId;
	@Column(name="college_name")
	private String collegeName;
	private int tuition;
	private int semesters;
	private String field;
	
	public FoundationCourse() {
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	
	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public int getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	
	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	public int getTuition() {
		return this.tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
	
	public int getSemesters() {
		return this.semesters;
	}

	public void setSemesters(int semesters) {
		this.semesters = semesters;
	}
}