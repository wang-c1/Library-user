package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.OrderDao;
import com.javaeetest.entity.Order;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	public List<Order> findAllOrders(int id) {

		String hql = "select * from tb_orders as orders where orders.userId=?0";

		List<Order> order = find(hql, id);
		if (order != null && order.size() > 0) {
			return order;

		}

		return null;
	}

	@Override
	public List<Order> allOrdersByUserDeal(int id) {
		String hql = "select * from tb_orders as orders where orders.userId=?0 and orders.orderStatus=1";
		List<Order> order = find(hql, id);
		if (order != null && order.size() > 0) {
			return order;

		}

		return null;
	}

	public List<Order> allOrdersByUserNotDeal(int id) {
		String hql = "select * from tb_orders as orders where orders.userId=?0 and orders.orderStatus=0";
		List<Order> order = find(hql, id);
		if (order != null && order.size() > 0) {
			return order;

		}

		return null;

	}

	public Order findOrders(int id) {
		String hql = "select * from tb_orders as orders where orders.orderId=?0";
		List<Order> order = find(hql, id);
		if (order != null && order.size() > 0) {
			return order.get(0);

		}

		return null;

	}

	public int addOrders(Order order) {

		save(order);
		int i = 0;
		String hql = "select max(orderId) from Order";
		List<Integer> orderId = find1(hql);
		if (orderId != null && orderId.size() > 0) {
			i = orderId.get(0);
		}

		return i;
	}

	public int deleteOrders(int ordersId) {
		String hql = "select * from tb_orders as orders where orders.orderId=?0";

		List<Order> orders = find(hql, ordersId);
		Order order = orders.get(0);
		delete(Order.class);

		if (hql != null && hql.length() > 0) {
			return ordersId;
		}
		return 0;
	}

}
