package com.pigai.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.pigai.dao.StudentDao;
import com.pigai.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

	@Override
	public Student findStudentById(final String studentNo) {
		return getHibernateTemplate().execute(new HibernateCallback<Student>()
				{
					@Override
					public Student doInHibernate(Session session)throws HibernateException
					{
						String hql="from Student where studentNo=:studentNo ";
						Query query=session.createQuery(hql);
						query.setString("studentNo",studentNo);
						Student student=(Student) query.uniqueResult();
						return student;
					}
					
				});
	}

	@Override
	public Student findStudent(final String studentNo, final String password) {
		return getHibernateTemplate().execute(new HibernateCallback<Student>()
				{
					@Override
					public Student doInHibernate(Session session)throws HibernateException
					{
						String hql="from Student where studentNo=:studentNo and password=:password";
						Query query=session.createQuery(hql);
						query.setString("studentNo",studentNo);
						query.setString("password",password);
						Student student=(Student) query.uniqueResult();
						return student;
					}
					
				});
	}

}
