package com.javaeetest.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Order;
import com.javaeetest.entity.User;
import com.javaeetest.service.impl.OrderServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrdersAction extends ActionSupport {
	private OrderServiceImpl orderService;

	public OrderServiceImpl getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceImpl orderService) {
		this.orderService = orderService;
	}

	/**
	 * 所有订单
	 */
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		List<Order> allOrdersByUser = new ArrayList<Order>();
		List<Order> allOrders = new ArrayList<Order>();
		String searchType = request.getParameter("searchType");

		if (searchType == null || "".equals(searchType.trim())) {
			searchType = "all";
		}
		// 所有订单
		if ("all".equals(searchType)) {

			allOrdersByUser = orderService.allOrdersByUser(user.getUserId());
		}

		// 已处理
		if ("isDeal".equals(searchType)) {
			allOrdersByUser = orderService
					.allOrdersByUserDeal(user.getUserId());
		}
		// 未处理
		if ("isNotDeal".equals(searchType)) {
			allOrdersByUser = orderService.allOrdersByUserNotDeal(user
					.getUserId());
		}
		for (int i = allOrdersByUser.size() - 1; i >= 0; i--) {
			allOrders.add(allOrdersByUser.get(i));

		}
		request.setAttribute("allOrdersByUser", allOrders);
		int sequence = (1 - 1) * 5;
		request.setAttribute("sequence", sequence);

		return null;
	}

	public String showAllOrders() {
		return SUCCESS;
	}
}
