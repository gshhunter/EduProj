package com.malihong.service;

import java.util.List;

import com.malihong.entity.Plan;

public interface PlanService {
	public Plan findPlanById(int pid);
	public void add(Plan p);
	
	public void update(Plan p);
	
	public List<Plan> findPlansByRequestId(int rid);
	
	public List<Plan> findPlansByAgencyId(int aid);
}
