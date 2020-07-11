package org.sang.hanzy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sang.hanzy.controller.BookController;
import org.sang.hanzy.entity.Book;
import org.sang.hanzy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class HanzyApplicationTests {


    @Autowired
    BookController bookController;

    @Autowired
    WebApplicationContext wac;
    MockMvc mockMvc;

    @BeforeTestClass
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    @Test
    void test2()throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Book book = new Book();
        book.setName("西游记");
        book.setAuthor("吴承恩");
        book.setId(9);
        String s = mapper.writeValueAsString(book);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/book/addBook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(s))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
