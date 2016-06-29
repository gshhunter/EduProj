package com.malihong.dao;

import java.util.List;

import com.malihong.entity.Plan;

public interface PlanDao {

	public void add(Plan p);
	
	public void delete(Plan p);
	
	public void update(Plan p);
	
	public List<Plan> findPlansByRequestId(int rid);
	
	public Plan findByRequestIdAndAgencyId(int rid, int aid);
	
	public List<Plan> findPlansByAgencyId(int aid);
}
