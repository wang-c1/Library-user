package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.AddressDao;
import com.javaeetest.entity.Address;

public class AddressDaoImpl extends BaseDaoImpl<Address> implements AddressDao {

	@Override
	public int saveAddress(Address address) {
		// TODO Auto-generated method stub
		return save(address);
	}

	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		String hql = "select * from tb_address as address where address.addressId=?0";
		List<Address> address = find(hql, id);
		System.out.println("shanbaobao");
		if (address != null && address.size() > 0) {
			System.out.println("baobao");
			return address.get(0);

		}

		return null;
	}

	@Override
	public Address findAdderssById(String id) {
		// TODO Auto-generated method stub
		String hql = "select * from tb_address as address where address.addressId=?0";
		List<Address> address = find(hql, id);
		System.out.println("shanbaobao");
		if (address != null && address.size() > 0) {
			System.out.println("baobao");
			return address.get(0);

		}
		return null;
	}

}
