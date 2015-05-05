package com.pigai.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.pigai.constant.Constants;
import com.pigai.dao.CourseDao;
import com.pigai.entity.Course;

@Repository("courseDao")
public class CourseDaoImpl  extends BaseDaoImpl<Course> implements CourseDao{

	@Override
	public Long getTotalNumByKey(final String key)
	{
		return getHibernateTemplate().execute
				(
				   new HibernateCallback<Long>()
				   {
					  @Override
					  public Long doInHibernate(Session session) throws HibernateException
					  {
						  if(key == null){
							  String hql="select count(distinct c) from Course c";
							  Query query=session.createQuery(hql);
							  query.setCacheable(true);
							  return (Long) query.uniqueResult();
						  }else{
							  String hql="select count(distinct c) from Course c,Teacher t where c.teacher = t.teacherId and (c.courseName like :courseName or t.name like :name)";
							  Query query=session.createQuery(hql);
							  query.setString("courseName", "%"+key+"%");
							  query.setString("name","%"+key+"%");
							  query.setCacheable(true);
							  return (Long) query.uniqueResult();
						  }					  
						  
					  }
				   }
			    );
	}
	@SuppressWarnings("unchecked")
	public List<Course> findByKeyByPage(final String key,final Integer pageNum)
	{
		System.out.println("Dao层key="+key);
		return getHibernateTemplate().execute
				(
				   new HibernateCallback<List<Course>>()
				   {
					  @Override
					  public List<Course> doInHibernate(Session session) throws HibernateException
					  {
						  if(key == null){
							  String hql="select c from Course c order by time";
							  Query query = session.createQuery(hql);
							  query.setCacheable(true);
						      query.setFirstResult((pageNum-1)*Constants.PAGE_Size);
						      query.setMaxResults(Constants.PAGE_Size);
						      return (List<Course>)query.list();
						  }else{
							  String hql="select distinct c from Course c,Teacher t where c.teacher = t.teacherId and (c.courseName like :courseName or t.name like :name)";
							  Query query = session.createQuery(hql);
							  query.setString("courseName", "%"+key+"%");
							  query.setString("name","%"+key+"%");
							  query.setCacheable(true);
						      query.setFirstResult((pageNum-1)*Constants.PAGE_Size);
						      query.setMaxResults(Constants.PAGE_Size);
						      return (List<Course>)query.list();
						  }
						  
					  }
				   }
			    );
	}


}
