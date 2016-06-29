/**
 * 
 */
package com.malihong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.StudentRequestDao;
import com.malihong.entity.Request;

/**
 * @author GSH1
 *
 */

@Service
@Qualifier("requestService")
public class StudentRequestServiceImpl implements StudentRequestService{

	@Autowired
	private StudentRequestDao requestDao;
	
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

}
