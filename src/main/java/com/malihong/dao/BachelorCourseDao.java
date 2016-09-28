package com.malihong.dao;
import java.util.List;
import com.malihong.entity.BachelorCourse;

public interface BachelorCourseDao {
	public BachelorCourse findCourseById(int cid);
	public Object[] findCoursesByDiplomaIdAndField(int did, String field);
	public List<BachelorCourse> findCourseByUniversityId(int uid);
	public List<BachelorCourse> findCoursesByField(String field);
}
