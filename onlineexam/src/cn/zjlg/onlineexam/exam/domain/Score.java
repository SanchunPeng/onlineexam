package cn.zjlg.onlineexam.exam.domain;

public class Score {
	private int id;
	private String studentName;
	private String score;
	private String selectScore;
	private String judge;
	private String cloze;
	private String program;
	
	
	public Score(int id, String studentName, String score, String selectScore,
			String judge, String cloze, String program) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.score = score;
		this.selectScore = selectScore;
		this.judge = judge;
		this.cloze = cloze;
		this.program = program;
	}

	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public String getCloze() {
		return cloze;
	}
	public void setCloze(String cloze) {
		this.cloze = cloze;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Score(int id, String studentName, String score) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", studentName=" + studentName + ", score="
				+ score + ", select=" + selectScore + ", judge=" + judge
				+ ", cloze=" + cloze + ", program=" + program + "]";
	}
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSelectScore() {
		return selectScore;
	}
	public void setSelectScore(String selectScore) {
		this.selectScore = selectScore;
	}
	
}
