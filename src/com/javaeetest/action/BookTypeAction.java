package com.javaeetest.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.BookType;
import com.javaeetest.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class BookTypeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * 
	 * 图书类别显示
	 */
	public String execute() {
		List<BookType> bookType = bookService.allBookType();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bookType", bookType);
		return null;

	}
}
