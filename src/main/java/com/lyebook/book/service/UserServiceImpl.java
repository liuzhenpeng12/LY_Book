package com.lyebook.book.service;

import com.lyebook.book.entity.User;
import com.lyebook.book.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ComponentScan("com.lyebook.book.mapper")
@Service
public class UserServiceImpl implements UserServiceIF{
    @Autowired
    UserDao userdao;

    @Override
    public User login(User user) {
        return userdao.SelectUser(user);
    }
}
