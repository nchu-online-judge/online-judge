package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.User;

public interface UserDao{
	 void save(User user);
	 void update(User user);
	 void delete(Long id);
	 User getById(Long id);
	 List<User> getAll();
	 int getTotalCount();
}