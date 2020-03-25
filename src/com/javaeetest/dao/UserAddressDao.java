package com.javaeetest.dao;

import com.javaeetest.common.dao.BaseDao;
import com.javaeetest.entity.UserAddress;

public interface UserAddressDao extends BaseDao<UserAddress> {
	int savaUserAddress(UserAddress userAddress);

	UserAddress findAddressByUserId(int userId, int k);

	int returnnumber(int userId);

}
