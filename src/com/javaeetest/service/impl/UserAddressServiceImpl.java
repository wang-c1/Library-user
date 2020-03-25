package com.javaeetest.service.impl;

import com.javaeetest.dao.UserAddressDao;
import com.javaeetest.entity.Address;
import com.javaeetest.entity.UserAddress;
import com.javaeetest.service.UserAddressService;

public class UserAddressServiceImpl implements UserAddressService {
	private UserAddressDao userAddressDao;

	@Override
	public boolean savaUserAddress(UserAddress userAddress) {
		// TODO Auto-generated method stub
		if (userAddressDao.savaUserAddress(userAddress) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void setUserAddressDao(UserAddressDao userAddressDao) {
		this.userAddressDao = userAddressDao;
	}

	public UserAddressDao getUserAddressDao() {
		return userAddressDao;
	}

	@Override
	public Address findAddressByUserId(int userId, int k) {
		// TODO Auto-generated method stub
		UserAddress userAddress = userAddressDao.findAddressByUserId(userId, k);
		Address address = userAddress.getAddress();
		return address;
	}

	@Override
	public int returnnumber(int userId) {
		// TODO Auto-generated method stub
		int number = userAddressDao.returnnumber(userId);
		return number;
	}
}
