package com.javaeetest.service.impl;

import com.javaeetest.dao.AddressDao;
import com.javaeetest.entity.Address;
import com.javaeetest.service.AddressService;

public class AddressServiceImpl implements AddressService {
	private AddressDao addressDao;

	/**
	 * 新增收货地址
	 */
	@Override
	public boolean saveAddress(Address address) {
		// TODO Auto-generated method stub
		if (addressDao.saveAddress(address) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	public AddressDao getAddressDao() {
		return addressDao;
	}

	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		return addressDao.findById(id);

	}

	@Override
	public Address findAdderssById(String id) {
		// TODO Auto-generated method stub
		return addressDao.findAdderssById(id);
	}

}
