package org.sang.hanzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@ServletComponentScan
//@EnableResourceServer

public class HanzyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanzyApplication.class, args);
    }

}
