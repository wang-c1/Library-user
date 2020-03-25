package com.javaeetest.dao;

import java.util.List;

import com.javaeetest.entity.OrdersBook;

public interface OrdersBookDao {
	 List<OrdersBook> allOrdersbookByOrders(int id);
	 void addOrdersbook(OrdersBook ordersbook);
}
