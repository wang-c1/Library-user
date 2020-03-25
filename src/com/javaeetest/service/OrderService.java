package com.javaeetest.service;

import java.util.List;

import com.javaeetest.entity.Order;
import com.javaeetest.entity.OrdersBook;

public interface OrderService {
	List<Order> allOrdersByUser(int id);

	List<Order> allOrdersByUserDeal(int id);

	List<Order> allOrdersByUserNotDeal(int id);

	Order findOrders(int id);

	List<OrdersBook> allOrdersbookByOrders(int id);

	int addOrders(Order order);

	void addOrdersbook(OrdersBook ordersbook);

	void deleteOrders(Class<Order> parseInt);

	void DeleteOrder(int id);

}
