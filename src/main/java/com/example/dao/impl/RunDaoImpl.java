package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.RunDao;
import main.java.com.example.domain.Run;

/**
 * 该类作为run表关于增,删,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("runDaoImpl")
public class RunDaoImpl implements RunDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// 将记录存储到run表中操作
	public void save(Run run) {
		String sql = "insert into run values(?,?,?,?)";
		jdbcTemplate.update(sql, run.getId(), run.getRuntime(), run.getRunMemory(), run.getError());

	}

	@Override
	// 通过传入id来删除run表中记录的操作
	public void delete(Long id) {
		String sql = "delete from run where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// 通过传入id来查找run表中记录的操作
	public Run getById(Long id) {
		String sql = "select * from run where id=?";
		Run run = jdbcTemplate.queryForObject(sql, new RowMapper<Run>() {

			@Override
			public Run mapRow(ResultSet rs, int arg1) throws SQLException {
				Run run = new Run();
				run.setId(rs.getLong("id"));
				run.setRuntime(rs.getInt("time"));
				run.setRunMemory(rs.getInt("memory"));
				run.setError(rs.getString("error"));
				return run;
			}
		}, id);
		return run;
	}

	@Override
	// 查找run表中所有记录的操作
	public List<Run> getAll() {
		String sql = "select * from run";
		List<Run> list = jdbcTemplate.query(sql, new RowMapper<Run>() {

			@Override
			public Run mapRow(ResultSet rs, int arg1) throws SQLException {
				Run run = new Run();
				run.setId(rs.getLong("id"));
				run.setRuntime(rs.getInt("time"));
				run.setRunMemory(rs.getInt("memory"));
				run.setError(rs.getString("error"));
				return run;
			}
		});
		return list;
	}

	@Override
	// 查找role表中所有记录的条数
	public int getTotalCount() {
		String sql = "select count(*) from run";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
