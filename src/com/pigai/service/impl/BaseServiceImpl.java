package com.pigai.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.pigai.dao.CommonDao;
import com.pigai.service.BaseService;

@SuppressWarnings("unchecked")
public abstract class BaseServiceImpl<T extends Serializable> implements
		BaseService<T> {

	@Autowired
	private CommonDao commonDao;

	
	@Override
	public T add(T obj) throws Exception {
		return (T) commonDao.save(obj);
	}

	@Override
	public void update(T obj) throws Exception {
		commonDao.update(obj);
	}

	@Override
	public void batchDelete(Serializable[] keys) throws Exception {
		if (null != keys && keys.length > 0) {
			for (Serializable key : keys) {
				if (null != key) {
					delete(key);
				}
			}
		}
	}


}