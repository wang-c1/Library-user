package com.javaeetest.dao;

import java.util.List;

import com.javaeetest.common.dao.BaseDao;
import com.javaeetest.entity.Book;
import com.javaeetest.entity.BookType;

public interface BookDao extends BaseDao<Book>{
	
	/**
	 * 
	 * @param book
	 */
	public void addBook(Book book);
	public List<Book> bestSellingBook();
	public List<Book> latestBook();
	public List<Book> bargainBook();
	public Book findById(int id);
	public List<Book> findByName(String searchDescribe);
	public List<Book> allBookByAuthor(String searchDescribe);
	public List<Book> allBookByPress(String searchDescribe);
	public List<Book> allBookByType(int typeId);
	
	
}
