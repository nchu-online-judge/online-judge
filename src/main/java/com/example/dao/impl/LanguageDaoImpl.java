package main.java.com.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import main.java.com.example.dao.LanguageDao;
import main.java.com.example.domain.Language;

/**
 * 该类作为language表关于增,删,改,查操作的实现
 * 
 * @author Lenovo
 *
 */
@Repository("languageDaoImpl")
public class LanguageDaoImpl implements LanguageDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// 将记录存储到language表中操作
	public void save(Language language) {
		String sql = "insert into language values(?,?)";
		jdbcTemplate.update(sql, language.getId(), language.getName());
	}

	@Override
	// 通过传入一个Language对象来更改language表中记录的操作
	public void update(Language language) {
		String sql = "update language set name=? where id=?";
		jdbcTemplate.update(sql, language.getName(), language.getId());

	}

	@Override
	// 通过传入id来删除language表中记录的操作
	public void delete(Long id) {
		String sql = "delete from language where id =?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// 通过传入id来查找language表中记录的操作
	public Language getById(Long id) {
		String sql = "select * from language where id=?";
		Language language = jdbcTemplate.queryForObject(sql, new RowMapper<Language>() {

			@Override
			public Language mapRow(ResultSet rs, int arg1) throws SQLException {
				Language language = new Language();
				language.setId(rs.getInt("id"));
				language.setName(rs.getString("name"));
				return language;
			}
		}, id);
		return language;
	}

	@Override
	// 查找language表中所有记录的操作
	public List<Language> getAll() {
		String sql = "select * from language";
		List<Language> list = jdbcTemplate.query(sql, new RowMapper<Language>() {

			@Override
			public Language mapRow(ResultSet rs, int arg1) throws SQLException {
				Language language = new Language();
				language.setId(rs.getInt("id"));
				language.setName(rs.getString("name"));
				return language;
			}
		});
		return list;
	}

	@Override
	// 查找language表中所有记录的条数
	public int getTotalCount() {
		String sql = "select count(*) from language";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
