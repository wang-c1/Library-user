package com.javaeetest.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.javaeetest.entity.Bargain;
import com.javaeetest.entity.Book;
import com.javaeetest.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OneTypeAction extends ActionSupport {

	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * 查询图书
	 */
	public String execute() throws UnsupportedEncodingException {
		String page = "oneType";
		List<Book> bookList = new ArrayList<Book>();
		String typeDescribe = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		String searchType = new String(request.getParameter("searchType"));
		// String searchType = request.getParameter("searchType");
		// String searchDescribe = request.getParameter("searchDescribe");
		String searchDescribe = new String(
				request.getParameter("searchDescribe"));
		System.out.println(searchDescribe);
		if (searchType == null || "".equals(searchType.trim())) {
			page = "error";
		} else {
			if (searchDescribe == null || "".equals(searchDescribe.trim())) {
				page = "error";
			} else {
				if ("bookName".equals(searchType)) {// 按图书名称
					bookList = bookService.allBookByName(searchDescribe);
					typeDescribe = searchDescribe;
				} else if ("bookAuthor".equals(searchType)) {// 按作者名称
					bookList = bookService.allBookByAuthor(searchDescribe);
					typeDescribe = searchDescribe;
				} else if ("bookPress".equals(searchType)) {// 按出版社
					bookList = bookService.allBookByPress(searchDescribe);
					typeDescribe = searchDescribe;
				} else if ("bookType".equals(searchType)) {// 按书本类别
					int typeId = Integer.parseInt(searchDescribe);
					// Type type = bookService.findType(typeId);
					bookList = bookService.allBookByType(typeId);
					// typeDescribe = type.getTypeName();
				} else if ("bookStatus".equals(searchType)) {
					if ("bestSelling".equals(searchDescribe)) {
						// 畅销书
						typeDescribe = "畅销书";
						bookList = bookService.bestSellingBook();
					} else if ("latest".equals(searchDescribe)) {
						// 最新书
						typeDescribe = "最新书";
						bookList = bookService.latestBook();
					} else if ("bargain".equals(searchDescribe)) {
						// 特价书
						typeDescribe = "特价书";
						List<Bargain> allBargain = bookService.allBargain();
						for (Bargain bargain : allBargain) {
							Book book = new Book();
							book = bargain.getBook();
							bookList.add(book);
						}
					} else {
						page = "error";
					}
				} else {
					page = "error";
				}
			}
		}
		request.setAttribute("typeDescribe", typeDescribe);
		request.setAttribute("bookList", bookList);
		return page;
	}

}
