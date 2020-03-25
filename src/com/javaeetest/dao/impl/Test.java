package com.javaeetest.dao.impl;

import com.javaeetest.service.impl.UserServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		UserDaoImpl u=new UserDaoImpl();
		System.out.println(u.findUserByNameAndPassword("zhaicheng","123").getUserEmail());
	}	
	
}