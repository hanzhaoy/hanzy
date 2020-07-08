package org.sang.hanzy.dao;

import org.sang.hanzy.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addBook(Book book){
        return jdbcTemplate.update("INSERT INTO book(name,author) VALUES (?,?)",book.getName(),book.getAuthor());
    }
    public List<Book> getAllBook(){
        return jdbcTemplate.query("select * from book ",new BeanPropertyRowMapper<>(Book.class));
    }
}
