package cn.zjlg.onlineexam.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.exam.domain.Score;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;
import cn.zjlg.onlineexam.student.domain.PageBean;
import cn.zjlg.onlineexam.student.domain.RowData;
import cn.zjlg.onlineexam.student.domain.Student;

public class ScoreDao {
	QueryRunner qr=new TxQueryRunner();
	public PageBean<Score> findAll(int page,int rows) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Score> pageBean=new PageBean<Score>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from score";
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			String totalRecord=null;
			while(resultSet.next()){
				totalRecord=resultSet.getString(1);
				//得到totalRecord
				//System.out.println(totalRecord);
				pageBean.setTotalRecord(Integer.parseInt(totalRecord));
			}
			//得到BeanList
			sqlString="select * from score order by id limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<Score> beanList=new ArrayList<Score>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Score(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
			}
			pageBean.setBeanList(beanList);
			return pageBean;
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

	public boolean removeScore(String uidString) throws SQLException {
		String sql = "delete from score where id in("+uidString+")";
		int i=qr.update(sql, uidString);
		if(i!=0){
			return true;
		}else{
			return false;
		}

	}
	public boolean add(String id, String studentName, String score) throws SQLException {
		String sql = "insert into score values(?,?,?)";
		int i=qr.update(sql, id, studentName,score);
		if(i!=0){
			return true;
		}else{
			return false;
		}
	}

	public boolean belowToSixty() throws SQLException {
		String sql = "select *  from score where score<60";
		int i=qr.update(sql);
		if(i!=0){
			return true;
		}else{
			return false;
		}
	}

	public PageBean<Score> findAll(int page, int rows, String changeString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Score> pageBean=new PageBean<Score>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from score";
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			String totalRecord=null;
			while(resultSet.next()){
				totalRecord=resultSet.getString(1);
				//得到totalRecord
				//System.out.println(totalRecord);
				pageBean.setTotalRecord(Integer.parseInt(totalRecord));
			}
			//得到BeanList
			sqlString="select * from score where "+changeString+" order by id limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<Score> beanList=new ArrayList<Score>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Score(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
			}
			pageBean.setBeanList(beanList);
			return pageBean;
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

	public PageBean<Score> findById(int page, int rows, int id) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Score> pageBean=new PageBean<Score>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from score";
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			String totalRecord=null;
			while(resultSet.next()){
				totalRecord=resultSet.getString(1);
				//得到totalRecord
				//System.out.println(totalRecord);
				pageBean.setTotalRecord(Integer.parseInt(totalRecord));
			}
			//得到BeanList
			sqlString="select * from score where id=? order by id limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, (page-1)*rows);
			preparedStatement.setInt(3, rows);
			List<Score> beanList=new ArrayList<Score>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Score(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)
						,resultSet.getString(6),resultSet.getString(7)));
			}
			pageBean.setBeanList(beanList);
			return pageBean;
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
