package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Solution;

public interface SolutionDao {
	 void save(Solution solution);
	 void update(Solution solution);
	 void delete(Long id);
	 Solution getById(Long id);
	 List<Solution> getAll();
	 int getTotalCount();
}
