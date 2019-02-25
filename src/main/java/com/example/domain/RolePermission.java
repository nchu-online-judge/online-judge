package main.java.com.example.domain;
/**
 * role_permission(角色关联权限)的javaBean
 * @author Lenovo
 *
 */
public class RolePermission {

	
	private Role role;
	private Permission permission;
	
	
	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RolePermission(Role role, Permission permission) {
		super();
		this.role = role;
		this.permission = permission;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	
	@Override
	public String toString() {
		return "RolePermission [role=" + role + ", permission=" + permission + "]";
	}
	
}
