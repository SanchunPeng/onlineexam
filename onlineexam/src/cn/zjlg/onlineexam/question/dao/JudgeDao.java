package cn.zjlg.onlineexam.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;
import cn.zjlg.onlineexam.student.domain.PageBean;

public class JudgeDao {
	private QueryRunner qr = new TxQueryRunner();
	public PageBean<Judge> findAll(int page,int rows) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Judge> pageBean=new PageBean<Judge>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from judge";
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
			sqlString="select * from judge order by id limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<Judge> beanList=new ArrayList<Judge>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Judge(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)
						,resultSet.getInt(6)));
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
	
	public boolean add(Judge judge) throws SQLException {
		String sql = "insert into judge(question,answer,chapter,grade,point) values(?,?,?,?,?)";
		int i=qr.update(sql,judge.getQuestion(),judge.getAnswer(),judge.getChapter(),judge.getGrade(),
				judge.getPoint());
		if(i!=0){
			return true;
		}else{
			return false;
		}

	}
	
	
	public boolean removeJudge(String idString) throws SQLException {
		String sql = "delete from judge where id in("+idString+")";
		int i=qr.update(sql);
		if(i!=0){
			return true;
		}else{
			return false;
		}

	}

	public PageBean<Judge> findById(int page, int rows, int id) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Judge> pageBean=new PageBean<Judge>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from judge";
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
			sqlString="select * from judge where id=? order by id limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, id);
			preparedStatement.setInt(2, (page-1)*rows);
			preparedStatement.setInt(3, rows);
			List<Judge> beanList=new ArrayList<Judge>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Judge(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)
						,resultSet.getInt(6)));
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
