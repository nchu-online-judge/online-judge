package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Role;

public interface RoleDao {
	 void save(Role role);
	 void update(Role role);
	 void delete(Long id);
	 Role getById(Long id);
	 List<Role> getAll();
	 int getTotalCount();
}
