package org.sang.hanzy.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class DefultView {
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
