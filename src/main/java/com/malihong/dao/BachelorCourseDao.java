package com.malihong.dao;
import java.util.List;
import com.malihong.entity.BachelorCourse;

public interface BachelorCourseDao {
	public BachelorCourse findCourseById(int cid);
	public List<BachelorCourse> findCoursesByField(String f1, String f2);
}
