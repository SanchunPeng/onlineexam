package cn.zjlg.onlineexam.student.domain;

public class RowData {
	private String uid;
	private String loginname;
	private String loginpass;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	@Override
	public String toString() {
		return "RowData [uid=" + uid + ", loginname=" + loginname
				+ ", loginpass=" + loginpass + "]";
	}
	public RowData(String uid, String loginname, String loginpass) {
		this.uid = uid;
		this.loginname = loginname;
		this.loginpass = loginpass;
	}
	public RowData() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
