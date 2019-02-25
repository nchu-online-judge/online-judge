package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.SystemLog;

public interface SystemLogDao {
	 void save(SystemLog systemLog);
	 void delete(Long id);
	 SystemLog getById(Long id);
	 List<SystemLog> getAll();
	 int getTotalCount();
}
