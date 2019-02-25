package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.UserDao;
import main.java.com.example.domain.User;
/**
 * 该类作为user表关于增,改,删,查操作的实现
 * @author Lenovo 
 *
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(User user) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getId(),user.getName(),user.getPassword(),user.getPhoneNumber(),user.getEmail(),user.getSchool(),user.getHeadImage(),user.getSolveNumber(),user.getSubmitNumber(),user.getSubmitTimes(),user.getSuccess(),user.getFail(),user.getStatus(),user.getCreatTime());
	}

	@Override
	public void update(User user) {
		String sql = "update user set user_name=?,password=?,phone_number=?,email=?,school=?,head_image=?,solved=?,submit=?,submit_all=?,success=?,fail=?,status=? where id=?";
		jdbcTemplate.update(sql, user.getName(),user.getPassword(),user.getPhoneNumber(),user.getEmail(),user.getSchool(),user.getHeadImage(),user.getSolveNumber(),user.getSubmitNumber(),user.getSubmitTimes(),user.getSuccess(),user.getFail(),user.getStatus(),user.getId());
		
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from user where id = ?";
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public User getById(Long id) {
		String sql = "select * from user where id=?";
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				 User user = new User();
				    user.setId(rs.getLong("id"));
				    user.setName(rs.getString("user_name"));
				    user.setPassword(rs.getString("password"));
				    user.setEmail(rs.getString("email"));
				    user.setSchool(rs.getString("school"));
				    user.setHeadImage(rs.getString("head_image"));
				    user.setPhoneNumber(rs.getString("phone_number"));
				    user.setSolveNumber(rs.getInt("solved"));
				    user.setSubmitNumber(rs.getInt("submit"));
				    user.setSubmitTimes(rs.getInt("submit_all"));
				    user.setSuccess(rs.getInt("success"));
				    user.setFail(rs.getInt("fail"));
				    user.setStatus(rs.getBoolean("status"));
				    user.setCreatTime(rs.getTimestamp("c_time"));
					return user;
			}}, id);

		return user;
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from user";
		List<User> list = jdbcTemplate.query(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				 User user = new User();
				    user.setId(rs.getLong("id"));
				    user.setName(rs.getString("user_name"));
				    user.setPassword(rs.getString("password"));
				    user.setEmail(rs.getString("email"));
				    user.setSchool(rs.getString("school"));
				    user.setHeadImage(rs.getString("head_image"));
				    user.setPhoneNumber(rs.getString("phone_number"));
				    user.setSolveNumber(rs.getInt("solved"));
				    user.setSubmitNumber(rs.getInt("submit"));
				    user.setSubmitTimes(rs.getInt("submit_all"));
				    user.setSuccess(rs.getInt("success"));
				    user.setFail(rs.getInt("fail"));
				    user.setStatus(rs.getBoolean("status"));
				    user.setCreatTime(rs.getTimestamp("c_time"));
					return user;
			}});
		return list;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from user";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

}
