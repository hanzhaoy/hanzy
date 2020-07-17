package org.sang.hanzy.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthUser {
    @GetMapping("/oauth/user")
    public Principal user(Principal principal) {
        System.out.println("11111");
        System.out.println("22211");
        System.out.println("333");
        return principal;
    }

}