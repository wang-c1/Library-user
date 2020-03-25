package com.javaeetest.dao;

import com.javaeetest.common.dao.BaseDao;
import com.javaeetest.entity.Address;

public interface AddressDao extends BaseDao<Address> {
	int saveAddress(Address address);

	Address findById(int id);

	Address findAdderssById(String id);

}
