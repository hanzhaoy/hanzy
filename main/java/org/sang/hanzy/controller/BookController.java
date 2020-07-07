package org.sang.hanzy.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @PostMapping("/")
    /*
    *value:表示支持的yu域 这里表示来自 http://localhost:8081 的请求是支持跨域的
    * maxAge：表示探测请求的有效期
    * allowedHeadles：表示允许的请求头 *表示所有的请求都被允许
    */
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800,allowedHeaders = "*")
    public String addBook(String name){
        return "recrive:"+name;
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800,allowedHeaders = "*")
    public String delBookById(@PathVariable Long id){
        return String.valueOf(id);
    }
}
