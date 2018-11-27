package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int addUser(User user) {
        String sql = "insert into user values(null,?,?,?)";
        return jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getEmail());
    }

    @Override
    public int update(User user) {
        String sql = "update user set name = ?, email = ? where id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "SELECT id, name , email FROM user WHERE id=?";
        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public Integer count() {
        String sql = "select count(*) from user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> getAllUser() {
        String sql = "select id,name,password,email from user";
        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> userList = jdbcTemplate.query(sql, rowMapper);
        return userList;
    }

}
