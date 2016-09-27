package com.malihong.dao;

import java.util.List;

import com.malihong.entity.Agency;

public interface AgencyDao {
	public List<Agency> getAgencyList(int count);
}
