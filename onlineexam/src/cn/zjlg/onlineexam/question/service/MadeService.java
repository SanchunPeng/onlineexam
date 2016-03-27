package cn.zjlg.onlineexam.question.service;

import java.sql.SQLException;

import cn.zjlg.onlineexam.question.dao.MadeDao;
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.domain.PageBean;

public class MadeService {
	private MadeDao madeDao=new MadeDao();
	public PageBean<Cloze> findAllCloze(int page ,int rows,String clozesString) throws SQLException {
		return madeDao.findAllCloze(page,rows,clozesString);

	}
	
	public boolean madeJudge(String judgeString) throws SQLException{
		return madeDao.madeJudge(judgeString);
	}
	public boolean madeSelect(String selectString) throws SQLException{
		return madeDao.madeSelect(selectString);
	}
	public boolean madeCloze(String clozeString) throws SQLException{
		return madeDao.madeCloze(clozeString);
	}

	public String getCloze() throws SQLException {
		return madeDao.getCloze();
	}

	public String getJudge() throws SQLException {
		return madeDao.getJudge();
	}

	public String getSelect() throws SQLException {
		return madeDao.getSelect();
	}


	public PageBean<Judge> findAllJudge(int page, int rows, String judgeString) throws SQLException {
		return madeDao.findAllJudge(page,rows,judgeString);
	}
	public PageBean<QuestionSelect> findAllSelect(int page, int rows, String selectString) throws SQLException {
		return madeDao.findAllSelect(page,rows,selectString);
	}

	
}
