package com.example.dao;

import com.example.doamin.User;


public interface UserDao {

    User findByUserName(String username);
}
