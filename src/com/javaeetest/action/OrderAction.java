package com.javaeetest.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Book;
import com.javaeetest.entity.Order;
import com.javaeetest.entity.OrdersBook;
import com.javaeetest.entity.User;
import com.javaeetest.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderAction extends ActionSupport {

	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws java.text.ParseException {
		System.out.println("orderaction");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String updateType = request.getParameter("updateType");

		// 生成订单
		if ("add".equals(updateType)) {
			List<Book> shoppingBook = (List<Book>) session
					.getAttribute("shoppingBook");
			String addressId = request.getParameter("addressId");
			// Address address = (Address) session.getP("radios");
			String money = request.getParameter("totalMoney");
			Float totalMoney = Float.parseFloat(money);
			User user = (User) session.getAttribute("loginUser");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String formatDate = format.format(new Date());

			System.out.println("111" + addressId);
			/* Date time=null; */
			/*
			 * try { time= format.parse(new Date());
			 * 
			 * } catch (ParseException e) {
			 * 
			 * e.printStackTrace(); }
			 */
			Order order = new Order();
			order.setUser(user);
			order.setOrderTime(new Timestamp(new Date().getTime()));
			order.setOrderStatus(0);
			order.setTotalMoney(totalMoney);
			order.setAddressId(addressId);
			String ordersNumber = "DDBH";
			int random = new Random().nextInt(100000);
			ordersNumber += formatDate + random;

			order.setOrderNumber(ordersNumber);
			/*
			 * if(order!=null) { System.out.println("null");
			 * System.out.println(order.getOrderId()); }
			 */
			int ordersId = orderService.addOrders(order);

			Order newOrders = orderService.findOrders(ordersId);
			for (Book book : shoppingBook) {
				OrdersBook ordersbook = new OrdersBook();
				ordersbook.setBook(book);
				ordersbook.setBookAmount(book.getBookSalesAmount());
				ordersbook.setOrder(newOrders);
				orderService.addOrdersbook(ordersbook);
			}
			session.removeAttribute("shoppingBook");
			session.removeAttribute("totalMoney");
			System.out.println("success");
			return "success";
		}

		// 取消订单
		if ("delete".equals(updateType)) {
			String ordersId = request.getParameter("ordersId");
			int id = Integer.valueOf(ordersId);
			int i = 0; // i =
			orderService.DeleteOrder(id);
			return "success";
		}
		// System.out.println("null");
		return null;
	}
}