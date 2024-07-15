package com.springJdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springJdbc.Entity.Book;
import com.springJdbc.dao.BookDao;

public class App {
	public static void main(String[] args) {

		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("com/springJdbc/Config.xml");
		BookDao bookDao = context.getBean("bookDao", BookDao.class);

		Book b = new Book();
		
		b.setId("107");
		b.setName("History");
		b.setPrice("690");
		b.setAuthor("oak");
//		int r = bookDao.insert(b);
//		System.out.println("Book Added: " + r);
		
//		b.setId("105");
//		b.setName("Geography");
//		b.setPrice("600");
//		b.setAuthor("oak");
//		int r = bookDao.change(b);
//		System.out.println("Book Changed: " + r);
		
//		b.setId("105");
//		int r = bookDao.delete(b);
//		System.out.println("Book Deleted: " + r);
		
//		Book b1=bookDao.getBook("102");
//		System.out.println(b1);
//		
		
		List<Map<String, Object>>  books=bookDao.getUsers();
		
		for(Map<String, Object> m:books) {
			System.out.println(m.keySet());
			System.out.println(m.values());
		}
		
//		List<Book> books=bookDao.getAllBooks();
//		for(Book b3:books) {
//			System.out.println(b3);
//		}
	}
}
