package com.javaeetest.dao;

import com.javaeetest.common.dao.BaseDao;
import com.javaeetest.entity.Manager;

public interface ManagerDao extends BaseDao<Manager> {
	
	/**
	 * 更具用户名，密码查找管理员
	 * @param name
	 * @param pass
	 * @return
	 */
	Manager findManagerByNameAndPass(String name,String pass);
	
}
