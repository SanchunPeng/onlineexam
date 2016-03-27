package cn.zjlg.onlineexam.student.domain;

/**
 * 用户模块实体层
 * 
 * @author Administrator
 * 
 */
public class Student {
	// 对应数据库表
	private String uid;//主键
	private String loginname;
	private String loginpass;
	// 登录表单
	private String verifyCode;
	
	private int page;
	private int rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

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
		return "Student [uid=" + uid + ", loginname=" + loginname
				+ ", loginpass=" + loginpass + "]";
	}

	public Student(String uid, String loginname, String loginpass) {
		super();
		this.uid = uid;
		this.loginname = loginname;
		this.loginpass = loginpass;
	}

}
