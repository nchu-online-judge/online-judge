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
 * ������Ϊrole�������,ɾ,��,�������ʵ��
 * 
 * @author Lenovo
 *
 */
@Repository("roleDaoImpl")
public class RoleDaoImpl implements RoleDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// ����¼�洢��role���в���
	public void save(Role role) {
		String sql = "insert into role values(?,?,?)";
		jdbcTemplate.update(sql, role.getId(), role.getName(), role.getDescription());

	}

	@Override
	// ͨ������һ��Role����������role���м�¼�Ĳ���
	public void update(Role role) {
		String sql = "update role set role_name=?,memo=? where id=?";
		jdbcTemplate.update(sql, role.getName(), role.getDescription(), role.getId());

	}

	@Override
	// ͨ������id��ɾ��role���м�¼�Ĳ���
	public void delete(Long id) {
		String sql = "delete from role where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// ͨ������id������role���м�¼�Ĳ���
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
	// ����role�������м�¼�Ĳ���
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
	// ����role�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from role";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
