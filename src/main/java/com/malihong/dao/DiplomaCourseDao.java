package com.malihong.dao;

import java.util.List;

import com.malihong.entity.DiplomaCourse;

public interface DiplomaCourseDao {
	public DiplomaCourse findCourseById(int cid);
	public List<DiplomaCourse> findCoursesByField(String field);
	public List<DiplomaCourse> findCourseByCollegeId(int cid);
}
