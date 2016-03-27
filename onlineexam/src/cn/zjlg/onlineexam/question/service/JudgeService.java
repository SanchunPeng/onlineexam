package cn.zjlg.onlineexam.question.service;

import java.sql.SQLException;

import cn.zjlg.onlineexam.question.dao.JudgeDao;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.student.domain.PageBean;

public class JudgeService {
	private JudgeDao judgeDao=new JudgeDao();
	public PageBean<Judge> findAll(int page ,int rows) throws SQLException {
		return judgeDao.findAll(page,rows);

	}
	public boolean add(Judge judge) throws SQLException {
		return judgeDao.add(judge);

	}
	public boolean removeJudge(String idString) throws SQLException {
		return judgeDao.removeJudge(idString);

	}
	public PageBean<Judge> findById(int page, int rows, int id) throws SQLException {
		return judgeDao.findById(page,rows,id);
	}


}
