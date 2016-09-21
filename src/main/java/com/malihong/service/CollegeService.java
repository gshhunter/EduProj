package com.malihong.service;

import java.util.List;

import com.malihong.entity.BachelorCourse;
import com.malihong.entity.College;
import com.malihong.entity.DiplomaCourse;
import com.malihong.entity.FoundationCourse;

public interface CollegeService {
	public List<College> findCollegesByType(int type);
	public College findCollegeById(int id);
	public List<BachelorCourse> findBachelorCourseByUniversityId(int uid);
	public List<DiplomaCourse> findDiplomaCourseByCollegeId(int cid);
	public List<FoundationCourse> findFoundationCourseByCollegeId(int cid);
}
