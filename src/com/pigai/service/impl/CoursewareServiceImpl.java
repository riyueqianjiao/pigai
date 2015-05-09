package com.pigai.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pigai.dao.CommonDao;
import com.pigai.dao.CoursewareDao;
import com.pigai.entity.Courseware;
import com.pigai.service.CoursewareService;
import com.pigai.util.PageModel;

@Service("coursewareService")
public class CoursewareServiceImpl extends BaseServiceImpl<Courseware>
		implements CoursewareService {

	protected static final Class<Courseware> entityClass = Courseware.class;

	@Autowired
	private CommonDao commonDao;

	@Autowired
	private CoursewareDao coursewareDao;

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Serializable objkey) throws Exception {

		commonDao.delete(entityClass, objkey);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Courseware get(Serializable primaryKey) throws Exception {

		return (Courseware) commonDao.get(entityClass, primaryKey);
	}

	@Override
	public PageModel getPageModelByCourseId(PageModel pageModel,
			Integer courseId) {
		try {
			pageModel.setPageData(coursewareDao.getCoursewaresByCourseId(
					courseId, pageModel.getOffset(), pageModel.getPageSize()));
			pageModel.setTotalRecord(coursewareDao
					.getCoursewareCountByCourseId(courseId));
		} catch (Exception e) {
			e.printStackTrace();
			pageModel.setPageData(java.util.Collections.EMPTY_LIST);
			pageModel.setTotalRecord(0);
		}
		return pageModel;
	}

}
