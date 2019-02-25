package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.ProblemDao;
import main.java.com.example.domain.Problem;

/**
 * ������Ϊpermission�������,ɾ,��,�������ʵ��
 * 
 * @author Lenovo
 *
 */
@Repository("problemDaoImpl")
public class ProblemDaoImpl implements ProblemDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// ����¼�洢��problem���в���
	public void save(Problem problem) {
		String sql = "insert into problem values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, problem.getId(), problem.getTitle(), problem.getDescription(),
				problem.getInputDescription(), problem.getOutputDescription(), problem.getInputSample(),
				problem.getOutputSample(), problem.getHint(), problem.getInputData(), problem.getOutData(),
				problem.getSource(), problem.getCreatTime(), problem.getDefunct(), problem.getAcceptedTimes(),
				problem.getSubmitTimes(), problem.getTimeLimitC(), problem.getMemoryLimitC(), problem.getTimeLimit(),
				problem.getMemoryLimit());
	}

	@Override
	// ͨ������һ��Problem����������problem���м�¼�Ĳ���
	public void update(Problem problem) {
		String sql = "update problem set title=?,description=?,input_description=?,output_description=?,input_sample=?,output_sample=?,hint=?,input_data=?,output_data=?,source=?,create_time=?,defunct=?,accepted=?,submit=?,time_limit_c=?,memory_limmit_c=?,time_limit_o=?,memory_limmit_o=? where id=?";
		jdbcTemplate.update(sql, problem.getTitle(), problem.getDescription(), problem.getInputDescription(),
				problem.getOutputDescription(), problem.getInputSample(), problem.getOutputSample(), problem.getHint(),
				problem.getInputData(), problem.getOutData(), problem.getSource(), problem.getCreatTime(),
				problem.getDefunct(), problem.getAcceptedTimes(), problem.getSubmitTimes(), problem.getTimeLimitC(),
				problem.getMemoryLimitC(), problem.getTimeLimit(), problem.getMemoryLimit(), problem.getId());

	}

	@Override
	// ͨ������id��ɾ��problem���м�¼�Ĳ���
	public void delete(Long id) {
		String sql = "delete from problem where id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// ͨ������id������problem���м�¼�Ĳ���
	public Problem getById(Long id) {
		String sql = "select * from problem where id=?";
		Problem problem = jdbcTemplate.queryForObject(sql, new RowMapper<Problem>() {

			@Override
			public Problem mapRow(ResultSet rs, int arg1) throws SQLException {
				Problem problem = new Problem();
				problem.setId(rs.getLong("id"));
				problem.setTitle(rs.getString("title"));
				problem.setDescription(rs.getString("description"));
				problem.setInputDescription(rs.getString("input_description"));
				problem.setOutputDescription(rs.getString("output_description"));
				problem.setInputSample(rs.getString("input_sample"));
				problem.setOutputSample(rs.getString("output_sample"));
				problem.setHint(rs.getString("hint"));
				problem.setInputData(rs.getString("input_data"));
				problem.setOutData(rs.getString("output_data"));
				problem.setSource(rs.getString("source"));
				problem.setCreatTime(rs.getTimestamp("create_time"));
				problem.setDefunct(rs.getShort("defunct"));
				problem.setAcceptedTimes(rs.getInt("accepted"));
				problem.setSubmitTimes(rs.getInt("submit"));
				problem.setTimeLimitC(rs.getInt("time_limit_c"));
				problem.setMemoryLimitC(rs.getInt("memory_limmit_c"));
				problem.setTimeLimit(rs.getInt("time_limit_o"));
				problem.setMemoryLimit(rs.getInt("memory_limmit_o"));
				return problem;
			}
		}, id);
		return problem;
	}

	@Override
	// ����problem�������м�¼�Ĳ���
	public List<Problem> getAll() {
		String sql = "select * from problem";
		List<Problem> list = jdbcTemplate.query(sql, new RowMapper<Problem>() {

			@Override
			public Problem mapRow(ResultSet rs, int arg1) throws SQLException {
				Problem problem = new Problem();
				problem.setId(rs.getLong("id"));
				problem.setTitle(rs.getString("title"));
				problem.setDescription(rs.getString("description"));
				problem.setInputDescription(rs.getString("input_description"));
				problem.setOutputDescription(rs.getString("output_description"));
				problem.setInputSample(rs.getString("input_sample"));
				problem.setOutputSample(rs.getString("output_sample"));
				problem.setHint(rs.getString("hint"));
				problem.setInputData(rs.getString("input_data"));
				problem.setOutData(rs.getString("output_data"));
				problem.setSource(rs.getString("source"));
				problem.setCreatTime(rs.getTimestamp("create_time"));
				problem.setDefunct(rs.getShort("defunct"));
				problem.setAcceptedTimes(rs.getInt("accepted"));
				problem.setSubmitTimes(rs.getInt("submit"));
				problem.setTimeLimitC(rs.getInt("time_limit_c"));
				problem.setMemoryLimitC(rs.getInt("memory_limmit_c"));
				problem.setTimeLimit(rs.getInt("time_limit_o"));
				problem.setMemoryLimit(rs.getInt("memory_limmit_o"));
				return problem;
			}
		});
		return list;
	}

	@Override
	// ����problem�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from problem";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
