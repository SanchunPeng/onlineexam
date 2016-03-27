package cn.zjlg.onlineexam.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;
import cn.zjlg.onlineexam.student.domain.PageBean;


public class MadeDao {
	private QueryRunner qr=new TxQueryRunner();

	public PageBean<Cloze> findAllCloze(int page,int rows,String clozeString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Cloze> pageBean=new PageBean<Cloze>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from cloze where id in("+clozeString+")";
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
			sqlString="select * from cloze where id in("+clozeString+") limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<Cloze> beanList=new ArrayList<Cloze>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Cloze(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4)
						,resultSet.getInt(5)));
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

	
	public PageBean<Judge> findAllJudge(int page,int rows,String judgeString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Judge> pageBean=new PageBean<Judge>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from judge where id in("+judgeString+")";
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
			sqlString="select * from judge where id in("+judgeString+") limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<Judge> beanList=new ArrayList<Judge>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Judge(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4)
						,resultSet.getInt(5)));
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
	
	public PageBean<QuestionSelect> findAllSelect(int page,int rows,String selectString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<QuestionSelect> pageBean=new PageBean<QuestionSelect>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from questionselect where id in("+selectString+")";
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
			sqlString="select * from questionselect where id in("+selectString+") limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<QuestionSelect> beanList=new ArrayList<QuestionSelect>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new QuestionSelect(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),resultSet.getString(6)
						,resultSet.getString(7),resultSet.getString(8)
						,resultSet.getInt(9)));
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
	
	
	
	
	public boolean madeJudge(String judgeString) throws SQLException {
		String sqlString="update made set idString=" + judgeString + "  where  type='judge'";
		int flag=qr.update(sqlString);
		if(flag!=0){
			return true;
		}else{
			return false;
		}
	}

	public boolean madeSelect(String selectString) throws SQLException {
		String sqlString="update made set idString=" + selectString +" where type='select'";
		int flag=qr.update(sqlString);
		if(flag!=0){
			return true;
		}else{
			return false;
		}
	}

	public boolean madeCloze(String clozeString) throws SQLException {
		String sqlString="update made set idString=" + clozeString + " where type='cloze'";
		int flag=qr.update(sqlString);
		if(flag!=0){
			return true;
		}else{
			return false;
		}
	}

	public String getCloze() throws SQLException {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		String sqlString="select idString from made where type='cloze'";
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			String clozeString="";
			while(resultSet.next()){
				clozeString=resultSet.getString(1);
			}
			return clozeString;
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

	public String getJudge() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		String sqlString="select idString from made where type='judge'";
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			String judgeString="";
			while(resultSet.next()){
				judgeString=resultSet.getString(1);
			}
			return judgeString;
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

	public String getSelect() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		String sqlString="select idString from made where type='select'";
		try {
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			String selectString="";
			while(resultSet.next()){
				selectString=resultSet.getString(1);
			}
			return selectString;
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
