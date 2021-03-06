package com.malihong.service;

import java.util.List;
import com.malihong.entity.Plan;
import com.malihong.entity.Request;

public interface PlanService {
	public Plan findPlanById(int pid);
	public void add(Plan p);
	
	public void update(Plan p);
	
	public List<Plan> findPlansByRequestId(int rid);
	
	public List<Plan> findPlansByAgencyId(int aid);
	
	public List<Plan> findUnprocessedPlanListByPage(int agentId, int pageNum, int listNum);
	
	public int countUnprocessedPlan(int agentId);
	
	public List<Plan> findProcessedPlanListByPage(int agentId, int pageNum, int listNum);
	
	public int countProcessedPlan(int agentId);
	
	public List<Plan> findUnprocessedPlanListByAgentId(int agentId);
	
	public List<Plan> findProcessedPlanListByAgentId(int agentId);

	public Object[] generateOptionsByRequest(Request req);
	
	public int findAgentForNewRequest(); //random in v1

	public Plan findByRequestIdAndAgencyId(Integer rid, Integer aid);
}
