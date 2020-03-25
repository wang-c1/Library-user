package com.javaeetest.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Book;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateCartAction extends ActionSupport {

	@SuppressWarnings("unchecked")
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String updateType = request.getParameter("updateType");
		List<Book> shoppingBook = (List<Book>) session
				.getAttribute("shoppingBook");
		float totalMoney = 0;
		totalMoney = (Float) session.getAttribute("totalMoney");
		// 更新购物车
		if ("update".equals(updateType)) {
			String bookId = request.getParameter("bookId");
			String bookAmount = request.getParameter("bookAmount");
			for (Book book : shoppingBook) {
				if (bookId.equals(book.getBookId() + "")) {
					totalMoney += (Integer.parseInt(bookAmount) - book
							.getBookAmount()) * book.getBookPrice();
					book.setBookAmount(Integer.parseInt(bookAmount));
				}
			}
		}
		// 删除购物车内商品
		if ("delete".equals(updateType)) {
			String bookId = request.getParameter("bookId");
			Iterator<Book> iter = shoppingBook.iterator();
			while (iter.hasNext()) {
				Book book = (Book) iter.next();
				if (bookId.equals(book.getBookId() + "")) {
					if (book.getBookNewPrice() == 0) {
						totalMoney -= book.getBookSalesAmount()
								* book.getBookPrice();
					}

					else {
						totalMoney -= book.getBookSalesAmount()
								* book.getBookNewPrice();
					}
					iter.remove();
				}
			}
		}
		session.removeAttribute("shoppingBook");
		session.setAttribute("shoppingBook", shoppingBook);
		session.removeAttribute("totalMoney");
		session.setAttribute("totalMoney", totalMoney);
		try {
			response.sendRedirect("showShopingCart");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
