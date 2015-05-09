package com.pigai.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.pigai.constant.Constants;
import com.pigai.dao.CoursewareDao;
import com.pigai.entity.Course;
import com.pigai.entity.Courseware;
import com.pigai.vo.CourseCriteria;

@Repository("coursewareDao")
public class CoursewareDaoImpl extends BaseDaoImpl implements CoursewareDao {
	protected static final Class<Courseware> entityClass = Courseware.class;

}
