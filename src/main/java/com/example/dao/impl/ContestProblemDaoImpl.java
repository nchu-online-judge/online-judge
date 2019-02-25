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
 * 该类作为contest_problem表关于增删改操作的实现
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
	//将记录存储到contest_problem表中操作
	public void save(ContestProblem contestProblem) {
		String sql = "insert into contest_problem values(?,?,?,?)";
		jdbcTemplate.update(sql, contestProblem.getContest().getId(),contestProblem.getProblem().getId(),contestProblem.getTitle(),contestProblem.getNum());

	}

	@Override
	//通过传入一个ContestProblem对象来更改contest_problem表中记录的操作
	public void update(ContestProblem contestProblem) {
		String sql ="update contest_problem set title=?,num=? where contest_id=?,problem_id=?";
		jdbcTemplate.update(sql,contestProblem.getTitle(),contestProblem.getNum(), contestProblem.getContest().getId(),contestProblem.getProblem().getId());

	}

	@Override
	//通过传入一个ContestProblem对象来删除contest_problem表中记录的操作
	public void delete(ContestProblem contestProblem) {
		String sql ="delete from contest_problem where problem_id=? and contest_id=?";
		jdbcTemplate.update(sql,contestProblem.getProblem().getId(),contestProblem.getContest().getId());

	}

	@Override
	//通过传入记录的contest_id来查找contest_problem表中属于相同比赛的题目的记录操作
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
	//查找contest_problem表中所有记录的操作
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
	//查找contest表中所有记录的条数
	public int getTotalCount() {
		String sql = "select count(*) from contest_problem";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	

}
