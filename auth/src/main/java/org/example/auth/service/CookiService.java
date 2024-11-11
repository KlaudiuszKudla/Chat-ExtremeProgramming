package org.example.auth.service;


import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Service;

@Service
public class CookiService {

    public Cookie generateCookie(String name,String value,int exp){
        Cookie cookie = new Cookie(name,value);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        cookie.setMaxAge(exp);
        cookie.setHttpOnly(true);
        return cookie;
    }

}