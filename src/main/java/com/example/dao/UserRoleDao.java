package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.UserRole;

public interface UserRoleDao {
	 void save(UserRole userRole);
	 void update(UserRole userRole);
	 void delete(UserRole userRole);
	 List<UserRole> getRoleByUserId(Long userId);
	 List<UserRole> getUserByRoleId(Long roleId);
	 List<UserRole> getAll();
	 void clearUserRole(Long userId);
	 void clearRoleUser(Long roleId);
	 int getTotalCount();
}
