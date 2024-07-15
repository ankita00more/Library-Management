package com.springJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springJdbc.Entity.Book;

public class RowMapperImpl implements RowMapper<Book>{

	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		Book book=new Book();
		book.setId(rs.getString(1));
		book.setName(rs.getString(2));
		book.setPrice(rs.getString(3));
		book.setAuthor(rs.getString(4));
		return book;
	}

}
