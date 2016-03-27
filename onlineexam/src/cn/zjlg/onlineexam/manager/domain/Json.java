package cn.zjlg.onlineexam.manager.domain;

import cn.zjlg.onlineexam.student.domain.Student;

public class Json {
	private boolean success;
	private String msg;
	private Student student;
	private boolean successExam;
	
	public Json(boolean success, String msg, Student student,
			boolean successExam) {
		super();
		this.success = success;
		this.msg = msg;
		this.student = student;
		this.successExam = successExam;
	}

	public Json() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean getSuccessExam() {
		return successExam;
	}

	public void setSuccessExam(boolean successExam) {
		this.successExam = successExam;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "{\"success\":"+ success +",\"successExam\":"+successExam+",\"msg\":\" "+ msg +"\"}";
	}

	

}
