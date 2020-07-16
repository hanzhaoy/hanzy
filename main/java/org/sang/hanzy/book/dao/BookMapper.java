package org.sang.hanzy.book.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sang.hanzy.book.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    int addBook(Book book);
    List<Book> getAllBook();
}
