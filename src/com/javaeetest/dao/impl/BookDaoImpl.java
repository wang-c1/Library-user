package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.BookDao;
import com.javaeetest.entity.Book;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	@Override
	public void addBook(Book book) {

	}

	/**
	 * 销量排行图书
	 */
	@Override
	public List<Book> bestSellingBook() {

		String hql = "from Book as book where book.bookSales>=0 and book.bookStatus=1 and book.bookAmount>0"
				+ "order by book.bookSales desc";
		List<Book> bestSellingBook = findByHql(hql);
		if (bestSellingBook != null && bestSellingBook.size() > 0) {

			return bestSellingBook;

		}

		return null;
	}

	/**
	 * 最新上架图书，按上架时间排序
	 */
	@Override
	public List<Book> latestBook() {
		// TODO Auto-generated method stub
		String hql = "from Book as book where book.bookStatus=1 and book.bookAmount>0"
				+ "order by book.bookShelveTime desc";
		List<Book> latestBook = findByHql(hql);
		if (latestBook != null && latestBook.size() > 0) {

			return latestBook;
		}
		return null;

	}

	/**
	 * 特价邀约图书
	 */
	@Override
	public List<Book> bargainBook() {
		// TODO Auto-generated method stub

		String hql = "from Bargain as bargain  ";
		List<Book> bargainBook = findByHql(hql);
		if (bargainBook != null && bargainBook.size() > 0) {

			return bargainBook;

		}

		return null;
	}

	@Override
	public Book findById(int id) {

		String hql = "select * from tb_book as book where book.bookId=?0";
		List<Book> book = find(hql, id);
		if (book != null && book.size() > 0) {

			return book.get(0);

		}

		return null;
	}

	public List<Book> findByName(String searchDescribe) {

		String hql = "from Book as book where book.bookStatus=1 and book.bookName like '%"
				+ searchDescribe + "%'";
		List<Book> book = findByHql(hql);
		if (book != null && book.size() > 0) {
			return book;

		}

		return null;
	}

	@Override
	public List<Book> allBookByAuthor(String searchDescribe) {
		// TODO Auto-generated method stub
		String hql = "from Book as book where book.bookStatus=1 and book.bookAuthor like '%"
				+ searchDescribe + "%'";
		List<Book> book = findByHql(hql);
		if (book != null && book.size() > 0) {
			return book;

		}

		return null;
	}

	@Override
	public List<Book> allBookByPress(String searchDescribe) {
		String hql = "from Book as book where book.bookStatus=1 and book.bookPress like '%"
				+ searchDescribe + "%'";
		List<Book> book = findByHql(hql);
		if (book != null && book.size() > 0) {
			return book;

		}

		return null;
	}

	@Override
	public List<Book> allBookByType(int typeId) {
		System.out.println("ahah");
		String hql = "select * from tb_book as book where book.bookStatus=1 and book.typeId=?0";
		List<Book> book = find(hql, typeId);
		if (book != null && book.size() > 0) {
			System.out.println(book.size());
			System.out.println(book.get(0).getBookAuthor());
			return book;

		}

		return null;
	}

}
