package com.pigai.dao;

import java.util.List;

import com.pigai.entity.Courseware;

public interface CoursewareDao extends BaseDao {

	int getCoursewareCountByCourseId(Integer courseId) throws Exception;

	List<Courseware> getCoursewaresByCourseId(Integer courseId, int offset, int pageSize)
			throws Exception;

}
