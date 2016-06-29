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
	public List<University> findAllUniversity(int start) {
		return universityDao.findAllUniversity(start);
	}

	@Override
	public University addUniversity(University u) {
		return universityDao.addUniversity(u);
	}

	@Override
	public University updateUniversity(University u) {
		return universityDao.updateUniversity(u);
	}

	@Override
	public boolean deleteUniversityById(int uid) {
		return universityDao.deleteUniversityById(uid);
	}

	@Override
	public List<University> findUniversityByCity(String city) {
		return universityDao.findUniversityByCity(city);
	}

	@Override
	public List<String> getAllCity() {
		return universityDao.getAllCity();
	}

}
