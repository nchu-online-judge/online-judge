package main.java.com.example.domain;
/**
 * language(´ğÌâÓïÑÔ)µÄjavaBean
 * @author Lenovo
 *
 */
public class Language {

	private int id;
	private String name;
	
	
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Language(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + "]";
	}
	
	
}
