package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.UserRoleDao;
import main.java.com.example.domain.UserRole;

/**
 * 该类作为user_role表关于增,改,删,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("userRoleDaoImpl")
public class UserRoleDaoImpl implements UserRoleDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "roleDaoImpl")
	private RoleDaoImpl roleDaoImpl;
	@Resource(name = "userDaoImpl")
	private UserDaoImpl userDaoImpl;

	@Override
	public void save(UserRole userRole) {
		String sql = "insert into user_role values(?,?)";
		jdbcTemplate.update(sql, userRole.getRole().getId(), userRole.getUser().getId());

	}

	@Override
	public void update(UserRole userRole) {
		String sql = "update user_role set role_id=? where user_id=?";
		jdbcTemplate.update(sql, userRole.getRole().getId(), userRole.getUser().getId());

	}

	@Override
	public void delete(UserRole userRole) {
		String sql = "delete from user_role where user_id=? and role_id=?";
		jdbcTemplate.update(sql, userRole.getUser().getId(), userRole.getRole().getId());

	}

	@Override
	public List<UserRole> getRoleByUserId(Long userId) {
		String sql = "select * from user_role where user_id=?";
		List<UserRole> list = jdbcTemplate.query(sql, new RowMapper<UserRole>() {

			@Override
			public UserRole mapRow(ResultSet rs, int arg1) throws SQLException {
				UserRole ur = new UserRole();
				ur.setRole(roleDaoImpl.getById(rs.getLong("role_id")));
				ur.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				return ur;
			}
		}, userId);
		return list;
	}

	@Override
	public List<UserRole> getAll() {
		String sql = "Select * from user_role";
		List<UserRole> list = jdbcTemplate.query(sql, new RowMapper<UserRole>() {

			@Override
			public UserRole mapRow(ResultSet rs, int arg1) throws SQLException {
				UserRole ur = new UserRole();
				ur.setRole(roleDaoImpl.getById(rs.getLong("role_id")));
				ur.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				return ur;
			}
		});
		return list;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from user_role";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<UserRole> getUserByRoleId(Long roleId) {
		String sql = "select * from user_role where role_id=?";
		List<UserRole> list = jdbcTemplate.query(sql, new RowMapper<UserRole>() {

			@Override
			public UserRole mapRow(ResultSet rs, int arg1) throws SQLException {
				UserRole ur = new UserRole();
				ur.setRole(new RoleDaoImpl().getById(rs.getLong("role_id")));
				ur.setUser(new UserDaoImpl().getById(rs.getLong("user_id")));
				return ur;
			}
		}, roleId);
		return list;
	}

	@Override
	public void clearUserRole(Long userId) {
		String sql = "delete from user_role where user_id=?";
		jdbcTemplate.update(sql, userId);

	}

	@Override
	public void clearRoleUser(Long roleId) {
		String sql = "delete from user_role where role_id=?";
		jdbcTemplate.update(sql, roleId);

	}

}
