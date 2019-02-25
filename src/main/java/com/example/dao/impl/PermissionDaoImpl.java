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
 * ������Ϊpermission�������,ɾ,��,�������ʵ��
 * 
 * @author Lenovo
 *
 */
@Repository("permissionDaoImpl")
public class PermissionDaoImpl implements PermissionDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// ����¼�洢��permission���в���
	public void save(Permission permission) {
		String sql = "insert into permission values(?,?,?)";
		jdbcTemplate.update(sql, permission.getId(), permission.getUrl(), permission.getDescription());

	}

	@Override
	// ͨ������һ��Permission����������permission���м�¼�Ĳ���
	public void update(Permission permission) {
		String sql = "update permission set url=?,url_name=? where id=?";
		jdbcTemplate.update(sql, permission.getUrl(), permission.getDescription(), permission.getId());

	}

	@Override
	// ͨ������id��ɾ��permission���м�¼�Ĳ���
	public void delete(Long id) {
		String sql = "delete from permission where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// ͨ������id������permission���м�¼�Ĳ���
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
	// ����permission�������м�¼�Ĳ���
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
	// ����permission�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from permission";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
