package com.javaeetest.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Address;
import com.javaeetest.entity.Bargain;
import com.javaeetest.entity.Book;
import com.javaeetest.entity.Order;
import com.javaeetest.entity.OrdersBook;
import com.javaeetest.service.impl.AddressServiceImpl;
import com.javaeetest.service.impl.BookServiceImpl;
import com.javaeetest.service.impl.OrderServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SingleOrdersAction extends ActionSupport {

	private OrderServiceImpl orderService;
	private BookServiceImpl bookService;
	private AddressServiceImpl addressService;

	public AddressServiceImpl getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressServiceImpl addressService) {
		this.addressService = addressService;
	}

	public BookServiceImpl getBookService() {
		return bookService;
	}

	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

	public OrderServiceImpl getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceImpl orderService) {
		this.orderService = orderService;
	}

	/**
	 * 订单详细信息
	 */
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ordersId = request.getParameter("ordersId");
		int ordersIdInt = Integer.parseInt(ordersId);
		System.out.println("ordersIdInt:" + ordersIdInt);
		Order orders = new Order();
		orders = orderService.findOrders(ordersIdInt);
		List<OrdersBook> allOrdersbookByOrders = new ArrayList<OrdersBook>();
		allOrdersbookByOrders = orderService.allOrdersbookByOrders(ordersIdInt);
		List<Book> bookList = new ArrayList<Book>();
		for (OrdersBook ordersbook : allOrdersbookByOrders) {
			Book book = ordersbook.getBook();
			Bargain bargain = null;
			bargain = bookService.isBargain(book.getBookId());
			if (bargain != null) {
				book.setBookPrice(bargain.getBookNewPrice());
			}
			book.setBookAmount(ordersbook.getBookAmount());
			bookList.add(book);
		}
		System.out.println("111121211");
		Address address = new Address();
		System.out.println(orders.getAddressId());
		// 订单地址信息
		address = addressService.findAdderssById(orders.getAddressId());
		System.out.println(address.getDetailedAddress() + "ssdsd");
		request.setAttribute("bookList", bookList);
		request.setAttribute("orders", orders);
		request.setAttribute("address", address);
		return null;
	}

}
