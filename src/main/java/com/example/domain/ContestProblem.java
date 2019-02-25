package main.java.com.example.domain;
/**
 * contest_problem(比赛题目)的javaBean
 * @author Lenovo
 *
 */
public class ContestProblem {

	private Contest contest;
	private Problem problem;
	private String title;
	private int num;
	
	
	public ContestProblem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContestProblem(Contest contest, Problem problem, String title, int num) {
		super();
		this.contest = contest;
		this.problem = problem;
		this.title = title;
		this.num = num;
	}
	public Contest getContest() {
		return contest;
	}
	public void setContest(Contest contest) {
		this.contest = contest;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "ContestProblem [contest=" + contest + ", problem=" + problem + ", title=" + title + ", num=" + num
				+ "]";
	}
	
	
	
}
