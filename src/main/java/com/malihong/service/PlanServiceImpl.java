package com.malihong.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.OptionDao;
import com.malihong.dao.PlanDao;
import com.malihong.entity.Option;
import com.malihong.entity.Plan;
import com.malihong.entity.Request;

@Service
@Qualifier("planService")
public class PlanServiceImpl implements PlanService{

	private static final Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);
	@Autowired
	private PlanDao planDao;
	@Autowired
	private OptionDao optionDao;
	
	@Override
	public void add(Plan p) {
		logger.info("service save");
		planDao.add(p);
	}

	@Override
	public void update(Plan p) {
		planDao.update(p);
	}

	@Override
	public List<Plan> findPlansByRequestId(int rid) {
		List<Plan> list=planDao.findPlansByRequestId(rid);

		return list;
	}

	@Override
	public List<Plan> findPlansByAgencyId(int aid) {
		return planDao.findPlansByAgencyId(aid);
	}

	@Override
	public Plan findPlanById(int pid) {
		return this.planDao.findPlanById(pid);
	}

	@Override
	public List<Option> generateOptionsByRequest(Request req) {
		return null;
	}

	@Override
	public List<Plan> findUnprocessedPlanListByPage(int agentId, int pageNum, int listNum) {
		return planDao.findUnprocessedPlanListByPage(agentId, pageNum, listNum);
	}

	@Override
	public int countUnprocessedPlan(int agentId) {
		return planDao.countUnprocessedPlan(agentId);
	}

	@Override
	public List<Plan> findProcessedPlanListByPage(int agentId, int pageNum, int listNum) {
		return planDao.findProcessedPlanListByPage(agentId, pageNum, listNum);
	}

	@Override
	public int countProcessedPlan(int agentId) {
		return planDao.countProcessedPlan(agentId);
	}

	@Override
	public List<Plan> findUnprocessedPlanListByAgentId(int agentId) {
		return planDao.findUnprocessedPlanListByAgentId(agentId);
	}

	@Override
	public List<Plan> findProcessedPlanListByAgentId(int agentId) {
		return planDao.findProcessedPlanListByAgentId(agentId);
	}

}
