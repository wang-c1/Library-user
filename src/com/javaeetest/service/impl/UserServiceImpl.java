package com.javaeetest.service.impl;

import com.javaeetest.dao.UserDao;
import com.javaeetest.entity.User;
import com.javaeetest.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * 用于用户登录
	 */
	public User loginValid(String userName, String password) {
		try {
			User u = userDao.findUserByNameAndPassword(userName, password);
			System.out.println(u);
			if (u != null) {
				return u;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 添加新用户
	 */
	public boolean saveUser(User user) {
		if (userDao.saveUser(user) == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 更改密码
	 * 
	 */
	@Override
	public boolean changePassword(User user) {
		// TODO Auto-generated method stub
		if (userDao.changePassword(user) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
