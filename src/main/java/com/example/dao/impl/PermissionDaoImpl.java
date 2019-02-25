package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.PermissionDao;
import main.java.com.example.domain.Permission;

/**
 * 该类作为permission表关于增,删,改,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("permissionDaoImpl")
public class PermissionDaoImpl implements PermissionDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// 将记录存储到permission表中操作
	public void save(Permission permission) {
		String sql = "insert into permission values(?,?,?)";
		jdbcTemplate.update(sql, permission.getId(), permission.getUrl(), permission.getDescription());

	}

	@Override
	// 通过传入一个Permission对象来更改permission表中记录的操作
	public void update(Permission permission) {
		String sql = "update permission set url=?,url_name=? where id=?";
		jdbcTemplate.update(sql, permission.getUrl(), permission.getDescription(), permission.getId());

	}

	@Override
	// 通过传入id来删除permission表中记录的操作
	public void delete(Long id) {
		String sql = "delete from permission where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// 通过传入id来查找permission表中记录的操作
	public Permission getById(Long id) {
		String sql = "select * from permission where id=?";
		Permission permission = jdbcTemplate.queryForObject(sql, new RowMapper<Permission>() {

			@Override
			public Permission mapRow(ResultSet rs, int arg1) throws SQLException {
				Permission permission = new Permission();
				permission.setId(rs.getLong("id"));
				permission.setUrl(rs.getString("url"));
				permission.setDescription(rs.getString("url_name"));
				return permission;
			}
		}, id);
		return permission;
	}

	@Override
	// 查找permission表中所有记录的操作
	public List<Permission> getAll() {
		String sql = "select * from permission";
		List<Permission> list = jdbcTemplate.query(sql, new RowMapper<Permission>() {

			@Override
			public Permission mapRow(ResultSet rs, int arg1) throws SQLException {
				Permission permission = new Permission();
				permission.setId(rs.getLong("id"));
				permission.setUrl(rs.getString("url"));
				permission.setDescription(rs.getString("url_name"));
				return permission;
			}

		});
		return list;
	}

	@Override
	// 查找permission表中所有记录的条数
	public int getTotalCount() {
		String sql = "select count(*) from permission";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
