package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.CommentDao;
import main.java.com.example.domain.Comment;

/**
 * ������ΪComment�������ɾ�Ĳ�����ʵ��
 * 
 * @author Lenovo
 *
 */

@Repository("commentDaoImpl")
public class CommentDaoImpl implements CommentDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTample;
	@Resource(name = "topicDaoImpl")
	private TopicDaoImpl topicDaoImpl;

	@Override
	// ����¼�洢��comment���в���
	public void save(Comment comment) {
		String sql = "insert into comment values(?,?,?,?)";
		jdbcTample.update(sql, comment.getTopic().getId(), comment.getNum(), comment.getContent(),
				comment.getFormorNum());
	}

	@Override
	// ͨ������һ��Comment����������comment���м�¼�Ĳ���
	public void update(Comment comment) {
		String sql = "update comment set num=?,content=?,formor_num=? where id=?";
		jdbcTample.update(sql, comment.getNum(), comment.getContent(), comment.getFormorNum(),
				comment.getTopic().getId());
	}

	@Override
	// ͨ������һ����¼�ı����ɾ��comment���м�¼�Ĳ���
	public void delete(Long num) {
		String sql = "delete from user where num=?";
		jdbcTample.update(sql, num);
	}

	@Override
	// ͨ������һ����¼�ı��������comment���м�¼�Ĳ���
	public Comment getByNum(Integer num) {
		String sql = "select * from comment where num =?";
		Comment comment = jdbcTample.queryForObject(sql, new RowMapper<Comment>() {

			@Override
			public Comment mapRow(ResultSet rs, int arg1) throws SQLException {
				Comment comment = new Comment();
				comment.setTopic(topicDaoImpl.getById(rs.getLong("id")));
				comment.setContent(rs.getString("content"));
				comment.setFormorNum(rs.getInt("formor_num"));
				comment.setNum(rs.getInt("num"));
				return comment;
			}
		}, num);
		return comment;
	}

	@Override
	// ����comment�������м�¼�Ĳ���
	public List<Comment> getAll() {
		String sql = "select * from comment";
		List<Comment> list = jdbcTample.query(sql, new RowMapper<Comment>() {

			@Override
			public Comment mapRow(ResultSet rs, int arg1) throws SQLException {
				Comment comment = new Comment();
				comment.setTopic(topicDaoImpl.getById(rs.getLong("id")));
				comment.setContent(rs.getString("content"));
				comment.setFormorNum(rs.getInt("formor_num"));
				comment.setNum(rs.getInt("num"));
				return comment;
			}
		});
		return list;
	}

	@Override
	// ����comment�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from comment";
		Integer count = jdbcTample.queryForObject(sql, Integer.class);
		return count;
	}

}
