package org.sang.hanzy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.hanzy.entity.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    int addBook(Book book);
    List<Book> getAllBook();
}
