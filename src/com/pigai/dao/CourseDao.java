package com.pigai.dao;

import java.util.List;

import com.pigai.entity.Course;
import com.pigai.vo.CourseCriteria;

public interface CourseDao extends BaseDao{

	public Long getTotalNumByKey(String key);
	public List<Course> findByKeyByPage(String key,Integer pageNum);
	public List<Course> getCoursesByCriteria(CourseCriteria criteria, int offset,
			int pageSize)throws Exception;
	public int getCourseCountByCriteria(CourseCriteria criteria) throws Exception;
	

}
