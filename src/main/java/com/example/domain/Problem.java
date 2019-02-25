package main.java.com.example.domain;
/**
 * problem(ÌâÄ¿)µÄjavaBean
 * @author Lenovo
 *
 */
import java.sql.Timestamp;

public class Problem {

	private long id;
	private String title;
	private String description;
	private String inputDescription;
	private String outputDescription;
	private String inputSample;
	private String outputSample;
	private String hint;
	private String source;
	private Timestamp creatTime;
	private short defunct;
	private int submitTimes;
	private int acceptedTimes;
	private int timeLimitC;
	private int memoryLimitC;
	private int timeLimit;
	private int memoryLimit;
	private String inputData;
	private String outData;
	
	
	public Problem(long id, String title, String description, String inputDescription, String outputDescription,
			String inputSample, String outputSample, String hint, String source, Timestamp creatTime, short defunct,
			int submitTimes, int acceptedTimes, int timeLimitC, int memoryLimitC, int timeLimit, int memoryLimit,
			String inputData, String outData) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.inputDescription = inputDescription;
		this.outputDescription = outputDescription;
		this.inputSample = inputSample;
		this.outputSample = outputSample;
		this.hint = hint;
		this.source = source;
		this.creatTime = creatTime;
		this.defunct = defunct;
		this.submitTimes = submitTimes;
		this.acceptedTimes = acceptedTimes;
		this.timeLimitC = timeLimitC;
		this.memoryLimitC = memoryLimitC;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.inputData = inputData;
		this.outData = outData;
	}
	public Problem() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getInputDescription() {
		return inputDescription;
	}
	public void setInputDescription(String inputDescription) {
		this.inputDescription = inputDescription;
	}
	public String getOutputDescription() {
		return outputDescription;
	}
	public void setOutputDescription(String outputDescription) {
		this.outputDescription = outputDescription;
	}
	public String getInputSample() {
		return inputSample;
	}
	public void setInputSample(String inputSample) {
		this.inputSample = inputSample;
	}
	public String getOutputSample() {
		return outputSample;
	}
	public void setOutputSample(String outputSample) {
		this.outputSample = outputSample;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	public short getDefunct() {
		return defunct;
	}
	public void setDefunct(short defunct) {
		this.defunct = defunct;
	}
	public int getSubmitTimes() {
		return submitTimes;
	}
	public void setSubmitTimes(int submitTimes) {
		this.submitTimes = submitTimes;
	}
	public int getAcceptedTimes() {
		return acceptedTimes;
	}
	public void setAcceptedTimes(int acceptedTimes) {
		this.acceptedTimes = acceptedTimes;
	}
	public int getTimeLimitC() {
		return timeLimitC;
	}
	public void setTimeLimitC(int timeLimitC) {
		this.timeLimitC = timeLimitC;
	}
	public int getMemoryLimitC() {
		return memoryLimitC;
	}
	public void setMemoryLimitC(int memoryLimitC) {
		this.memoryLimitC = memoryLimitC;
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public int getMemoryLimit() {
		return memoryLimit;
	}
	public void setMemoryLimit(int memoryLimit) {
		this.memoryLimit = memoryLimit;
	}
	public String getInputData() {
		return inputData;
	}
	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
	public String getOutData() {
		return outData;
	}
	public void setOutData(String outData) {
		this.outData = outData;
	}
	
	@Override
	public String toString() {
		return "Problem [id=" + id + ", title=" + title + ", description=" + description + ", inputDescription="
				+ inputDescription + ", outputDescription=" + outputDescription + ", inputSample=" + inputSample
				+ ", outputSample=" + outputSample + ", hint=" + hint + ", source=" + source + ", creatTime="
				+ creatTime + ", defunct=" + defunct + ", submitTimes=" + submitTimes + ", acceptedTimes="
				+ acceptedTimes + ", timeLimitC=" + timeLimitC + ", memoryLimitC=" + memoryLimitC + ", timeLimit="
				+ timeLimit + ", memoryLimit=" + memoryLimit + ", inputData=" + inputData + ", outData=" + outData
				+ "]";
	}
	
	
}
