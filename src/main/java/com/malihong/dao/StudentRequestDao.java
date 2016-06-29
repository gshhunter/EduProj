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
	
	public List<Request> findRequestsByUserId(int uid);
}
