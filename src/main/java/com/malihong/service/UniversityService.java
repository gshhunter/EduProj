package com.malihong.service;


import java.util.List;

import com.malihong.entity.University;

public interface UniversityService {

	public University findUniversityById(int uid);
	
	public List<University> findAllUniversity(int start);
	public University addUniversity(University u);
	public University updateUniversity(University u);
	public boolean deleteUniversityById(int uid);
	
	public List<University> findUniversityByCity(String city);
	public List<String> getAllCity();
}
