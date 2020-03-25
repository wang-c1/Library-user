package com.javaeetest.service;

import com.javaeetest.entity.Address;
import com.javaeetest.entity.UserAddress;

public interface UserAddressService {
	boolean savaUserAddress(UserAddress userAddress);

	Address findAddressByUserId(int userId, int k);

	int returnnumber(int userId);
}
