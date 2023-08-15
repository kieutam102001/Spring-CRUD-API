package com.example.restful_api.controller;

import com.example.restful_api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = {"/hello-world","/xin-chao"},method = RequestMethod.GET)
    public User HelloWorld() {
        User user = new User(2,"Trung Tam");
        return user;
    }
}
