package org.sang.hanzy.book.controller;

import org.sang.hanzy.book.entity.Book;
import org.sang.hanzy.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    //   @PostMapping("/")
    /*
     * value:表示支持的yu域 这里表示来自 http://localhost:8081 的请求是支持跨域的
     * maxAge：表示探测请求的有效期
     * allowedHeadles：表示允许的请求头 *表示所有的请求都被允许
     */
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String addBook(String name) {
        return "recrive:" + name;
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String delBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }

    @Autowired
    BookService bookService;

    @GetMapping("/bookOps")
    public void bookOps() {
        Book B1 = new Book();
        B1.setName("111");
        B1.setAuthor("111");
        int i = bookService.addBook(B1);
        System.out.println("addBook>>>" + i);
        List<Book> allBook = bookService.getAllBook();
        System.out.println("allBook>>>" + allBook);

    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        return book.toString();
    }
}
