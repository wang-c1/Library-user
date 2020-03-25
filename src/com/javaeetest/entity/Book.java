package com.javaeetest.entity;

import java.sql.Date;
import java.util.HashSet;


public class Book {
	private Integer bookId;//书ID
	private String bookISBN;//ISBN
	private String bookName;//书名
	private String bookAuthor;//作者
	private String bookPress;//出版社
	private String bookPicture;//图片
	private Integer bookAmount;//数量
	private BookType type;//类型
	private Date bookShelveTime;//上架时间
	private Float bookPrice;//价格
	private String bookRemark;//简介
	private Integer bookSales;//销售量
	private Float bookNewPrice = 0f;//图书特价价格
	private Integer bookSalesAmount;
	private Integer bookStatus;//图书状态״̬
	private Integer bargainStatus;//特价状态ؼ�״̬

	

	public Float getBookNewPrice() {
		return bookNewPrice;
	}

	public void setBookNewPrice(Float bookNewPrice) {
		this.bookNewPrice = bookNewPrice;
	}

	public Book() {
		super();
	}

	public Book(String bookISBN, String bookName, String bookAuthor, String bookPress,
			String bookPicture, Integer bookAmount, BookType type, Date bookShelveTime, Float bookPrice,
			String bookRemark, Integer bookSales) {
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPress = bookPress;
		this.bookPicture = bookPicture;
		this.bookAmount = bookAmount;
		this.type = type;
		this.bookShelveTime = bookShelveTime;
		this.bookPrice = bookPrice;
		this.bookRemark = bookRemark;
		this.bookSales = bookSales;
		
	}
	public Book(String bookISBN, String bookName, String bookAuthor, String bookPress,
			String bookPicture, Integer bookAmount, BookType type, Date bookShelveTime, Float bookPrice,
			String bookRemark, Integer bookSales,Float bookNewPrice,Integer bookSalesAmount,Integer bookStatus,Integer bargainStatus) {
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPress = bookPress;
		this.bookPicture = bookPicture;
		this.bookAmount = bookAmount;
		this.type = type;
		this.bookShelveTime = bookShelveTime;
		this.bookPrice = bookPrice;
		this.bookRemark = bookRemark;
		this.bookSales = bookSales;
		this.bookNewPrice=bookNewPrice;
		this.bookSalesAmount=bookSalesAmount;
		this.bookStatus=bookStatus;
		this.bargainStatus=bargainStatus;
	}
	

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPress() {
		return bookPress;
	}

	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}

	public String getBookPicture() {
		return bookPicture;
	}

	public void setBookPicture(String bookPicture) {
		this.bookPicture = bookPicture;
	}

	public Integer getBookAmount() {
		return bookAmount;
	}

	public void setBookAmount(Integer bookAmount) {
		this.bookAmount = bookAmount;
	}

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	public Date getBookShelveTime() {
		return bookShelveTime;
	}

	public void setBookShelveTime(Date bookShelveTime) {
		this.bookShelveTime = bookShelveTime;
	}

	public Float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookRemark() {
		return bookRemark;
	}

	public void setBookRemark(String bookRemark) {
		this.bookRemark = bookRemark;
	}

	public Integer getBookSales() {
		return bookSales;
	}

	public void setBookSales(Integer bookSales) {
		this.bookSales = bookSales;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBookSalesAmount() {
		return bookSalesAmount;
	}

	public void setBookSalesAmount(Integer bookSalesAmount) {
		this.bookSalesAmount = bookSalesAmount;
	}

	public Integer getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Integer bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Integer getBargainStatus() {
		return bargainStatus;
	}

	public void setBargainStatus(Integer bargainStatus) {
		this.bargainStatus = bargainStatus;
	}


}
