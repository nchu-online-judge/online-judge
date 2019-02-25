package main.java.com.example.dao;

import java.util.List;

import main.java.com.example.domain.Comment;

public interface CommentDao {
	 void save(Comment comment);
	 void update(Comment comment);
	 void delete(Long id);
	 Comment getByNum(Integer num);
	 List<Comment> getAll();
	 int getTotalCount();
}
