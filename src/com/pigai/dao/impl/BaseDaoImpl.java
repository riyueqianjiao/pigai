package com.pigai.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.pigai.dao.BaseDao;


@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>
{
    @Override
	public Serializable save(T entity)
	{
		return getHibernateTemplate().save(entity);
	}
    
    @Override
	public void delete(T entity)
	{
	    getHibernateTemplate().delete(entity);  
	}
    
    @Override
	public void delete(Class<T> clazz, Serializable id)
	{
		delete(get(clazz, id));
	}

    @Override
	public void update(T entity)
	{
		getHibernateTemplate().update(entity);		
	}
    
    @Override
	public T get(Class<T> clazz, Serializable id)
	{
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findAll(Class<T> clazz)
	{
		return (List<T>) getHibernateTemplate().find("from "+clazz.getSimpleName());
	}
	
    @Override
	public List<T> findAll(Class<T> clazz, String condition,Object...objects)
	{
    	String sql="from "+clazz.getSimpleName()+" "+condition;
		return (List<T>) getHibernateTemplate().find(sql,objects);
	}

    @Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
	   super.setSessionFactory(sessionFactory);	
	}
    
    
    
    
}
