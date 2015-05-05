package com.pigai.dao;

import java.util.List;

import com.pigai.entity.Course;

public interface CourseDao extends BaseDao<Course>{

	public Long getTotalNumByKey(String key);
	public List<Course> findByKeyByPage(String key,Integer pageNum);
	

}
