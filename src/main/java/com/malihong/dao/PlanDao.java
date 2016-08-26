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
	
	public List<Plan> findUnprocessedPlanListByPage(int agentId, int pageNum, int listNum);
	
	public int countUnprocessedPlan(int agentId);
	
	public List<Plan> findProcessedPlanListByPage(int agentId, int pageNum, int listNum);
	
	public int countProcessedPlan(int agentId);
	
	public List<Plan> findUnprocessedPlanListByAgentId(int agentId);
	
	public List<Plan> findProcessedPlanListByAgentId(int agentId);

}
