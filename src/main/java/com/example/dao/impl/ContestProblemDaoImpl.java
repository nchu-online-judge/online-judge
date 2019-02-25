package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.ContestProblemDao;
import main.java.com.example.domain.ContestProblem;
/**
 * ������Ϊcontest_problem�������ɾ�Ĳ�����ʵ��
 * @author Lenovo
 *
 */
@Repository("contestProblemDaoImpl")
public class ContestProblemDaoImpl implements ContestProblemDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name="contestDaoImpl")
	private ContestDaoImpl contestDaoImpl;
	@Resource(name="problemDaoImpl")
	private ProblemDaoImpl problemDaoImpl;
	@Override
	//����¼�洢��contest_problem���в���
	public void save(ContestProblem contestProblem) {
		String sql = "insert into contest_problem values(?,?,?,?)";
		jdbcTemplate.update(sql, contestProblem.getContest().getId(),contestProblem.getProblem().getId(),contestProblem.getTitle(),contestProblem.getNum());

	}

	@Override
	//ͨ������һ��ContestProblem����������contest_problem���м�¼�Ĳ���
	public void update(ContestProblem contestProblem) {
		String sql ="update contest_problem set title=?,num=? where contest_id=?,problem_id=?";
		jdbcTemplate.update(sql,contestProblem.getTitle(),contestProblem.getNum(), contestProblem.getContest().getId(),contestProblem.getProblem().getId());

	}

	@Override
	//ͨ������һ��ContestProblem������ɾ��contest_problem���м�¼�Ĳ���
	public void delete(ContestProblem contestProblem) {
		String sql ="delete from contest_problem where problem_id=? and contest_id=?";
		jdbcTemplate.update(sql,contestProblem.getProblem().getId(),contestProblem.getContest().getId());

	}

	@Override
	//ͨ�������¼��contest_id������contest_problem����������ͬ��������Ŀ�ļ�¼����
	public List<ContestProblem> getContestProblemByContestId(Long contestId) {
		String sql = "select * from contest_problem where contest_id=?";
		List<ContestProblem> list = jdbcTemplate.query(sql, new RowMapper<ContestProblem>(){

			@Override
			public ContestProblem mapRow(ResultSet rs, int arg1) throws SQLException {
				ContestProblem contestProblem = new ContestProblem();
				contestProblem.setContest(contestDaoImpl.getById(rs.getLong("contest_id")));
				contestProblem.setProblem(problemDaoImpl.getById(rs.getLong("problem_id")));
				contestProblem.setNum(rs.getInt("num"));
				contestProblem.setTitle(rs.getString("title"));
				return contestProblem;
			}}, contestId);
		return list;
	}

	@Override
	//����contest_problem�������м�¼�Ĳ���
	public List<ContestProblem> getAll() {
		String sql = "select * from contest_problem ";
		List<ContestProblem> list = jdbcTemplate.query(sql, new RowMapper<ContestProblem>(){

			@Override
			public ContestProblem mapRow(ResultSet rs, int arg1) throws SQLException {
				ContestProblem contestProblem = new ContestProblem();
				contestProblem.setContest(contestDaoImpl.getById(rs.getLong("contest_id")));
				contestProblem.setProblem(problemDaoImpl.getById(rs.getLong("problem_id")));
				contestProblem.setNum(rs.getInt("num"));
				contestProblem.setTitle(rs.getString("title"));
				return contestProblem;
			}});
		return list;
	}

	@Override
	//����contest�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from contest_problem";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	

}
