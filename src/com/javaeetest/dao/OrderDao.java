package com.javaeetest.dao;

import java.util.List;

import com.javaeetest.entity.Order;

public interface OrderDao {
	List<Order> findAllOrders(int id);

	List<Order> allOrdersByUserDeal(int id);

	List<Order> allOrdersByUserNotDeal(int id);

	Order findOrders(int id);

	int deleteOrders(int ordersId);
}
