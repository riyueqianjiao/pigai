package com.pigai.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

public interface BaseDao<T>
{
   public T save(T entity);
   void delete(T entity);
   void delete(Class<T> clazz,Serializable id);
   void update(T entity);
   T get(Class<T> clazz,Serializable id);
   List<T> findAll(Class<T> clazz);
   public List<T> findAll(Class<T> clazz, String condition,Object... objects);
   
	/**
	 * 执行查询的方法
	 * 
	 * @param entityClass
	 *            实体类
	 * @param whereJpql
	 *            指定查询返回的第一条记录
	 * @param orderBy
	 *            用于排序，如果无需排序该参数设为null.Map对象的key为实体字段名
	 *            ，value为ASC/DESC，如：LinkedHashMap<String, String> orderBy = new
	 *            LinkedHashMap<String, String>(); orderBy.put("itemName",
	 *            "DESC");表明根据itemName降序排列；
	 *            如果放入多个key-value对，则第一次放入的key-value对为首要关键字，
	 *            第二次放入的key-value对为次要排序关键字……
	 * @param args
	 *            作为为JPQL查询字符串的参数的值
	 * @return 返回查询得到的实体List
	 */
	<T> List<T> getResultList(Class<T> entityClass, String whereJpql,
			LinkedHashMap<String, String> orderBy, Object... args) throws Exception;
	
	
	/**
	 * 执行查询、并进行分页的方法
	 * 
	 * @param entityClass
	 *            实体类
	 * @param whereJpql
	 *            指定查询返回的第一条记录
	 * @param firstResult
	 *            指定查询返回的第一条记录
	 * @param maxResult
	 *            设置查询最多返回多少几条记录
	 * @param orderBy
	 *            用于排序，如果无需排序该参数设为null.Map对象的key为实体字段名
	 *            ，value为ASC/DESC，如：
	 *            LinkedHashMap<String, String> orderBy = new LinkedHashMap<String, String>(); 
	 *            orderBy.put("itemName", "DESC");
	 *            表明根据itemName降序排列；
	 *            如果放入多个key-value对，则第一次放入的key-value对为首要关键字，
	 *            第二次放入的key-value对为次要排序关键字……
	 * @param args
	 *            作为为JPQL查询字符串的参数的值
	 * @return 返回查询得到的实体List
	 */
	<T> List<T> getResultList(Class<T> entityClass, String whereJpql,
			int firstResult, int maxResult,
			LinkedHashMap<String, String> orderBy, Object... args) throws Exception;
	
	

	public <T> int getResultCount(Class<T> entityClass, String whereJpql,
			Object... args);
	
	public <T> int getResultCountDistinct(Class<T> entityClass, String distinct, String whereJpql,
			Object... args);
}
