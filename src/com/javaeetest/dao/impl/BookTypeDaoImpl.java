package com.javaeetest.dao.impl;

import java.util.List;

import com.javaeetest.common.dao.impl.BaseDaoImpl;
import com.javaeetest.dao.BookTypeDao;
import com.javaeetest.entity.BookType;

public class BookTypeDaoImpl extends BaseDaoImpl<BookType> implements
		BookTypeDao {

	/**
	 * 所有图书类别
	 */
	@Override
	public List<BookType> allBookType() {
		String hql = "from BookType";

		List<BookType> bookType = findByHql(hql);
		if (bookType != null && bookType.size() > 0) {
			return bookType;
		}

		return null;
	}

}
