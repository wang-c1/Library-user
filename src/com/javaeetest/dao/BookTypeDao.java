package com.javaeetest.dao;

import java.util.List;

import com.javaeetest.common.dao.BaseDao;
import com.javaeetest.entity.Book;
import com.javaeetest.entity.BookType;

public interface BookTypeDao extends BaseDao<BookType> {

	public List<BookType> allBookType();

}
