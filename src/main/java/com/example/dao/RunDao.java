package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Run;

public interface RunDao {
	 void save(Run run);
	 void delete(Long id);
	 Run getById(Long id);
	 List<Run> getAll();
	 int getTotalCount();
}
