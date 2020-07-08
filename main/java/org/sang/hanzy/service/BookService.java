package org.sang.hanzy.service;

import org.sang.hanzy.mapper.BookMapper;
import org.sang.hanzy.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
//    @Autowired
//    BookDao bookDao;
//    public int addBook(Book book){
//        return bookDao.addBook(book);
//    }
//    public List<Book> getAllBook(){
//        return bookDao.getAllBook();
//    }

    @Autowired
    BookMapper bookMapper;
    public int addBook(Book book){
        return bookMapper.addBook(book);
    }
    public List<Book> getAllBook(){
        return bookMapper.getAllBook();
    }
}
