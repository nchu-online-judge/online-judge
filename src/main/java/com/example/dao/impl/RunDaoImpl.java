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
 * ������Ϊrun�������,ɾ,�������ʵ��
 * 
 * @author Lenovo
 *
 */
@Repository("runDaoImpl")
public class RunDaoImpl implements RunDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// ����¼�洢��run���в���
	public void save(Run run) {
		String sql = "insert into run values(?,?,?,?)";
		jdbcTemplate.update(sql, run.getId(), run.getRuntime(), run.getRunMemory(), run.getError());

	}

	@Override
	// ͨ������id��ɾ��run���м�¼�Ĳ���
	public void delete(Long id) {
		String sql = "delete from run where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// ͨ������id������run���м�¼�Ĳ���
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
	// ����run�������м�¼�Ĳ���
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
	// ����role�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from run";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
