package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Permission;

public interface PermissionDao {
	 void save(Permission permission);
	 void update(Permission permission);
	 void delete(Long id);
	 Permission getById(Long id);
	 List<Permission> getAll();
	 int getTotalCount();
}
