package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.RolePermissionDao;
import main.java.com.example.domain.Permission;
import main.java.com.example.domain.RolePermission;

/**
 * 该类作为role表关于增,删,改,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("rolePermissionDaoImpl")
public class RolePermissionDaoImpl implements RolePermissionDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "roleDaoImpl")
	private RoleDaoImpl roleDaoImpl;
	@Resource(name = "permissionDaoImpl")
	private PermissionDaoImpl permissionDaoImpl;

	@Override
	// 将记录存储到role_permissiom表中操作
	public void save(RolePermission rolePermission) {
		String sql = "insert into role_permissiom values(?,?)";
		jdbcTemplate.update(sql, rolePermission.getRole().getId(), rolePermission.getPermission().getId());

	}

	@Override
	// 更改指定角色的权限表的操作
	public void update(Permission permission, RolePermission rolePermission) {
		String sql = "update role_permissiom set permission_id=? where role_id=?";
		jdbcTemplate.update(sql, permission.getId(), rolePermission.getRole().getId());

	}

	@Override
	// 通过传入RolePermission来删除role_permissiom表中记录的操作
	public void delete(RolePermission rolePermission) {
		String sql = "delete from role_permissiom where role_id=?,permission_id=?";
		jdbcTemplate.update(sql, rolePermission.getRole().getId(), rolePermission.getPermission().getId());

	}

	@Override
	// 查找指定角色的权限的操作
	public List<RolePermission> getAllRolePermissionByRoleId(Long roleId) {
		String sql = "select * from role_permissiom where role_id=?";
		List<RolePermission> list = jdbcTemplate.query(sql, new RowMapper<RolePermission>() {
			@Override
			public RolePermission mapRow(ResultSet rs, int arg1) throws SQLException {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRole(roleDaoImpl.getById(rs.getLong("role_id")));
				rolePermission.setPermission(permissionDaoImpl.getById(rs.getLong("permission_id")));
				return rolePermission;
			}
		}, roleId);
		return list;
	}

	@Override
	// 查找role_permissiom表中所有记录的操作
	public List<RolePermission> getAll() {
		String sql = "select * from role_permissiom";
		List<RolePermission> list = jdbcTemplate.query(sql, new RowMapper<RolePermission>() {

			@Override
			public RolePermission mapRow(ResultSet rs, int arg1) throws SQLException {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRole(roleDaoImpl.getById(rs.getLong("role_id")));
				rolePermission.setPermission(permissionDaoImpl.getById(rs.getLong("permission_id")));
				return rolePermission;
			}
		});
		return list;
	}

	@Override
	// 查找role_permissiom表中所有记录的条数
	public int getTotalCount() {
		String sql = "select count(*) from role_permissiom";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<RolePermission> getAllRoleByPermissionId(Long permissionId) {
		String sql = "select * from role_permissiom where permission_id=?";
		List<RolePermission> list = jdbcTemplate.query(sql, new RowMapper<RolePermission>() {

			@Override
			public RolePermission mapRow(ResultSet rs, int arg1) throws SQLException {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRole(new RoleDaoImpl().getById(rs.getLong("role_id")));
				rolePermission.setPermission(new PermissionDaoImpl().getById(rs.getLong("permission_id")));
				return rolePermission;
			}
		});
		return list;
	}

	@Override
	// 查找指定角色所对应的权限数
	public int getPermissionCountOfRole(Long roleId) {
		String sql = "select count(*) from role_permission where role_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, roleId);
	}

	@Override
	// 查找指定权限所对应的角色
	public int getRoleCounyOfPermission(Long permissionId) {
		String sql = "select count(*) from role_permission where permission_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, permissionId);
	}

	@Override
	public void clearRolePermission(Long roleId) {
		String sql = "delete from role_permission where role_id=?";
		jdbcTemplate.update(sql, roleId);
		
	}

	@Override
	public void clearPermissionRole(Long permissionId) {
		String sql = "delete from role_permission where permission_id=?";
		jdbcTemplate.update(sql, permissionId);
		
	}

}
