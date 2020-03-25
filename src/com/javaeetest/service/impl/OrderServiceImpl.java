package com.javaeetest.service.impl;

import java.util.List;

import com.javaeetest.dao.impl.OrderDaoImpl;
import com.javaeetest.dao.impl.OrdersBookDaoImpl;
import com.javaeetest.entity.Order;
import com.javaeetest.entity.OrdersBook;
import com.javaeetest.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDaoImpl orderDao;
	private OrdersBookDaoImpl ordersBookDao;

	public OrderDaoImpl getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDaoImpl orderDao) {
		this.orderDao = orderDao;
	}

	public OrdersBookDaoImpl getOrdersBookDao() {
		return ordersBookDao;
	}

	public void setOrdersBookDao(OrdersBookDaoImpl ordersBookDao) {
		this.ordersBookDao = ordersBookDao;
	}

	public List<Order> allOrdersByUser(int id) {

		return orderDao.findAllOrders(id);
	}

	@Override
	public List<Order> allOrdersByUserDeal(int id) {
		// TODO Auto-generated method stub
		return orderDao.allOrdersByUserDeal(id);
	}

	@Override
	public List<Order> allOrdersByUserNotDeal(int id) {

		return orderDao.allOrdersByUserNotDeal(id);
	}

	public Order findOrders(int id) {
		return orderDao.findOrders(id);

	}

	public List<OrdersBook> allOrdersbookByOrders(int id) {
		return ordersBookDao.allOrdersbookByOrders(id);
	}

	@Override
	public int addOrders(Order order) {
		return orderDao.addOrders(order);

	}

	@Override
	public void addOrdersbook(OrdersBook ordersbook) {
		ordersBookDao.addOrdersbook(ordersbook);

	}

	@Override
	public void deleteOrders(Class<Order> parseInt) {
		orderDao.delete(parseInt);

	}

	@Override
	public void DeleteOrder(int id) {
		// TODO Auto-generated method stub
		orderDao.deleteOrders(id);
	}

}
