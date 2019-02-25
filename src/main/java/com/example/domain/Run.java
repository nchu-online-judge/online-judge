package main.java.com.example.domain;
/**
 * run(程序运行结果)的javaBean
 * @author Lenovo
 *
 */
public class Run {

	private long id;
	private int runtime;
	private int runMemory;
	private String error;
	
	
	public Run() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Run(long id, int runtime, int runMemory, String error) {
		super();
		this.id = id;
		this.runtime = runtime;
		this.runMemory = runMemory;
		this.error = error;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getRunMemory() {
		return runMemory;
	}
	public void setRunMemory(int runMemory) {
		this.runMemory = runMemory;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "Run [id=" + id + ", runtime=" + runtime + ", runMemory=" + runMemory + ", error=" + error + "]";
	}
	
	
}
