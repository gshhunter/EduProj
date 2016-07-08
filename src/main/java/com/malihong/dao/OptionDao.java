package com.malihong.dao;

import java.util.List;

import com.malihong.entity.Option;

public interface OptionDao {

	public void add(Option o);
	
	public void delete(Option o);
	
	public void update(Option o);
	
	public List<Option> findOptionsByPlanId(int pid);
}
