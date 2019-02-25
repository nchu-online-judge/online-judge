package main.java.com.example.domain;
/**
 * topic(Ìù×Ó)µÄjavaBean
 * @author Lenovo
 *
 */
import java.sql.Timestamp;

public class Topic {

	private long id;
	private Problem problem;
	private String title;
	private User user;
	private int status;
	private String content;
	private boolean defunct;
	private Timestamp creatTime;
	
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Topic(long id, Problem problem, String title, User user, int status, String content, boolean defunct,
			Timestamp creatTime) {
		super();
		this.id = id;
		this.problem = problem;
		this.title = title;
		this.user = user;
		this.status = status;
		this.content = content;
		this.defunct = defunct;
		this.creatTime = creatTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Problem getProblem() {
		return problem;
	}
	public void setProblem(Problem problem) {
		this.problem = problem;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isDefunct() {
		return defunct;
	}
	public void setDefunct(boolean defunct) {
		this.defunct = defunct;
	}
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	
	@Override
	public String toString() {
		return "Topic [id=" + id + ", problem=" + problem + ", title=" + title + ", user=" + user + ", status=" + status
				+ ", content=" + content + ", defunct=" + defunct + ", creatTime=" + creatTime + "]";
	}
	
}
