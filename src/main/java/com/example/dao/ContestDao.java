package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Contest;

public interface ContestDao {
	 void save(Contest contest);
	 void update(Contest contest);
	 void delete(Long id);
	 Contest getById(Long id);
	 List<Contest> getAll();
	 int getTotalCount();
}
