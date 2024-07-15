package com.springJdbc.dao;

import java.util.List;
import java.util.Map;

import com.springJdbc.Entity.Book;

public interface BookDao {
	
	public int insert(Book book);
	
	public int change(Book book);
	
	public int delete(Book book);
	
	public Book getBook(String BookId);
	
	public List<Book> getAllBooks();
	
	List<Map<String, Object>> getUsers() ;

}
