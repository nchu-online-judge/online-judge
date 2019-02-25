package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.TopicStore;

public interface TopicStoreDao {
	 void save(TopicStore topicStore);
	 void delete(Long topicId,Long userId);
	 void clearUserTopic(Long userId);
	 void clearTopicUser(Long topicId);
	 List<TopicStore> getTopicStoreByUserId(Long id);
	 List<TopicStore> getAll();
	 int getTotalCount();
}
