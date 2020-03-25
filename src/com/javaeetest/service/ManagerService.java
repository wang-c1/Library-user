package com.javaeetest.service;

import com.javaeetest.entity.Manager;

public interface ManagerService {
	
	/**
	 * 验证manager登陆
	 * @param manager
	 * @return
	 */
	int loginValid(Manager manager);
	
}
