package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.RoleDao;
import main.java.com.example.domain.Role;

/**
 * 该类作为role表关于增,删,改,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("roleDaoImpl")
public class RoleDaoImpl implements RoleDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// 将记录存储到role表中操作
	public void save(Role role) {
		String sql = "insert into role values(?,?,?)";
		jdbcTemplate.update(sql, role.getId(), role.getName(), role.getDescription());

	}

	@Override
	// 通过传入一个Role对象来更改role表中记录的操作
	public void update(Role role) {
		String sql = "update role set role_name=?,memo=? where id=?";
		jdbcTemplate.update(sql, role.getName(), role.getDescription(), role.getId());

	}

	@Override
	// 通过传入id来删除role表中记录的操作
	public void delete(Long id) {
		String sql = "delete from role where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// 通过传入id来查找role表中记录的操作
	public Role getById(Long id) {
		String sql = "select * from role where id=?";
		Role role = jdbcTemplate.queryForObject(sql, new RowMapper<Role>() {

			@Override
			public Role mapRow(ResultSet rs, int arg1) throws SQLException {
				Role role = new Role();
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("memo"));
				return role;
			}
		}, id);
		return role;
	}

	@Override
	// 查找role表中所有记录的操作
	public List<Role> getAll() {
		String sql = "select * from role";
		List<Role> list = jdbcTemplate.query(sql, new RowMapper<Role>() {

			@Override
			public Role mapRow(ResultSet rs, int arg1) throws SQLException {
				Role role = new Role();
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("role_name"));
				role.setDescription(rs.getString("memo"));
				return role;
			}
		});
		return list;
	}

	@Override
	// 查找role表中所有记录的条数
	public int getTotalCount() {
		String sql = "select count(*) from role";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
