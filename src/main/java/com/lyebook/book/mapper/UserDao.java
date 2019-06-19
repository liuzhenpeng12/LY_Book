package com.lyebook.book.mapper;

import  com.lyebook.book.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User SelectUser(User user);
}
