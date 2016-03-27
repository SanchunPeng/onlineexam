package cn.zjlg.onlineexam.manager.service;

import java.sql.SQLException;

import cn.zjlg.onlineexam.manager.dao.ManagerDao;
import cn.zjlg.onlineexam.manager.domain.Manager;

/**
 * 管理员模块业务层
 * 
 * @author Administrator
 * 
 */
public class ManagerService {
	ManagerDao managerDao = new ManagerDao();

	public Manager login(String name, String password) {

		try {
			return managerDao.findByLoginnameAndLoginpass(name, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
