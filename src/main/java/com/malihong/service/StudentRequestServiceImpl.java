/**
 * 
 */
package com.malihong.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.agency.StudentRequestController;
import com.malihong.dao.PlanDao;
import com.malihong.dao.StudentRequestDao;
import com.malihong.entity.Request;

/**
 * @author GSH1
 *
 */

@Service
@Qualifier("requestService")
public class StudentRequestServiceImpl implements StudentRequestService{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentRequestServiceImpl.class);

	@Autowired
	private StudentRequestDao requestDao;
	
	@Autowired
	private PlanDao planDao;
	
	@Override
	public void save(Request r) {
		requestDao.add(r);
	}

	@Override
	public void update(Request r) {
		requestDao.update(r);
	}

	@Override
	public void setRequestToCancelled(Request r) {
		r.setIsCancel(0);
		requestDao.update(r);
	}

	@Override
	public Request findValidRequestByUserId(int uid) {
		return requestDao.findValidRequestByUserId(uid);
	}

	@Override
	public List<Request> findUnresponsedActiveRequestsByAgentID(int aid) {
		List<Request> list = this.requestDao.findActiveRequests();
		if(list.isEmpty()){
			logger.info("server start empty");
		}else{
			logger.info("server start");
		}
		for(Request r : list){
			if(this.planDao.findByRequestIdAndAgencyId(r.getIdRequest(), aid)!=null){
				list.remove(r);
			}
		}
		if(list.isEmpty()){
			logger.info("server end empty");
		}else{
			logger.info("server end");
		}
		return list;
	}

	@Override
	public Request findRequestById(int rid) {
		return this.requestDao.findRequestById(rid);
	}

}
