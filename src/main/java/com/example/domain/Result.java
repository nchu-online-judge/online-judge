package main.java.com.example.domain;
/**
 * result(运行结果)的javaBean
 * @author Lenovo
 *
 */
public class Result {

	private long id;
	private String name;
	
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
		return "Result [id=" + id + ", name=" + name + "]";
	}
	
	
}
