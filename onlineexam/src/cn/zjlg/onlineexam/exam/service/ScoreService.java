package cn.zjlg.onlineexam.exam.service;

import java.sql.SQLException;
import java.util.List;

import cn.zjlg.onlineexam.exam.dao.ScoreDao;
import cn.zjlg.onlineexam.exam.domain.Score;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.domain.PageBean;
import cn.zjlg.onlineexam.student.domain.RowData;

public class ScoreService {
	ScoreDao scoreDao=new ScoreDao();
	public PageBean<Score> findAll(int page ,int rows) throws SQLException {
		return scoreDao.findAll(page,rows);

	}
	public boolean add(String id, String studentName, String score) throws SQLException {
		return scoreDao.add(id, studentName, score);

	}
	public boolean removeScore(String uidString) throws SQLException {
		return scoreDao.removeScore(uidString);

	}
	public boolean belowToSixty() throws SQLException {
		return scoreDao.belowToSixty();
	}
	public PageBean<Score> findAll(int page, int rows, String changeString) throws SQLException {
		return scoreDao.findAll(page,rows,changeString);
	}
	public PageBean<Score> findById(int page, int rows, int id) throws SQLException {
		return scoreDao.findById(page,rows,id);
	}

}
