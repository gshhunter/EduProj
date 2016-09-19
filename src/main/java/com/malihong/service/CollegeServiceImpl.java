package com.malihong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.BachelorCourseDao;
import com.malihong.dao.CollegeDao;
import com.malihong.dao.DiplomaCourseDao;
import com.malihong.dao.FoundationCourseDao;
import com.malihong.entity.BachelorCourse;
import com.malihong.entity.College;
import com.malihong.entity.DiplomaCourse;
import com.malihong.entity.FoundationCourse;

@Service
@Qualifier("collegeService")
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeDao collegeDao;
	@Autowired
	private BachelorCourseDao bcDao;
	@Autowired
	private DiplomaCourseDao dcDao;
	@Autowired
	private FoundationCourseDao fcDao;
	
	@Override
	public List<College> findCollegesByType(int type) {
		return this.collegeDao.findCollegesByType(type);
	}

	@Override
	public List<BachelorCourse> findBachelorCourseByUniversityId(int uid) {
		return this.bcDao.findCourseByUniversityId(uid);
	}

	@Override
	public List<DiplomaCourse> findDiplomaCourseByCollegeId(int cid) {
		return this.dcDao.findCourseByCollegeId(cid);
	}

	@Override
	public List<FoundationCourse> findFoundationCourseByCollegeId(int cid) {
		return this.fcDao.findCourseByCollegeId(cid);
	}

	@Override
	public College findCollegeById(int id) {
		return collegeDao.findCollegeById(id);
	}

}
