package org.sang.hanzy.book.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sang.hanzy.book.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    int addBook(Book book);
    List<Book> getAllBook();
}
