package org.sang.hanzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan

public class HanzyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanzyApplication.class, args);
    }

}
