package com.pigai.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T>
{
   public Serializable save(T entity);
   void delete(T entity);
   void delete(Class<T> clazz,Serializable id);
   void update(T entity);
   T get(Class<T> clazz,Serializable id);
   List<T> findAll(Class<T> clazz);
   public List<T> findAll(Class<T> clazz, String condition,Object... objects);
}
