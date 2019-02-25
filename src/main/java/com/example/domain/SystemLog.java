package main.java.com.example.domain;
/**
 * syslog(系统的日志 )的javaBean
 * @author Lenovo
 *
 */
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SystemLog {

	private long id;
	private String name;
	private String operation;
	private BigDecimal operationTime;
	private String method;
	private String params;
	private String ip;
	private Timestamp time;
	
	public SystemLog(long id, String name, String operation, BigDecimal operationTime, String method, String params,
			String ip, Timestamp time) {
		super();
		this.id = id;
		this.name = name;
		this.operation = operation;
		this.operationTime = operationTime;
		this.method = method;
		this.params = params;
		this.ip = ip;
		this.time = time;
	}
	public SystemLog() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public BigDecimal getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(BigDecimal operationTime) {
		this.operationTime = operationTime;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "SystemLog [id=" + id + ", name=" + name + ", operation=" + operation + ", operationTime="
				+ operationTime + ", method=" + method + ", params=" + params + ", ip=" + ip + ", time=" + time + "]";
	}
	
}
