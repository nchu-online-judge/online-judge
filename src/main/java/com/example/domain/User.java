package main.java.com.example.domain;

/**
 * user(ÓÃ»§)µÄjavaBean
 * @author Lenovo
 *
 */
import java.sql.Timestamp;

public class User {

	private long id;
	private String name;
	private String password;
	private String phoneNumber;
	private String email;
	private String school;
	private String headImage;
	private int solveNumber;
	private int submitNumber;
	private int submitTimes;
	private int success;
	private int fail;
	private boolean status;
	private Timestamp creatTime;

	public User() {
	}

	public User(long id, String name, String password, String phoneNumber, String email, String school,
			String headImage, int solveNumber, int submitNumber, int submitTimes, int success, int fail, boolean status,
			Timestamp creatTime) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.school = school;
		this.headImage = headImage;
		this.solveNumber = solveNumber;
		this.submitNumber = submitNumber;
		this.submitTimes = submitTimes;
		this.success = success;
		this.fail = fail;
		this.status = status;
		this.creatTime = creatTime;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public int getSolveNumber() {
		return solveNumber;
	}

	public void setSolveNumber(int solveNumber) {
		this.solveNumber = solveNumber;
	}

	public int getSubmitNumber() {
		return submitNumber;
	}

	public void setSubmitNumber(int submitNumber) {
		this.submitNumber = submitNumber;
	}

	public int getSubmitTimes() {
		return submitTimes;
	}

	public void setSubmitTimes(int submitTimes) {
		this.submitTimes = submitTimes;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Timestamp getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", school=" + school + ", headImage=" + headImage + ", solveNumber="
				+ solveNumber + ", submitNumber=" + submitNumber + ", submitTimes=" + submitTimes + ", success="
				+ success + ", fail=" + fail + ", status=" + status + ", creatTime=" + creatTime + "]";
	}

}
