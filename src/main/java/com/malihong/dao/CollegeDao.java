package com.malihong.dao;

import java.util.List;

import com.malihong.entity.College;

public interface CollegeDao {
	public List<College> findCollegesByType(int type);
	
	public College findCollegeById(int id);
	
	public List<College> findUniversityByPage (int type, Integer pageIndex, Integer pageSize);

	Integer getTotalCountOfUniversity(int type);
}
