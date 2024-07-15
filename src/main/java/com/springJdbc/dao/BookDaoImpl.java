package com.springJdbc.dao;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springJdbc.Entity.Book;

public class BookDaoImpl implements BookDao {

	private JdbcTemplate jdbcTemplate;

	public int insert(Book book) {
		String query = "insert into books values(?,?,?,?)";
		int r = this.jdbcTemplate.update(query, book.getId(), book.getName(), book.getPrice(), book.getAuthor());
		return r;
	}

	public int change(Book book) {
		String query = "update books set book_name=?, prize=?, author=? where isbn_number=?";
		int r = this.jdbcTemplate.update(query, book.getName(), book.getPrice(), book.getAuthor(), book.getId());
		return r;
	}

	public int delete(Book book) {
		String query = "delete from books where isbn_number=?";
		int r = this.jdbcTemplate.update(query, book.getId());
		return r;
	}

	public Book getBook(String BookId) {
		String query = "select * from books where isbn_number=?";
		RowMapper<Book> rowmap = new RowMapperImpl();
		Book book = this.jdbcTemplate.queryForObject(query, rowmap, BookId);
		return book;
	}
	/*
	 * public Book getBook(String BookId) { String
	 * query="select * from books where isbn_number=?"; RowMapper<Book> rowmap=new
	 * RowMapperImpl(); Book book= this.jdbcTemplate.queryForObject(query, rowmap );
	 * return book; }
	 */

	public List<Book> getAllBooks() {
		String query = "select * from books";
		List<Book> books = this.jdbcTemplate.query(query, new RowMapperImpl());
		return books;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String callDemoProcedure(String inParam) {
		// Define the stored procedure call
		String storedProcedure = "{call demo_procedure(?, ?)}";

		// Call the stored procedure with input and output parameters
		String outParamValue = jdbcTemplate.execute(storedProcedure, (CallableStatement cs) -> {
			cs.setString(1, inParam);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			return cs.getString(2); // Retrieving the output parameter value directly
		});

		return outParamValue;
	}

	public List<Map<String, Object>> getUsers() {
		String sql = "SELECT * FROM books";
		return jdbcTemplate.queryForList(sql);
	}

	public Map<String, Object> getUserById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
		return jdbcTemplate.queryForMap(sql, id);
	}

}
