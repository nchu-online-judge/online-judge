package main.java.com.example.domain;

import java.sql.Timestamp;
/**
 * contest(±ÈÈü)µÄjavaBean
 * @author Lenovo
 *
 */
public class Contest {

	private long id;
	private String title;
	private String description;
	private Timestamp endTime;
	private Timestamp startTime;
	private User user;
	private int type;
	private int language;
	private boolean defunct;
	
	public Contest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contest(long id, String title, String description, Timestamp endTime, Timestamp startTime, User user,
			int type, int language, boolean defunct) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.endTime = endTime;
		this.startTime = startTime;
		this.user = user;
		this.type = type;
		this.language = language;
		this.defunct = defunct;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLanguage() {
		return language;
	}
	public void setLanguage(int language) {
		this.language = language;
	}
	public boolean getDdefunct() {
		return defunct;
	}
	public void setDefunct(boolean defunct) {
		this.defunct = defunct;
	}
	
	@Override
	public String toString() {
		return "Contest [id=" + id + ", title=" + title + ", description=" + description + ", endTime=" + endTime
				+ ", startTime=" + startTime + ", user=" + user + ", type=" + type + ", language=" + language
				+ ", defunct=" + defunct + "]";
	}
	
}
