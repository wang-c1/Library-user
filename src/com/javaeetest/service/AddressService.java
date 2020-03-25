package com.javaeetest.service;

import com.javaeetest.entity.Address;

public interface AddressService {
	boolean saveAddress(Address address);

	Address findById(int id);

	Address findAdderssById(String id);

}
