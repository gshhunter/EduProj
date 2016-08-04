package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uni_bachelor_course database table.
 * 
 */
@Entity
@Table(name="uni_bachelor_course")
@NamedQuery(name="BachelorCourse.findAll", query="SELECT bc FROM BachelorCourse bc")
public class BachelorCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_course")
	private int courseId;
	private int type;
	private String name;
	private String field;
	@Column(name="id_university")
	private int universityId;
	@Column(name="university_name")
	private String universityName;
	@Column(name="id_pre_diploma")
	private int diplomaId;
	private double tuition;
	private int semesters;
	
	public BachelorCourse() {
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
	
	public int getUniversityId() {
		return this.universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	
	public String getUniversityName() {
		return this.universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	public int getDiplomaId() {
		return this.diplomaId;
	}

	public void setDiplomaId(int diplomaId) {
		this.diplomaId = diplomaId;
	}
	
	public double getTuition() {
		return this.tuition;
	}

	public void setTuition(double tuition) {
		this.tuition = tuition;
	}
	
	public int getSemesters() {
		return this.semesters;
	}

	public void setSemesters(int semesters) {
		this.semesters = semesters;
	}
}