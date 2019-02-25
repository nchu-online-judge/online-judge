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
 * ������Ϊlanguage�������,ɾ,��,�������ʵ��
 * 
 * @author Lenovo
 *
 */
@Repository("languageDaoImpl")
public class LanguageDaoImpl implements LanguageDao {

	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	// ����¼�洢��language���в���
	public void save(Language language) {
		String sql = "insert into language values(?,?)";
		jdbcTemplate.update(sql, language.getId(), language.getName());
	}

	@Override
	// ͨ������һ��Language����������language���м�¼�Ĳ���
	public void update(Language language) {
		String sql = "update language set name=? where id=?";
		jdbcTemplate.update(sql, language.getName(), language.getId());

	}

	@Override
	// ͨ������id��ɾ��language���м�¼�Ĳ���
	public void delete(Long id) {
		String sql = "delete from language where id =?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	// ͨ������id������language���м�¼�Ĳ���
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
	// ����language�������м�¼�Ĳ���
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
	// ����language�������м�¼������
	public int getTotalCount() {
		String sql = "select count(*) from language";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
