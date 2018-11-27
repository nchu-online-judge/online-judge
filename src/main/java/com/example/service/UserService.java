package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {
    public int addUser(User user);

    public int update(User user);

    public int delete(Integer id);

    public User findUserById(Integer id);

    public Integer count();

    public List<User> getAllUser();
}
