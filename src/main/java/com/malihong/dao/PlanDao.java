package com.malihong.dao;

import java.util.List;

import com.malihong.entity.Plan;

public interface PlanDao {
	public Plan findPlanById(int pid);
	public void add(Plan p);
	
	public void delete(Plan p);
	
	public void update(Plan p);
		
	public Plan findByRequestIdAndAgencyId(Integer rid, Integer aid);
	
	public List<Plan> findPlansByAgencyId(int aid);
	
	public List<Plan> findPlansByRequestId(int rid);
}
