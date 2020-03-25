package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.ManagerDao;
import com.javaeetest.entity.Manager;

public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {


	@Override
	public Manager findManagerByNameAndPass(String name, String pass) {
		List ul = find("select * from tb_manager m where "
				+ "m.managerName=?0 and m.managerPassword=?1",name,pass);
		if(ul != null && ul.size() > 0){
			return (Manager)ul.get(0);
		}
		return null;
	}

}
