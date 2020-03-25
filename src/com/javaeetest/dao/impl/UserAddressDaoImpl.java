package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.UserAddressDao;
import com.javaeetest.entity.UserAddress;

public class UserAddressDaoImpl extends BaseDaoImpl<UserAddress> implements
		UserAddressDao {

	@Override
	public int savaUserAddress(UserAddress userAddress) {
		// TODO Auto-generated method stub

		return save(userAddress);
	}

	@Override
	public UserAddress findAddressByUserId(int userId, int k) {

		String hql = "select * from tb_userAddress as address where address.userId=?0";
		// System.out.println(hql);
		List<UserAddress> userAddress = find(hql, userId);

		if (userAddress != null && userAddress.size() > 0) {
			return userAddress.get(k);

		}

		return null;
	}

	@Override
	public int returnnumber(int userId) {

		String hql = "select * from tb_userAddress as address where address.userId=?0";
		// System.out.println(hql);
		List<UserAddress> userAddress = find(hql, userId);

		if (userAddress != null && userAddress.size() > 0) {
			return userAddress.size();
		}

		return 0;
	}

}
