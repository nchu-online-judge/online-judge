package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Result;

public interface ResultDao {
	 void save(Result result);
	 void update(Result result);
	 void delete(Long id);
	 Result getById(Long id);
	 List<Result> getAll();
	 int getTotalCount();
}
