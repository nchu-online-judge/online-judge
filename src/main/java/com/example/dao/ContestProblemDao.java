package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.ContestProblem;

public interface ContestProblemDao {
	 void save(ContestProblem contestProblem);
	 void update(ContestProblem contestProblem);
	 void delete(ContestProblem contestProblem);
	 List<ContestProblem> getContestProblemByContestId(Long contestId);
	 List<ContestProblem> getAll();
	 int getTotalCount();
}
