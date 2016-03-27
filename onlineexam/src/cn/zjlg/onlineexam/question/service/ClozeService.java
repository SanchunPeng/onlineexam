package cn.zjlg.onlineexam.question.service;

import java.sql.SQLException;

import cn.zjlg.onlineexam.question.dao.ClozeDao;
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.student.domain.PageBean;

public class ClozeService {
	private ClozeDao clozeDao=new ClozeDao();
	public PageBean<Cloze> findAll(int page ,int rows) throws SQLException {
		return clozeDao.findAll(page,rows);

	}
	public boolean add(Cloze cloze) throws SQLException {
		return clozeDao.add(cloze);

	}
	public boolean removeCloze(String idString) throws SQLException {
		return clozeDao.removeCloze(idString);

	}
	public PageBean<Cloze> findById(int page, int rows, int id) throws SQLException {
		return clozeDao.findById(page,rows,id);
	}
}
