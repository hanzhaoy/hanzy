package org.sang.hanzy.controller;

import org.sang.hanzy.entity.Author;
import org.sang.hanzy.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
public class GlobalController {

    @GetMapping("/hello")
    @ResponseBody
    public void hello( Model model){
        Map<String, Object> map = model.asMap();
        Set<String> strings = map.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            Object value = map.get(key);
            System.out.println(key+">>>>>>"+value);
        }
    }

    @GetMapping("/book")
    @ResponseBody
    public String book(@ModelAttribute("b") Book book,@ModelAttribute("a") Author author){
        return book.toString()+">>>"+ author.toString();
    }

}
