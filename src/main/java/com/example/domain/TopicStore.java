package main.java.com.example.domain;
/**
 * topic_stow(Ìù×ÓÊÕ²Ø)µÄjavaBean
 * @author Lenovo
 *
 */
public class TopicStore {

	private User user;
	private Topic topic;
	
	
	public TopicStore() {
		
	}
	public TopicStore(User user, Topic topic) {
		super();
		this.user = user;
		this.topic = topic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	@Override
	public String toString() {
		return "TopicStore [user=" + user + ", topic=" + topic + "]";
	}
	
	
}
