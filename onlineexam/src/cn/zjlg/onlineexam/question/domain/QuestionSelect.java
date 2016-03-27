package cn.zjlg.onlineexam.question.domain;

public class QuestionSelect {
	private int id;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private String chapter;
	private boolean selected;
	
	public QuestionSelect(int id, String question, boolean selected) {
		super();
		this.id = id;
		this.question = question;
		this.selected = selected;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public QuestionSelect(String chapter) {
		super();
		this.chapter = chapter;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	private String grade;
	private int point;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "QuestionSelect [id=" + id + ", question=" + question
				+ ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", answer="
				+ answer + ", chapter=" + chapter + ", grade=" + grade
				+ ", point=" + point + "]";
	}
	public QuestionSelect(String question, String optionA, String optionB,
			String optionC, String optionD, String answer, String chapter,
			String grade, int point) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.chapter = chapter;
		this.grade = grade;
		this.point = point;
	}
	public QuestionSelect(String question, String optionA,
			String optionB, String optionC, String optionD, String answer,
			String grade, int point) {
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.grade = grade;
		this.point = point;
	}
	
	public QuestionSelect(int id, String question, String optionA,
			String optionB, String optionC, String optionD, String answer,
			String chapter, String grade, int point) {
		super();
		this.id = id;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.chapter = chapter;
		this.grade = grade;
		this.point = point;
	}
	public QuestionSelect(int id, String question, String answer, String grade,
			int point) {
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.grade = grade;
		this.point = point;
	}
	public QuestionSelect(int id, String question, String optionA,
			String optionB, String optionC, String optionD, String answer,
			String grade, int point) {
		super();
		this.id = id;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.grade = grade;
		this.point = point;
	}
	public QuestionSelect() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
