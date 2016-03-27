package cn.zjlg.onlineexam.question.domain;

public class Judge {
	private int id;
	private String question;
	private String answer;
	private String chapter;
	private String grade;
	private int point;
	private boolean selected;
	
	public Judge(int id, String question, boolean selected) {
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
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
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
		return "Judge [id=" + id + ", question=" + question + ", answer="
				+ answer + ", chpater=" + chapter + ", grade=" + grade
				+ ", point=" + point + "]";
	}
	public Judge(int id, String question, String answer, String grade,
			int point) {
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.grade = grade;
		this.point = point;
	}
	public Judge(int id, String question, String answer, String chapter,
			String grade, int point) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.chapter = chapter;
		this.grade = grade;
		this.point = point;
	}
	public Judge(String question, String answer, String chapter, String grade,
			int point) {
		super();
		this.question = question;
		this.answer = answer;
		this.chapter = chapter;
		this.grade = grade;
		this.point = point;
	}
	public Judge(String question, String answer, String grade, int point) {
		this.question = question;
		this.answer = answer;
		this.grade = grade;
		this.point = point;
	}
	public Judge() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
