package cn.zjlg.onlineexam.question.domain;

public class ProgramSubmit {
	private int id;
	private String studentName;
	private String question;
	private String studentAnswer;
	private int getScore;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	public int getGetScore() {
		return getScore;
	}
	public void setGetScore(int getScore) {
		this.getScore = getScore;
	}
	public ProgramSubmit(int id, String studentName, String question,
			String studentAnswer, int getScore) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.question = question;
		this.studentAnswer = studentAnswer;
		this.getScore = getScore;
	}
	public ProgramSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProgramSubmit [id=" + id + ", studentName=" + studentName
				+ ", question=" + question + ", studentAnswer=" + studentAnswer
				+ ", getScore=" + getScore + "]";
	}
	public ProgramSubmit(String studentName, String question,
			String studentAnswer, int getScore) {
		super();
		this.studentName = studentName;
		this.question = question;
		this.studentAnswer = studentAnswer;
		this.getScore = getScore;
	}
	

}
