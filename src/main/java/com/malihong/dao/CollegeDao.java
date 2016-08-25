package com.malihong.dao;

import java.util.HashMap;
import java.util.List;

import com.malihong.entity.College;

public interface CollegeDao {
	public List<College> findCollegesByType(int type);
}
