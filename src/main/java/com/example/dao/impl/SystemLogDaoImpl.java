package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.SystemLogDao;
import main.java.com.example.domain.SystemLog;

/**
 * 该类作为syslog表关于增,改,删,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("systemLogDaoImpl")
public class SystemLogDaoImpl implements SystemLogDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(SystemLog systemLog) {
		String sql = "insert into syslog values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, systemLog.getId(), systemLog.getName(), systemLog.getOperation(),
				systemLog.getOperationTime(), systemLog.getMethod(), systemLog.getParams(), systemLog.getIp(),
				systemLog.getTime());

	}

	@Override
	public void delete(Long id) {
		String sql = "delete from syslog where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	public SystemLog getById(Long id) {
		String sql = "select * from syslog where id=?";
		SystemLog log = jdbcTemplate.queryForObject(sql, new RowMapper<SystemLog>() {

			@Override
			public SystemLog mapRow(ResultSet rs, int arg1) throws SQLException {
				SystemLog syslog = new SystemLog();
				syslog.setId(rs.getLong("id"));
				syslog.setName(rs.getString("username"));
				syslog.setOperation(rs.getString("operation"));
				syslog.setOperationTime(rs.getBigDecimal("time"));
				syslog.setMethod(rs.getString("method"));
				syslog.setParams(rs.getString("params"));
				syslog.setIp(rs.getString("ip"));
				syslog.setTime(rs.getTimestamp("create_time"));
				return syslog;
			}
		}, id);
		return log;
	}

	@Override
	public List<SystemLog> getAll() {
		String sql = "select * from syslog";
		List<SystemLog> list = jdbcTemplate.query(sql, new RowMapper<SystemLog>() {

			@Override
			public SystemLog mapRow(ResultSet rs, int arg1) throws SQLException {
				SystemLog syslog = new SystemLog();
				syslog.setId(rs.getLong("id"));
				syslog.setName(rs.getString("username"));
				syslog.setOperation(rs.getString("operation"));
				syslog.setOperationTime(rs.getBigDecimal("time"));
				syslog.setMethod(rs.getString("method"));
				syslog.setParams(rs.getString("params"));
				syslog.setIp(rs.getString("ip"));
				syslog.setTime(rs.getTimestamp("create_time"));
				return syslog;
			}
		});
		return list;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from syslog";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
