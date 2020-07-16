package org.sang.hanzy.config;

import org.sang.hanzy.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @GetMapping("/test")
    public void test01(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("name","三国演义");
        String name = ops.get("name");
        System.out.println(name);
        ValueOperations ops1 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setId(5);
        book.setName("红楼梦");
        book.setAuthor("曹雪芹");
        ops1.set("book",book);
        Book book1 = (Book)ops1.get("book");
        System.out.println(book1);

    }
}
