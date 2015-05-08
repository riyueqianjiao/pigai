package com.pigai.service;


import java.io.Serializable;

/**
 * Service的基类，所有Service必须继承
 * @author lzh
 *
 * @param <T>
 */
public interface BaseService<T extends Serializable> {
	
	/**
	 * 保存实体
	 * 
	 * @param entity
	 *            需要保存的实体
	 */
	public T add(T obj) throws Exception;

	/**
	 * 更新实体
	 * 
	 * @param entity
	 *            需要保存的实体
	 */
	public void update(T obj) throws Exception;

	/**
	 * 删除实体
	 * @param pk
	 *            需要删除的实体主键
	 */
	public void delete(Serializable objkey) throws Exception;

	/**
	 * 查找实体
	 * 
	 * @param <T>
	 *            动态传入实体类
	 * @param entityClass
	 *            实体类
	 * @param pk
	 *            主键
	 * @return 根据指定主键返回的实体
	 */
	public T get(Serializable primaryKey) throws Exception;
	
	/**
	 * 根据主键批量删除实体
	 * @param keys
	 * @throws Exception
	 */
	public void batchDelete(Serializable[] keys) throws Exception;
	
}
