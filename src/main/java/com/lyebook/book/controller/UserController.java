package com.lyebook.book.controller;

import com.lyebook.book.entity.User;
import com.lyebook.book.service.UserServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@ComponentScan("com.lzp.ebook.service")
public class UserController {
    @Autowired
    UserServiceIF userServiceIF;

    @RequestMapping("login")
    public User login(User user){
        return userServiceIF.login(user);
    }
}
