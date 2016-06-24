package com.malihong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malihong.dao.UniversityDao;
import com.malihong.entity.University;

@Service("universityService")
public class UniversityServiceImpl implements UniversityService{

	@Autowired
	private UniversityDao universityDao;
	
	@Override
	public University findUniversityById(int uid) {
		return universityDao.findUniversityById(uid);
	}

	@Override
	public List<University> findAllUniversity() {
		return universityDao.findAllUniversity();
	}

}
