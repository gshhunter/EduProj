package com.malihong.service;

import com.malihong.entity.Request;

public interface StudentRequestService {

	public void save(Request r);
	
	public void update(Request r);
	
	/**
	 * 取消用户当前的request
	 * 设置isCancel为0
	 * @param r
	 */
	public void setRequestToCancelled(Request r);
	
	/**
	 * 找到用户有效的request
	 * @param uid
	 * @return
	 */
	public Request findValidRequestByUserId(int uid);
}
