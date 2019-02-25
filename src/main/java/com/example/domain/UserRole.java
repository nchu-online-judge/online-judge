package main.java.com.example.domain;
/**
 * user_role(用户与角色关联)的javaBean
 * @author Lenovo
 *
 */
public class UserRole {

	private User user;
	private Role role;
	
	public UserRole() {
	}
	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserRole [user=" + user + ", role=" + role + "]";
	}
	
}
