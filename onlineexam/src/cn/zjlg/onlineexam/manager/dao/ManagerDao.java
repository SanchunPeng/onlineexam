package cn.zjlg.onlineexam.manager.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.manager.domain.Manager;

/**
 * 管理员模块红持久层
 * 
 * @author Administrator
 * 
 */
public class ManagerDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 按用户名和密码查询
	 * 
	 * @param loginname
	 * @param loginpass
	 * @return
	 * @throws SQLException
	 */
	public Manager findByLoginnameAndLoginpass(String name, String password)
			throws SQLException {
		String sql = "select * from manager where name=? and password=?";
		return qr.query(sql, new BeanHandler<Manager>(Manager.class), name,
				password);
	}

}
