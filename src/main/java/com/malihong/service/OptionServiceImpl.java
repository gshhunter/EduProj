package com.malihong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.OptionDao;
import com.malihong.entity.Option;

@Service
@Qualifier("optionService")
public class OptionServiceImpl implements OptionService{

	@Autowired
	private OptionDao optionDao;
	
	@Override
	public void add(Option o) {
		this.optionDao.add(o);
	}

}
