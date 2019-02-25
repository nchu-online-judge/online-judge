package main.java.com.example.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.java.com.example.dao.impl.ProblemDaoImpl;
import main.java.com.example.dao.impl.TopicDaoImpl;
import main.java.com.example.dao.impl.TopicStoreDaoImpl;
import main.java.com.example.dao.impl.UserDaoImpl;
import main.java.com.example.dao.impl.UserRoleDaoImpl;
import main.java.com.example.domain.Problem;
import main.java.com.example.domain.Topic;
import main.java.com.example.domain.TopicStore;
import main.java.com.example.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	UserRoleDaoImpl userRoleDaoImpl;
	@Autowired
	ProblemDaoImpl problemDaoImpl;
	@Autowired
	TopicDaoImpl topicDaoImpl;
	@Autowired
	TopicStoreDaoImpl topicStoreDaoImpl;
	@Test
	public void fun() {
		long i = 10000;

//		 user = new UserDaoImpl().getById(i);
//		User user = userDaoImpl.getById(i);
//		user.setName("giuugui");
//		userDaoImpl.update(user);;
//		System.out.println(userDaoImpl.getById(i));
//		System.out.println(userDaoImpl.getAll());
//		sSystem.out.println(userRoleDaoImpl.getRoleByUserId(i));
		
//		Problem problem = problemDaoImpl.getById(i);
//		problem.setId(problem.getId()+1222);
//		problem.setTitle("sfs");
//		problemDaoImpl.update(problem);
/*		System.out.println(problem.toString());
		System.out.println(problemDaoImpl.getAll());
		System.err.println(problemDaoImpl.getTotalCount());*/

//		Topic topic = topicDaoImpl.getById(i);
		/*topic.setId(topic.getId()+4456);
		topicDaoImpl.save(topic);*/
//		topic.setTitle("cssf");
//		topicDaoImpl.delete(topic.getId());
//		System.out.println(topic.toString());
		long j = 469130;
//		topicStoreDaoImpl.delete(j,i);
		topicStoreDaoImpl.clearTopicUser(j);
		System.out.println(topicStoreDaoImpl.getTopicStoreByUserId(i)); 
	}
}
