package com.malihong.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.bean.GaokaoInfo;
import com.malihong.bean.sysOption;
import com.malihong.dao.AccountDao;
import com.malihong.dao.BachelorCourseDao;
import com.malihong.dao.DiplomaCourseDao;
import com.malihong.dao.FoundationCourseDao;
import com.malihong.dao.OptionDao;
import com.malihong.dao.PlanDao;
import com.malihong.entity.DiplomaCourse;
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
	@Autowired
	private BachelorCourseDao bcDao;
	@Autowired
	private DiplomaCourseDao dcDao;
	@Autowired
	private FoundationCourseDao fcDao;
	@Autowired
	private AccountDao accDao;
	
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
	public Object[] generateOptionsByRequest(Request req) {
		int percentage=GaokaoInfo.percentageMark(req.getGaokaoLocation(), req.getGaokaoResult());
		List<sysOption> sysOptions=new ArrayList<sysOption>();
		Object[] result=new Object[3];
		if(percentage<50){
			result[0]=3; //成绩低于百分之50，联系中介
			result[1]="成绩低于百分之50，联系中介";
		}else if(percentage<=85){
			List<DiplomaCourse> dcs=this.dcDao.findCoursesByField(req.getInterestMajor1());
			if(dcs!=null){
				for(DiplomaCourse dc :dcs){
					Object[] objs=this.bcDao.findCoursesByDiplomaIdAndField(dc.getCourseId(), req.getInterestMajor1());
					if(objs!=null){
						sysOption o=new sysOption();
						o.setDiplomaInfo(dc);
						o.bachelors=(HashMap<Integer, String>) objs[0];
						o.universityId=(int) objs[1];
						o.universityName=(String) objs[2];
						sysOptions.add(o);
					}
				}
			}
			if(sysOptions.isEmpty()){
				result[0]=2; //成绩在百分之50与百分之85之间，但是没有找到合适的留学建议
				result[1]="成绩在百分之50与百分之85之间，但是没有找到合适的留学建议";
			}else{
				result[0]=1; //成绩在百分之50与百分之85之间
				result[1]="成绩在百分之50与百分之85之间";
				result[2]=sysOptions;
			}
		}else{
			result[0]=4; //成绩高于百分之85，联系中介
			result[1]="成绩高于百分之85，联系中介";
		}
		
		return result;
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

	@Override
	public int findAgentForNewRequest() {
		return this.accDao.findAgentIdByRandom();
	}

	@Override
	public Plan findByRequestIdAndAgencyId(Integer rid, Integer aid){
		return this.planDao.findByRequestIdAndAgencyId(rid, aid);
	}
}
