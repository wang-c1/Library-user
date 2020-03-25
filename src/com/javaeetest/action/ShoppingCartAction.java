package com.javaeetest.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Address;
import com.javaeetest.entity.Bargain;
import com.javaeetest.entity.Book;
import com.javaeetest.entity.User;
import com.javaeetest.service.BookService;
import com.javaeetest.service.UserAddressService;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartAction extends ActionSupport {

	private BookService bookService;
	private UserAddressService userAddressService;

	public UserAddressService getUserAddressService() {
		return userAddressService;
	}

	public void setUserAddressService(UserAddressService userAddressService) {
		this.userAddressService = userAddressService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * 加入购物车
	 */
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String id = request.getParameter("bookId");
		String num = request.getParameter("num");
		int bookId = Integer.parseInt(id);
		int number = Integer.parseInt(num);
		List<Book> shoppingBook = new ArrayList<Book>();
		Book bookFlag = null;
		if (session.getAttribute("shoppingBook") == null)// 如果没有创建购物车ﳵ
		{
			session.setAttribute("shoppingBook", shoppingBook);
		} else {
			shoppingBook = (List<Book>) session.getAttribute("shoppingBook");
		}
		boolean flag = true;
		for (Book book : shoppingBook) {
			if (bookId == book.getBookId()) {
				flag = false;
				bookFlag = book;
			}

		}
		float totalMoney = 0;
		if (flag) { // 如果购物车里没有这类书
			Book book = bookService.findById(bookId);
			book.setBookSalesAmount(number);
			Bargain bargain = null;
			bargain = bookService.isBargain(bookId);
			if (bargain != null) {
				book.setBookNewPrice(bargain.getBookNewPrice());
			}
			shoppingBook.add(book);

			if (session.getAttribute("totalMoney") == null) { // 如果还没有总价钱，什么意思呢，就是说这是我们加入的第一本书
				if (book.getBookNewPrice() != 0) {
					totalMoney = book.getBookNewPrice();
					System.out.println("第一本书不是特价书");
				} else {
					totalMoney = book.getBookPrice();
				}
				totalMoney = totalMoney * book.getBookSalesAmount();
				session.setAttribute("totalMoney", totalMoney);
				System.out.println("第一本书的总价：" + totalMoney);
			} else {

				totalMoney = (float) session.getAttribute("totalMoney");
				if (book.getBookNewPrice() != 0) {
					totalMoney += book.getBookSalesAmount()
							* book.getBookNewPrice();
				} else {
					totalMoney += book.getBookSalesAmount()
							* book.getBookPrice();
				}
				session.removeAttribute("totalMoney");
				session.setAttribute("totalMoney", totalMoney);
				System.out.println("第一本别的类别书的总价：" + totalMoney);
			}

			session.removeAttribute("shoppingBook");
			session.setAttribute("shoppingBook", shoppingBook);

		} else { // 这是说购物车里已经有这种书啦，我们需要加一条数量
			if (bookFlag != null) {
				bookFlag.setBookSalesAmount(bookFlag.getBookSalesAmount()
						+ number);
				totalMoney = (float) session.getAttribute("totalMoney");

				if (bookFlag.getBookNewPrice() != 0) {
					totalMoney += bookFlag.getBookSalesAmount()
							* bookFlag.getBookNewPrice();
				} else {
					totalMoney += bookFlag.getBookSalesAmount()
							* bookFlag.getBookPrice();
				}
				session.removeAttribute("totalMoney");
				session.setAttribute("totalMoney", totalMoney);
				System.out.println("书的总价：" + totalMoney);
			}

		}

		// 购物车页面显示地址
		User user = (User) session.getAttribute("loginUser");
		if (user != null) {
			if (session.getAttribute("userAddress") == null) {
				int userId = user.getUserId();
				int num1 = userAddressService.returnnumber(userId);
				List<Address> address1 = new ArrayList();
				for (int k = 0; k < num1; k++) {
					Address address = userAddressService.findAddressByUserId(
							userId, k);

					address1.add(address);
				}
				session.setAttribute("userAddress", address1);
			}
		}

		try {
			response.sendRedirect("./goods2.jsp?bookId=" + bookId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String showShopingCart() {
		return SUCCESS;
	}

}
