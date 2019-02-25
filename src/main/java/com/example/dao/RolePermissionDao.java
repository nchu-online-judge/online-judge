package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Permission;
import main.java.com.example.domain.RolePermission;

public interface RolePermissionDao {
	 void save(RolePermission rolePermission);
	 void update(Permission permission,RolePermission rolePermission);
	 void delete(RolePermission rolePermission);
	 List<RolePermission> getAllRolePermissionByRoleId(Long roleId);
	 List<RolePermission> getAllRoleByPermissionId(Long permissionId);
	 List<RolePermission> getAll();
	 void clearRolePermission(Long roleId);
	 void clearPermissionRole(Long permissionId);
	 int getTotalCount();
	 int getPermissionCountOfRole(Long roleId);
	 int getRoleCounyOfPermission(Long permissionId);
}
