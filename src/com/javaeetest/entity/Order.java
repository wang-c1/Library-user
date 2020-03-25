package com.javaeetest.entity;

import java.sql.Timestamp;

public class Order {

	private int orderId;
	private String orderNumber;
	private User user;
	private Timestamp orderTime;
	private int orderStatus;
	private float totalMoney;
	private String addressId;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Order() {

	}

	public Order(int orderId, String orderNumber, User user,
			Timestamp orderTime, int orderStatus, float totalMoney) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.user = user;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.totalMoney = totalMoney;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

}
