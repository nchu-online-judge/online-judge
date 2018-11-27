package com.example.dao;

import com.example.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface UserDao {
    public int addUser(User user);

    public int update(User user);

    public int delete(Integer id);

    public User findUserById(Integer id);

    public Integer count();

    public List<User> getAllUser();
}
