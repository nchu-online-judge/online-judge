package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.TopicStoreDao;
import main.java.com.example.domain.TopicStore;

/**
 * 该类作为topic_stow表关于增,改,删,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("topicStoreDaoImpl")
public class TopicStoreDaoImpl implements TopicStoreDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "topicDaoImpl")
	private TopicDaoImpl topicDaoImpl;
	@Resource(name = "userDaoImpl")
	private UserDaoImpl userDaoImpl;

	@Override
	public void save(TopicStore topicStore) {
		String sql = "insert into topic_stow values(?,?)";
		jdbcTemplate.update(sql, topicStore.getUser().getId(), topicStore.getTopic().getId());

	}

	@Override
	public void delete(Long topicId, Long userId) {
		String sql = "delete from topic_stow where user_id=? and topic_id=?";
		jdbcTemplate.update(sql, userId, topicId);

	}

	@Override
	public List<TopicStore> getTopicStoreByUserId(Long id) {
		String sql = "select * from topic_stow where user_id=?";
		List<TopicStore> list = jdbcTemplate.query(sql, new RowMapper<TopicStore>() {

			@Override
			public TopicStore mapRow(ResultSet rs, int arg1) throws SQLException {
				TopicStore topicStore = new TopicStore();
				topicStore.setTopic(topicDaoImpl.getById(rs.getLong("topic_id")));
				topicStore.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				return topicStore;
			}
		}, id);
		return list;
	}

	@Override
	public List<TopicStore> getAll() {
		String sql = "select * from topic_stow";
		jdbcTemplate.query(sql, new RowMapper<TopicStore>() {

			@Override
			public TopicStore mapRow(ResultSet rs, int arg1) throws SQLException {
				TopicStore topicStore = new TopicStore();
				topicStore.setTopic(topicDaoImpl.getById(rs.getLong("topic_id")));
				topicStore.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				return topicStore;
			}
		});
		return null;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from topic_stow";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void clearUserTopic(Long userId) {
		String sql = "delete from topic_stow where user_id=?";
		jdbcTemplate.update(sql, userId);

	}

	@Override
	public void clearTopicUser(Long topicId) {
		String sql = "delete from topic_stow where topic_id=?";
		jdbcTemplate.update(sql, topicId);

	}

}
