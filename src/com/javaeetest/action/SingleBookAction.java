/*package com.huizhi.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.BookManage;
import entity.*;

@SuppressWarnings("serial")
public class SingleBookAction extends ActionSupport{

	private BookManage bookManage;

	public void setBookManage(BookManage bookManage) {
		this.bookManage = bookManage;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String bookId = request.getParameter("bookId");
		int bookIdInt = Integer.parseInt(bookId);
		Book book = new Book();
		book = bookManage.findBook(bookIdInt);
		Bargain bargain = null;
		bargain = bookManage.isBargain(bookIdInt);
		if(bargain == null){
			book.setBookNewPrice(book.getBookPrice());
		}else{
			book.setBookNewPrice(bargain.getBookNewPrice());
		}
		request.setAttribute("singleBook", book);
		return null;
	}
}
 */
package com.javaeetest.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Bargain;
import com.javaeetest.entity.Book;
import com.javaeetest.service.impl.BookServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SingleBookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BookServiceImpl bookService;

	public BookServiceImpl getBookService() {
		return bookService;
	}

	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

	/**
	 * 商品详情
	 */
	@Override
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bookId = request.getParameter("bookId");
		int bookIdInt = Integer.parseInt(bookId);
		Book book = new Book();
		// 查找图书详细信息
		book = bookService.findById(bookIdInt);
		Bargain bargain = null;
		// 判断是否特价
		bargain = bookService.isBargain(bookIdInt);
		if (bargain == null) {// 如果不是特价图书
			book.setBookNewPrice(book.getBookPrice());
		} else {// 如果是特价图书
			book.setBookNewPrice(bargain.getBookNewPrice());
		}
		request.setAttribute("singleBook", book);
		return null;

	}

}
