/**
 * 
 */
package com.malihong.dao;

import java.util.List;

import com.malihong.entity.Request;

/**
 * @author GSH1
 * Student Request maintain all requests from student
 */
public interface StudentRequestDao {

	public void add(Request r);
	
	public void delete(Request r);
	
	public void update(Request r);
	
	public Request findValidRequestByUserId(int uid); //isCancel=0 or 1
	
	public List<Request> findCancelledRequestByUserId(int uid); //isCancel=3 or 4
	
	public List<Request> findFinishedRequestsByUserId(int uid); //isCancel=2
	
	public List<Request> findRequestsByUserId(int uid);
	
	public int countResponsedConcelledApplyByUserId(int uid); //isCancel=4, every unpaid student can have no more than 1
	
	public List<Request> findActiveRequests(); //in last two days, isCancel=0 or 1
}
