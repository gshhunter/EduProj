package com.malihong.bean;

import java.util.HashMap;
import java.util.List;

import com.malihong.entity.DiplomaCourse;
import com.malihong.entity.FoundationCourse;
import com.malihong.entity.Option;

public class sysOption {
	public int collegeId;
	public String collegeName;
	
	public int diplomaId;
	public String diplomaName;
	public int tuition;
	public int tuitionp2;
	public int semesters;
	
	public int foundationId;
	public String foundationName;
	public int foundationTuition;
	public int foundationSemesters;
	
	public int universityId;
	public String universityName;
	public HashMap<Integer,String> bachelors;
	
	public String advice;
	
	public sysOption(){};
	
	public sysOption(Option o){
		this.collegeId=o.getIdCollege();
		this.collegeName=o.getCollegeName();
		this.diplomaId=o.getIdDiplomaCourse();
		this.diplomaName=o.getDiplomaCourseName();
		this.tuition=o.getDiplomaTuition();
		this.tuitionp2=o.getDiplomaP2Tuition();
		this.semesters=o.getDiplomaSemesters();
		
		this.foundationId=o.getIdFoundationCourse();
		this.foundationName=o.getFoundationCourseName();
		this.foundationTuition=o.getFoundationTuition();
		this.foundationSemesters=o.getFoundationSemesters();
		
		this.universityId=o.getIdUniversity();
		this.universityName=o.getUnivercityName();
	}
	
	public void setDiplomaInfo(DiplomaCourse dc){
		this.collegeId=dc.getCollegeId();
		this.collegeName=dc.getCollegeName();
		this.diplomaId=dc.getCourseId();
		this.diplomaName=dc.getName();
		this.tuition=dc.getTuition();
		this.tuitionp2=dc.getP2Tuition();
		this.semesters=dc.getSemesters();		
	}
	
	public void setFoundationInfo(FoundationCourse fc){
		this.foundationId=fc.getCourseId();
		this.foundationName=fc.getName();
		this.foundationTuition=fc.getTuition();
		this.foundationSemesters=fc.getSemesters();
	}
}
