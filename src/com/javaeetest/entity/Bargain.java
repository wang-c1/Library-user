package com.javaeetest.entity;

public class Bargain {
	private int bargainId;
	private Book book;
	private float bookNewPrice;
	private int bargainStatus;

	public Bargain() {

	}

	public int getBargainId() {
		return bargainId;
	}

	public void setBargainId(int bargainId) {
		this.bargainId = bargainId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public float getBookNewPrice() {
		return bookNewPrice;
	}

	public void setBookNewPrice(float bookNewPrice) {
		this.bookNewPrice = bookNewPrice;
	}

	public int getBargainStatus() {
		return bargainStatus;
	}

	public void setBargainStatus(int bargainStatus) {
		this.bargainStatus = bargainStatus;
	}

}
