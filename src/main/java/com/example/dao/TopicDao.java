package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Topic;

public interface TopicDao {
	 void save(Topic topic);
	 void update(Topic topic);
	 void delete(Long id);
	 Topic getById(Long id);
	 List<Topic> getAll();
	 int getTotalCount();
}
