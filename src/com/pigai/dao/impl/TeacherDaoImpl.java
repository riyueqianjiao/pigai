package com.pigai.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.pigai.dao.TeacherDao;
import com.pigai.entity.Teacher;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDaoImpl implements TeacherDao {

	protected static final Class<Teacher> entityClass = Teacher.class;
	
	@Override
	public Teacher getTeacherByUserNameAndPwd(String username, String pwd) {
		
		return getHibernateTemplate().execute(new HibernateCallback<Teacher>()
				{
					@Override
					public Teacher doInHibernate(Session session)throws HibernateException
					{
						String hql="from Teacher where teacherNo=:teacherNo and password=:password";
						Query query=session.createQuery(hql);
						query.setString("teacherNo",username);
						query.setString("password",pwd);
						Teacher teacher=(Teacher) query.uniqueResult();
						return teacher;
					}
					
				});
	}

	@Override
	public Teacher isTeacherExisted(String teacherNo) throws Exception {
		return getHibernateTemplate().execute(new HibernateCallback<Teacher>()
				{
					@Override
					public Teacher doInHibernate(Session session)throws HibernateException
					{
						String hql="from Teacher where teacherNo=:teacherNo";
						Query query=session.createQuery(hql);
						query.setString("teacherNo",teacherNo);						
						Teacher teacher=(Teacher) query.uniqueResult();
						return teacher;
					}
					
				});
	}

}
