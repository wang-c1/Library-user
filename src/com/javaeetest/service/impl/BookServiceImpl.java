package com.javaeetest.service.impl;

import java.util.List;

import com.javaeetest.dao.BargainDao;
import com.javaeetest.dao.BookDao;
import com.javaeetest.dao.BookTypeDao;
import com.javaeetest.entity.Bargain;
import com.javaeetest.entity.Book;
import com.javaeetest.entity.BookType;
import com.javaeetest.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	/**
	 * 按销量排行
	 */
	@Override
	public List<Book> bestSellingBook() {

		return bookDao.bestSellingBook();

	}

	private BargainDao bargainDao;

	public BargainDao getBargainDao() {
		return bargainDao;
	}

	public void setBargainDao(BargainDao bargainDao) {
		this.bargainDao = bargainDao;
	}

	private BookTypeDao bookTypeDao;

	public BookTypeDao getBookTypeDao() {
		return bookTypeDao;
	}

	public void setBookTypeDao(BookTypeDao bookTypeDao) {
		this.bookTypeDao = bookTypeDao;
	}

	/**
	 * 按上架时间排序
	 */
	@Override
	public List<Book> latestBook() {
		// TODO Auto-generated method stub
		return bookDao.latestBook();
	}

	/**
	 * 特价图书
	 */
	@Override
	public List<Bargain> allBargain() {
		// TODO Auto-generated method stub
		return bargainDao.allBargain();
	}

	/**
	 * 查询图书详细信息
	 */
	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id);
	}

	/**
	 * 由id查询该特价图书信息
	 */
	public Bargain isBargain(int id) {
		return bargainDao.isBargain(id);

	}

	/**
	 * 按书名查询
	 */
	public List<Book> allBookByName(String searchDescribe) {
		return bookDao.findByName(searchDescribe);

	}

	/**
	 * 按作者名称
	 */
	@Override
	public List<Book> allBookByAuthor(String searchDescribe) {
		// TODO Auto-generated method stub
		return bookDao.allBookByAuthor(searchDescribe);
	}

	/**
	 * 按出版社
	 */
	@Override
	public List<Book> allBookByPress(String searchDescribe) {
		// TODO Auto-generated method stub
		return bookDao.allBookByPress(searchDescribe);
	}

	/**
	 * 所有图书类别
	 */
	@Override
	public List<BookType> allBookType() {

		return bookTypeDao.allBookType();
	}

	/**
	 * 按书本类别
	 */
	@Override
	public List<Book> allBookByType(int typeId) {
		// TODO Auto-generated method stub
		return bookDao.allBookByType(typeId);
	}

}
