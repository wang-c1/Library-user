package com.javaeetest.service;

import java.util.List;

import com.javaeetest.entity.Bargain;
import com.javaeetest.entity.Book;
import com.javaeetest.entity.BookType;

public interface BookService {
public List<Book> bestSellingBook();
public List<Book> latestBook();
public List<Bargain> allBargain();
public Book findById(int id);
public Bargain isBargain(int id);
public List<Book> allBookByName(String searchDescribe);
public List<Book> allBookByAuthor(String searchDescribe);
public List<Book> allBookByPress(String searchDescribe);
public List<BookType> allBookType();
public List<Book> allBookByType(int typeId);

}
