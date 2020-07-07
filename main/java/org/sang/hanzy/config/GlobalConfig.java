package org.sang.hanzy.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalConfig {
    //添加全局变量
    //value表示返回数据的key，方法返回的值是返回数据的value （hello方法）
    @ModelAttribute(value = "info")
    public Map<String,String> userInfo(){
        HashMap<String,String> map = new HashMap<>();
        map.put("userName","罗贯中");
        map.put("gender","男");
        return map;
    }

    //表示该方法处理的是@ModelAttribute("b")对应的参数
    @InitBinder("b")
    public void init(WebDataBinder binder){
        //给相应的Field设置一个前缀
        binder.setFieldDefaultPrefix("b.");
    }
    //表示该方法处理的是@ModelAttribute("a")对应的参数
    @InitBinder("a")
    public void init2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("a.");
    }



}
