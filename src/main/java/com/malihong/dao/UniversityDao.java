package com.malihong.dao;

import java.util.List;

import com.malihong.entity.University;

public interface UniversityDao {
	
	public University findUniversityById(int uid);
	
	public List<University> findAllUniversity();
}
