package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Language;

public interface LanguageDao {
	 void save(Language language);
	 void update(Language language);
	 void delete(Long id);
	 Language getById(Long id);
	 List<Language> getAll();
	 int getTotalCount();
}
