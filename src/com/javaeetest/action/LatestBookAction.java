package com.javaeetest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Book;
import com.javaeetest.service.impl.BookServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LatestBookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BookServiceImpl bookService;

	public BookServiceImpl getBookService() {
		return bookService;
	}

	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

	/**
	 * 按上架时间排序
	 */
	@Override
	public String execute() {
		List<Book> latestBook = bookService.latestBook();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("latestBook", latestBook);
		return null;

	}

}
