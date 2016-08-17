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
	public List<sysOption> generateOptionsByRequest(Request req) {
		int percentage=GaokaoInfo.percentageMark(req.getGaokaoLocation(), req.getGaokaoResult());
		List<sysOption> sysOptions=new ArrayList<sysOption>();
		if(percentage<50){
			
		}else if(percentage<=85){
			List<DiplomaCourse> dcs=this.dcDao.findCoursesByField(req.getInterestMajor1());
			for(DiplomaCourse dc :dcs){
				sysOption o=new sysOption();
				o.setDiplomaInfo(dc);
				Object[] objs=this.bcDao.findCoursesByDiplomaIdAndField(dc.getCourseId(), req.getInterestMajor1());
				o.bechelors=(HashMap<Integer, String>) objs[0];
				o.universityId=(int) objs[1];
				o.universityName=(String) objs[2];
				sysOptions.add(o);
			}
		}else{
			
		}
		
		return sysOptions;
	}

}
