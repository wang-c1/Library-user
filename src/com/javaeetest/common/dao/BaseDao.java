package com.javaeetest.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	//根据ID加载实体
	T get(Class<T> entityClass,Serializable id);
	
	//保存实体
	int save(T entity);
	
	//更新实体
	int update(T entity);
	
	//删除实体
	int delete(Class<T> entityClass);
	
	//获取所有实体
	List<T> findAll(Class<T> entityClass);
}
