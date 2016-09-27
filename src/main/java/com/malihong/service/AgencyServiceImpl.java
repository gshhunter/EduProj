package com.malihong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.malihong.dao.AgencyDao;
import com.malihong.entity.Agency;

@Service
@Qualifier("agencyService")
public class AgencyServiceImpl implements AgencyService{

	@Autowired
	private AgencyDao aDao;
	
	@Override
	public List<Agency> getAgencyList(int count) {
		return this.aDao.getAgencyList(count);
	}

}
