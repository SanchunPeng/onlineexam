package cn.zjlg.onlineexam.question.service;

import java.sql.SQLException;

import cn.zjlg.onlineexam.question.dao.ProgramSubmitDao;
import cn.zjlg.onlineexam.question.domain.ProgramSubmit;
import cn.zjlg.onlineexam.student.domain.PageBean;

public class ProgramSubmitService {
	private ProgramSubmitDao programSubmitDao=new ProgramSubmitDao();

	public PageBean<ProgramSubmit> findAll(int page, int rows) throws SQLException {
		return programSubmitDao.findAll(page,rows);
	}

	public boolean add(ProgramSubmit program) throws SQLException {
		return programSubmitDao.add(program);
	}

	public boolean remove(String idString) throws SQLException {
		return programSubmitDao.removeProgram(idString);
	}

}
