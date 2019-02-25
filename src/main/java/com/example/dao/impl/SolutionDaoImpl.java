package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.SolutionDao;
import main.java.com.example.domain.Solution;

/**
 * 该类作为solution表关于增,改,删,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("solutionDaoImpl")
public class SolutionDaoImpl implements SolutionDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name = "problemDaoImpl")
	private ProblemDaoImpl problemDaoImpl;
	@Resource(name = "languageDaoImpl")
	private LanguageDaoImpl languageDaoImpl;
	@Resource(name = "resultDaoImpl")
	private ResultDaoImpl resultDaoImpl;
	@Resource(name = "contestDaoImpl")
	private ContestDaoImpl contestDaoImpl;
	@Resource(name = "userDaoImpl")
	private UserDaoImpl userDaoImpl;

	@Override
	// 将记录存储到solution表中操作
	public void save(Solution solution) {
		String sql = "insert into solution values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, solution.getId(), solution.getProblem().getId(), solution.getUser().getId(),
				solution.getSubmitTime(), solution.getLanguage(), solution.getResult(), solution.getContest().getId(),
				solution.getCodeLength(), solution.getCode(), solution.getPassRate());

	}

	@Override
	public void update(Solution solution) {
		String sql = "update solution set in_date=?,language=?,result=?,code_length=?,code=?,pass_rate=? where id=? and problem_id=? and user_id=?";
		jdbcTemplate.update(sql, solution.getSubmitTime(), solution.getLanguage(), solution.getResult(),
				solution.getCodeLength(), solution.getCode(), solution.getPassRate(), solution.getId(),
				solution.getProblem().getId(), solution.getUser().getId());

	}

	@Override
	public void delete(Long id) {
		String sql = "delete from solution where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	public Solution getById(Long id) {
		String sql = "select * from solution where id=?";
		Solution solution = jdbcTemplate.queryForObject(sql, new RowMapper<Solution>() {

			@Override
			public Solution mapRow(ResultSet rs, int arg1) throws SQLException {
				Solution solution = new Solution();
				solution.setId(rs.getLong("id"));
				solution.setProblem(problemDaoImpl.getById(rs.getLong("problem_id")));
				solution.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				solution.setSubmitTime(rs.getTimestamp("in_date"));
				solution.setLanguage(languageDaoImpl.getById(rs.getLong("language")));
				solution.setResult(resultDaoImpl.getById(rs.getLong("result")));
				solution.setContest(contestDaoImpl.getById(rs.getLong("contest_id")));
				solution.setCodeLength(rs.getInt("code_length"));
				solution.setCode(rs.getString("code"));
				solution.setPassRate(rs.getBigDecimal("pass_rate"));
				return solution;
			}
		}, id);
		return solution;
	}

	@Override
	public List<Solution> getAll() {
		String sql = "select * from solution";
		List<Solution> list = jdbcTemplate.query(sql, new RowMapper<Solution>() {

			@Override
			public Solution mapRow(ResultSet rs, int arg1) throws SQLException {
				Solution solution = new Solution();
				solution.setId(rs.getLong("id"));
				solution.setProblem(problemDaoImpl.getById(rs.getLong("problem_id")));
				solution.setUser(userDaoImpl.getById(rs.getLong("user_id")));
				solution.setSubmitTime(rs.getTimestamp("in_date"));
				solution.setLanguage(languageDaoImpl.getById(rs.getLong("language")));
				solution.setResult(resultDaoImpl.getById(rs.getLong("result")));
				solution.setContest(contestDaoImpl.getById(rs.getLong("contest_id")));
				solution.setCodeLength(rs.getInt("code_length"));
				solution.setCode(rs.getString("code"));
				solution.setPassRate(rs.getBigDecimal("pass_rate"));
				return solution;
			}
		});
		return list;
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from solution";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
