package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Problem;

public interface ProblemDao {
	 void save(Problem problem);
	 void update(Problem problem);
	 void delete(Long id);
	 Problem getById(Long id);
	 List<Problem> getAll();
	 int getTotalCount();
}
