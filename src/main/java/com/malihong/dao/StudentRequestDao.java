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
	
	public Request findValidRequestByUserId(int uid); //isConcel=1
	
	public List<Request> findCancelledRequestByUserId(int uid);
	
	public List<Request> findFinishedRequestsByUserId(int uid);
	
	public List<Request> findRequestsByUserId(int uid);
	
	public int countResponsedConcelledApplyByUserId(int uid); //isConcel=3
	
	public boolean setIsConcelStatusById(int id, int status);
	
	public Request findRequestingApplyByUserId(int uid);
}
