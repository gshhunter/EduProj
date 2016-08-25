package com.malihong.dao;

import java.util.List;

import com.malihong.entity.FoundationCourse;

public interface FoundationCourseDao {
	public FoundationCourse findCourseById(int cid);
	public List<FoundationCourse> findCourseByCollegeId(int cid);
}
