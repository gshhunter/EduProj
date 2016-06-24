package com.malihong.service;


import java.util.List;

import com.malihong.entity.University;

public interface UniversityService {

	public University findUniversityById(int uid);
	
	public List<University> findAllUniversity();
}
