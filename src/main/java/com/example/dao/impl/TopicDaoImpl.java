package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.TopicDao;
import main.java.com.example.domain.Topic;

/**
 * 该类作为topic表关于增,改,删,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("topicDaoImpl")
public class TopicDaoImpl implements TopicDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "problemDaoImpl")
	private ProblemDaoImpl problemDaoImpl;
	@Resource(name = "userDaoImpl")
	private UserDaoImpl userDaoImpl;

	@Override
	public void save(Topic topic) {
		String sql = "insert into topic values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, topic.getId(), topic.getProblem().getId(), topic.getTitle(), topic.getUser().getId(),
				topic.getStatus(), topic.getContent(), topic.isDefunct(), topic.getCreatTime());

	}

	@Override
	public void update(Topic topic) {
		String sql = "update topic set title=?,status=?,content=?,defunct=? where id=?";
		jdbcTemplate.update(sql, topic.getTitle(), topic.getStatus(), topic.getContent(), topic.isDefunct(),
				topic.getId());

	}

	@Override
	public void delete(Long id) {
		String sql = "delete from topic where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	public Topic getById(Long id) {
		String sql = "select * from topic where id=?";
		Topic topic = jdbcTemplate.queryForObject(sql, new RowMapper<Topic>() {

			@Override
			public Topic mapRow(ResultSet rs, int arg1) throws SQLException {
				Topic topic = new Topic();
				topic.setId(rs.getLong("id"));
				topic.setProblem(problemDaoImpl.getById(rs.getLong("problem_id")));
				topic.setTitle(rs.getString("title"));
				topic.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				topic.setStatus(rs.getInt("status"));
				topic.setContent(rs.getString("content"));
				topic.setDefunct(rs.getBoolean("defunct"));
				topic.setCreatTime(rs.getTimestamp("time"));
				return topic;
			}
		}, id);
		return topic;
	}

	@Override
	public List<Topic> getAll() {
		String sql = "select * from topic";
		List<Topic> list = jdbcTemplate.query(sql, new RowMapper<Topic>() {

			@Override
			public Topic mapRow(ResultSet rs, int arg1) throws SQLException {
				Topic topic = new Topic();
				topic.setId(rs.getLong("id"));
				topic.setProblem(problemDaoImpl.getById(rs.getLong("problem_id")));
				topic.setTitle(rs.getString("title"));
				topic.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				topic.setStatus(rs.getInt("status"));
				topic.setContent(rs.getString("content"));
				topic.setDefunct(rs.getBoolean("defunct"));
				topic.setCreatTime(rs.getTimestamp("time"));
				return topic;
			}
		});
		return list;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from topic";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
