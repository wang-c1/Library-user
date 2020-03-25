package com.javaeetest.service.impl;

import com.javaeetest.dao.ManagerDao;
import com.javaeetest.entity.Manager;
import com.javaeetest.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	private ManagerDao managerDao;
	
	public void setManagerDao(ManagerDao managerDao){
		this.managerDao = managerDao;
	}
	
	public ManagerDao getManagerDao(){
		return managerDao;
	}

	@Override
	public int loginValid(Manager manager) {
		try{
			Manager m = managerDao.findManagerByNameAndPass(
					manager.getManagerName(), manager.getManagerPassword());
			if(m != null){
				return m.getManagerId();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}

}
