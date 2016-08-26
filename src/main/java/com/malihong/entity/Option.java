package com.malihong.entity;

import java.io.Serializable;
import javax.persistence.*;


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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_option")
	private int idOption;
	
	//bi-directional many-to-one association to Plan
	@Column(name="id_plan")
	private int idPlan;
	
	//new addition field
	@Column(name="status")
	private int status;
	
	@Column(name="advice")
	private String advice;

	@Column(name="id_college")
	private int idCollege;
	
	@Column(name="college_name")
	private String collegeName;
	
	@Column(name="foundation_semesters")
	private int foundationSemesters;
	
	@Column(name="foundation_tuition")
	private int foundationTuition;
	
	@Column(name="id_foundation_course")
	private int idFoundationCourse;
	
	@Column(name="foundation_course_name")
	private String foundationCourseName;
	
	@Column(name="diploma_semesters")
	private int diplomaSemesters;
	
	@Column(name="diploma_tuition")
	private int diplomaTuition;
	
	@Column(name="diploma_p2_tuition")
	private int diplomaP2Tuition;
	
	@Column(name="id_diploma_course")
	private int idDiplomaCourse;
	
	@Column(name="diploma_course_name")
	private String diplomaCourseName;
	
	@Column(name="id_university")
	private int idUniversity;
	
	@Column(name="univercity_name")
	private String univercityName;
	
	@Column(name="bachelorSemesters")
	private int bachelorSemesters;
	
	@Column(name="bachelor_tuition")
	private int bachelorTuition;
	
	@Column(name="id_bachelor_course")
	private int idBachelorCourse;
	
	@Column(name="bachelor_course_name")
	private String bachelorCourseName;

	public int getIdOption() {
		return idOption;
	}

	public void setIdOption(int idOption) {
		this.idOption = idOption;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public int getIdCollege() {
		return idCollege;
	}

	public void setIdCollege(int idCollege) {
		this.idCollege = idCollege;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getFoundationSemesters() {
		return foundationSemesters;
	}

	public void setFoundationSemesters(int foundationSemesters) {
		this.foundationSemesters = foundationSemesters;
	}

	public int getFoundationTuition() {
		return foundationTuition;
	}

	public void setFoundationTuition(int foundationTuition) {
		this.foundationTuition = foundationTuition;
	}

	public int getIdFoundationCourse() {
		return idFoundationCourse;
	}

	public void setIdFoundationCourse(int idFoundationCourse) {
		this.idFoundationCourse = idFoundationCourse;
	}

	public String getFoundationCourseName() {
		return foundationCourseName;
	}

	public void setFoundationCourseName(String foundationCourseName) {
		this.foundationCourseName = foundationCourseName;
	}

	public int getDiplomaSemesters() {
		return diplomaSemesters;
	}

	public void setDiplomaSemesters(int diplomaSemesters) {
		this.diplomaSemesters = diplomaSemesters;
	}

	public int getDiplomaTuition() {
		return diplomaTuition;
	}

	public void setDiplomaTuition(int diplomaTuition) {
		this.diplomaTuition = diplomaTuition;
	}

	public int getDiplomaP2Tuition() {
		return diplomaP2Tuition;
	}

	public void setDiplomaP2Tuition(int diplomaP2Tuition) {
		this.diplomaP2Tuition = diplomaP2Tuition;
	}

	public int getIdDiplomaCourse() {
		return idDiplomaCourse;
	}

	public void setIdDiplomaCourse(int idDiplomaCourse) {
		this.idDiplomaCourse = idDiplomaCourse;
	}

	public String getDiplomaCourseName() {
		return diplomaCourseName;
	}

	public void setDiplomaCourseName(String diplomaCourseName) {
		this.diplomaCourseName = diplomaCourseName;
	}

	public int getIdUniversity() {
		return idUniversity;
	}

	public void setIdUniversity(int idUniversity) {
		this.idUniversity = idUniversity;
	}

	public String getUnivercityName() {
		return univercityName;
	}

	public void setUnivercityName(String univercityName) {
		this.univercityName = univercityName;
	}

	public int getBachelorSemesters() {
		return bachelorSemesters;
	}

	public void setBachelorSemesters(int bachelorSemesters) {
		this.bachelorSemesters = bachelorSemesters;
	}

	public int getBachelorTuition() {
		return bachelorTuition;
	}

	public void setBachelorTuition(int bachelorTuition) {
		this.bachelorTuition = bachelorTuition;
	}

	public int getIdBachelorCourse() {
		return idBachelorCourse;
	}

	public void setIdBachelorCourse(int idBachelorCourse) {
		this.idBachelorCourse = idBachelorCourse;
	}

	public String getBachelorCourseName() {
		return bachelorCourseName;
	}

	public void setBachelorCourseName(String bachelorCourseName) {
		this.bachelorCourseName = bachelorCourseName;
	}

	
}