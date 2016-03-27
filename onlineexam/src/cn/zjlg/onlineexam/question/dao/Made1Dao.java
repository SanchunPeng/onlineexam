package cn.zjlg.onlineexam.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.question.domain.Made;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;

public class Made1Dao {
	private QueryRunner queryRunner=new TxQueryRunner();

	public List<Made> getMade() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		List<Made> madeList=new ArrayList<Made>();
		String sqlString="select * from made";
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			String itemString="";
			while(resultSet.next()){
				if(resultSet.getString(1).equals("select")){
					itemString="选择题";
				}else if(resultSet.getString(1).equals("judge")){
					itemString="判断题";
				}else if(resultSet.getString(1).equals("cloze")){
					itemString="填空题";
				}else if(resultSet.getString(1).equals("program")){
					itemString="程序题";
				}
				madeList.add(new Made(itemString,resultSet.getString(2)));
			}
			return madeList;
		} catch (SQLException e) {
				e.printStackTrace();
		}finally{			
				try {
					if (preparedStatement!=null)preparedStatement.close();
					if(connection!=null) connection.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}
		return null;
	}

}
