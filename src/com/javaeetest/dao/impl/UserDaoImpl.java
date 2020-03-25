package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.UserDao;
import com.javaeetest.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/**
	 * 登录校验用户名密码是否匹配
	 */
	@Override
	public User findUserByNameAndPassword(String userName, String password) {
		System.out.println(userName);
		System.out.println(password);
		List<User> list = find("select * from tb_user u where "
				+ "u.userName=?0 and u.userPassword=?1", userName, password);
		System.out.println(list);
		if (list != null && list.size() > 0) {
			return list.get(0);// 返回用户名密码
		}
		return null;
	}

	/**
	 * 添加新用户
	 */
	public int saveUser(User user) {
		return save(user);

	}

	/**
	 * 更改密码
	 * 
	 */
	@Override
	public int changePassword(User user) {
		// TODO Auto-generated method stub
		return update(user);
	}

}
