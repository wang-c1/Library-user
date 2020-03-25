package com.javaeetest.dao;

import com.javaeetest.common.dao.BaseDao;
import com.javaeetest.entity.User;

public interface UserDao extends BaseDao<User> {

	User findUserByNameAndPassword(String name, String password);

	int saveUser(User user);

	int changePassword(User user);
}
