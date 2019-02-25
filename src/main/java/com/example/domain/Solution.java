package main.java.com.example.domain;
/**
 * solution(答题者的编写的代码)的javaBean
 * @author Lenovo
 *
 */
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Solution {

	private long id;
	private Problem problem;
	private User user;
	private Timestamp submitTime;
	private Language language;
	private Result result;
	private Contest contest;
	private int codeLength;
	private String code;
	private BigDecimal passRate;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
	}
	public int getCodeLength() {
		return codeLength;
	}
	public void setCodeLength(int codeLength) {
		this.codeLength = codeLength;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getPassRate() {
		return passRate;
	}
	public void setPassRate(BigDecimal passRate) {
		this.passRate = passRate;
	}
	
	public Solution() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Solution(long id, Problem problem, User user, Timestamp submitTime, Language language, Result result,
			Contest contest, int codeLength, String code, BigDecimal passRate) {
		super();
		this.id = id;
		this.problem = problem;
		this.user = user;
		this.submitTime = submitTime;
		this.language = language;
		this.result = result;
		this.contest = contest;
		this.codeLength = codeLength;
		this.code = code;
		this.passRate = passRate;
	}
	@Override
	public String toString() {
		return "Solution [id=" + id + ", problem=" + problem + ", user=" + user + ", submitTime=" + submitTime
				+ ", language=" + language + ", result=" + result + ", contest=" + contest + ", codeLength="
				+ codeLength + ", code=" + code + ", passRate=" + passRate + "]";
	}
	
	

}
