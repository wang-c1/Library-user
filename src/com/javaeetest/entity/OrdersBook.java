package com.javaeetest.entity;

public class OrdersBook {
	
	private int orderBookId;
	private Order order;
	private Book book;
	private int  bookAmount;

public int getOrderBookId() {
		return orderBookId;
	}
	public void setOrderBookId(int orderBookId) {
		this.orderBookId = orderBookId;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getBookAmount() {
		return bookAmount;
	}
	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}





}
