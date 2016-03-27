package cn.zjlg.onlineexam.question.domain;

public class Made {
	private String type;
	private String idString;
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getType() {
		return type;
	}
	public Made(String type, String idString) {
		super();
		this.type = type;
		this.idString = idString;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Made() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
