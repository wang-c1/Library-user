package com.javaeetest.service;

import com.javaeetest.entity.User;

public interface UserService {

	User loginValid(String userName, String password);

	boolean saveUser(User user);

	boolean changePassword(User user);
}
