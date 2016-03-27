package cn.zjlg.onlineexam.question.service;

import java.sql.SQLException;
import java.util.List;

import cn.zjlg.onlineexam.question.dao.Made1Dao;
import cn.zjlg.onlineexam.question.domain.Made;

public class Made1Service {
	private Made1Dao made1Dao=new Made1Dao();

	public List<Made> getMade() throws SQLException {
		return made1Dao.getMade();
	}

}
