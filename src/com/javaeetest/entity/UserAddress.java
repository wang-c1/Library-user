package com.javaeetest.entity;

public class UserAddress {
	private Integer id;
	private User user;
	private Address address;
  
	public UserAddress()
	{
		
	}
	public UserAddress(User user, Address address) {
		this.user = user;
		this.address = address;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	

}
