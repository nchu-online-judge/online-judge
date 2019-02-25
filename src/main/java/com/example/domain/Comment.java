package main.java.com.example.domain;
/**
 * comment(ÆÀÂÛ±í)µÄjavaBean
 * @author Lenovo
 *
 */
public class Comment {

	private Topic topic;
	private int num;
	private int formorNum;
	private String content;
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Topic topic, int num, int formorNum, String content) {
		super();
		this.topic = topic;
		this.num = num;
		this.formorNum = formorNum;
		this.content = content;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getFormorNum() {
		return formorNum;
	}
	public void setFormorNum(int formorNum) {
		this.formorNum = formorNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Comment [topic=" + topic + ", num=" + num + ", formorNum=" + formorNum + ", content=" + content + "]";
	}

	
}
