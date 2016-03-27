package cn.zjlg.onlineexam.question.service;

import java.sql.SQLException;

import cn.zjlg.onlineexam.question.dao.ProgramDao;
import cn.zjlg.onlineexam.question.domain.Program;
import cn.zjlg.onlineexam.student.domain.PageBean;

public class ProgramService {
	private ProgramDao programDao=new ProgramDao();

	public PageBean<Program> findAll(int page, int rows) throws SQLException {
		return programDao.findAll(page,rows);
	}

	public boolean add(Program program) throws SQLException {
		return programDao.add(program);
	}

	public boolean removeProgram(String idString) throws SQLException {
		return programDao.removeProgram(idString);
	}

}
