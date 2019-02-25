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
 * 该类作为permission表关于增,删,改,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("resultDaoImpl")
public class ResultDaoImpl implements ResultDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// 将记录存储到result表中操作
	public void save(Result result) {
		String sql = "insert into result values(?,?)";
		jdbcTemplate.update(sql, result.getId(), result.getName());

	}

	@Override
	// 通过传入一个Result对象来更改result表中记录的操作
	public void update(Result result) {
		String sql = "update result set name=? where id=?";
		jdbcTemplate.update(sql, result.getName(), result.getId());

	}

	@Override
	// 通过传入id来删除result表中记录的操作
	public void delete(Long id) {
		String sql = "delete from result where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// 通过传入id来查找result表中记录的操作
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
	// 查找result表中所有记录的操作
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
	// 查找result表中所有记录的条数
	public int getTotalCount() {
		String sql = "select count(*) from result";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
