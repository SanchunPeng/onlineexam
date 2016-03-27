package cn.zjlg.onlineexam.student.service;

import java.sql.SQLException;
import java.util.List;

import cn.zjlg.onlineexam.manager.domain.Manager;
import cn.zjlg.onlineexam.student.dao.StudentDao;
import cn.zjlg.onlineexam.student.domain.PageBean;
import cn.zjlg.onlineexam.student.domain.RowData;
import cn.zjlg.onlineexam.student.domain.Student;

/**
 * 用户模块的业务层
 * 
 * @author Administrator
 * 
 */
public class StudentService {
	private StudentDao studentDao = new StudentDao();

	/**
	 * 用户名校验
	 * 
	 * @param loginname
	 * @return
	 */
	public boolean ajaxValidateLoginname(String loginname) {
		try {
			return studentDao.ajaxValidateLoginname(loginname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 登录功能
	 * 
	 * @param user
	 * @return
	 */
	public Student login(String name, String password) {

		try {
			return studentDao.findByLoginnameAndLoginpass(name, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public PageBean<Student> findAll1(int page ,int rows,String uid,String loginname,String loginpass) throws SQLException {
		return studentDao.findAll1(page,rows,uid,loginname,loginpass);

	}
	public PageBean<Student> findAll(int page ,int rows) throws SQLException {
		return studentDao.findAll(page,rows);

	}
	public boolean add(RowData rowData) throws SQLException {
		return studentDao.add(rowData);

	}
	public boolean removeStudent(String uidString) throws SQLException {
		return studentDao.removeStudent(uidString);

	}

	public PageBean<Student> findById(int page, int rows, String uidString) throws SQLException {
		return studentDao.findById(page,rows,uidString);
	}



}
