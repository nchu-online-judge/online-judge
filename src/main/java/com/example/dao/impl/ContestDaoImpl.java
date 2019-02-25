package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.ContestDao;
import main.java.com.example.domain.Contest;

/**
 * ������Ϊcontest�������ɾ�Ĳ�����ʵ��
 * 
 * @author Lenovo
 *
 */
@Repository("contestDaoImpl")
public class ContestDaoImpl implements ContestDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTample;
	@Resource(name = "userDaoImpl")
	private UserDaoImpl userDaoImpl;

	@Override
	// ����¼�洢��contest���в���
	public void save(Contest contest) {
		String sql = "insert into contest values(?,?,?,?,?,?,?,?,?)";
		jdbcTample.update(sql, contest.getId(), contest.getTitle(), contest.getDescription(), contest.getStartTime(),
				contest.getEndTime(), contest.getUser().getId(), contest.getType(), contest.getLanguage(),
				contest.getDdefunct());
	}

	@Override
	// ͨ������һ��Contest����������contest���м�¼�Ĳ���
	public void update(Contest contest) {
		String sql = "update contest set title=?,description=?,start_time=?,end_time=?,user_id=?,private=?,landmark=?,defunct=? where id=?";
		jdbcTample.update(sql, contest.getTitle(), contest.getDescription(), contest.getStartTime(),
				contest.getEndTime(), contest.getUser().getId(), contest.getType(), contest.getLanguage(),
				contest.getDdefunct(), contest.getId());

	}

	@Override
	// ͨ������һ����¼��id��ɾ��contest���м�¼�Ĳ���
	public void delete(Long id) {
		String sql = "delete from contest where id = ?";
		jdbcTample.update(sql, id);
	}

	@Override
	// ͨ������һ����¼��id������contest���м�¼�Ĳ���
	public Contest getById(Long id) {
		String sql = "select * from contest where id =?";
		Contest contest = jdbcTample.queryForObject(sql, new RowMapper<Contest>() {

			@Override
			public Contest mapRow(ResultSet rs, int arg1) throws SQLException {
				Contest contest = new Contest();
				contest.setId(rs.getLong("id"));
				contest.setDescription(rs.getString("description"));
				contest.setTitle(rs.getString("title"));
				contest.setStartTime(rs.getTimestamp("start_time"));
				contest.setEndTime(rs.getTimestamp("end_time"));
				contest.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				contest.setType(rs.getInt("private"));
				contest.setLanguage(rs.getInt("landmark"));
				contest.setDefunct(rs.getBoolean("defunct"));
				return contest;
			}
		}, id);
		return contest;
	}

	@Override
	// ����contest�������м�¼�Ĳ���
	public List<Contest> getAll() {
		String sql = "select * from contest";
		List<Contest> list = jdbcTample.query(sql, new RowMapper<Contest>() {

			@Override
			public Contest mapRow(ResultSet rs, int arg1) throws SQLException {
				Contest contest = new Contest();
				contest.setId(rs.getLong("id"));
				contest.setDescription(rs.getString("description"));
				contest.setTitle(rs.getString("title"));
				contest.setStartTime(rs.getTimestamp("start_time"));
				contest.setEndTime(rs.getTimestamp("end_time"));
				contest.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				contest.setType(rs.getInt("private"));
				contest.setLanguage(rs.getInt("landmark"));
				contest.setDefunct(rs.getBoolean("defunct"));
				return contest;
			}
		});
		return list;
	}

	@Override
	// ����contest�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from contest";
		return jdbcTample.queryForObject(sql, Integer.class);
	}

}
