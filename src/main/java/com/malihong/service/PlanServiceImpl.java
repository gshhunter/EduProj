package com.malihong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.PlanDao;
import com.malihong.entity.Plan;

@Service
@Qualifier("planService")
public class PlanServiceImpl implements PlanService{

	@Autowired
	private PlanDao planDao;
	
	@Override
	public void add(Plan p) {
		planDao.add(p);
	}

	@Override
	public void update(Plan p) {
		planDao.update(p);
	}

	@Override
	public List<Plan> findPlansByRequestId(int rid) {
		return planDao.findPlansByRequestId(rid);
	}

	@Override
	public List<Plan> findPlansByAgencyId(int aid) {
		return planDao.findPlansByAgencyId(aid);
	}

}
