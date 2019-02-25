package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.ResultDao;
import main.java.com.example.domain.Result;

/**
 * ������Ϊpermission�������,ɾ,��,�������ʵ��
 * 
 * @author Lenovo
 *
 */
@Repository("resultDaoImpl")
public class ResultDaoImpl implements ResultDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// ����¼�洢��result���в���
	public void save(Result result) {
		String sql = "insert into result values(?,?)";
		jdbcTemplate.update(sql, result.getId(), result.getName());

	}

	@Override
	// ͨ������һ��Result����������result���м�¼�Ĳ���
	public void update(Result result) {
		String sql = "update result set name=? where id=?";
		jdbcTemplate.update(sql, result.getName(), result.getId());

	}

	@Override
	// ͨ������id��ɾ��result���м�¼�Ĳ���
	public void delete(Long id) {
		String sql = "delete from result where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// ͨ������id������result���м�¼�Ĳ���
	public Result getById(Long id) {
		String sql = "select * from result where id=?";
		Result result = jdbcTemplate.queryForObject(sql, new RowMapper<Result>() {

			@Override
			public Result mapRow(ResultSet rs, int arg1) throws SQLException {
				Result result = new Result();
				result.setId(rs.getLong("id"));
				result.setName(rs.getString("name"));
				return result;
			}
		}, id);
		return result;
	}

	@Override
	// ����result�������м�¼�Ĳ���
	public List<Result> getAll() {
		String sql = "select * from result";
		jdbcTemplate.query(sql, new RowMapper<Result>() {

			@Override
			public Result mapRow(ResultSet rs, int arg1) throws SQLException {
				Result result = new Result();
				result.setId(rs.getLong("id"));
				result.setName(rs.getString("name"));
				return result;
			}
		});
		return null;
	}

	@Override
	// ����result�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from result";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
