package com.javaeetest.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Bargain;
import com.javaeetest.entity.Book;
import com.javaeetest.service.impl.BookServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class BargainBookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookServiceImpl bookService;

	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}

	public BookServiceImpl getBookService() {
		return bookService;
	}

	/**
	 * 特价图书
	 */
	@Override
	public String execute() throws Exception {
		List<Bargain> bargainBook = bookService.allBargain();
		List<Book> book = new ArrayList<Book>();

		for (int i = 0; i < bargainBook.size(); i++) {
			if (bargainBook.get(i).getBook().getBookStatus() == 1) {
				book.add(bargainBook.get(i).getBook());
			}

		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", book);

		return null;

	}

}
