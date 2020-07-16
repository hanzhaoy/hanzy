package org.sang.hanzy.config;

import org.sang.hanzy.book.entity.Book;
import org.sang.hanzy.excel.entity.PersonExportVo;
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
    public String book(@ModelAttribute("b") Book book, @ModelAttribute("a") PersonExportVo author){
        return book.toString()+">>>"+ author.toString();
    }

}
