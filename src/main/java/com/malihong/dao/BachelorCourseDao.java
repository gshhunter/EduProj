package com.malihong.dao;
import java.util.HashMap;
import java.util.List;
import com.malihong.entity.BachelorCourse;

public interface BachelorCourseDao {
	public BachelorCourse findCourseById(int cid);
	public Object[] findCoursesByDiplomaIdAndField(int did, String field);
}
