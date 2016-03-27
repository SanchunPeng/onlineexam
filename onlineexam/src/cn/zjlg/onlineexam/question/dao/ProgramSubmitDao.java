package cn.zjlg.onlineexam.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.question.domain.ProgramSubmit;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;
import cn.zjlg.onlineexam.student.domain.PageBean;


public class ProgramSubmitDao {
	private QueryRunner qRunner=new TxQueryRunner();

	public PageBean<ProgramSubmit> findAll(int page, int rows) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<ProgramSubmit> pageBean=new PageBean<ProgramSubmit>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from programSubmit";
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
			sqlString="select * from programSubmit order by id limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<ProgramSubmit> beanList=new ArrayList<ProgramSubmit>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new ProgramSubmit(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5)));
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

	public boolean add(ProgramSubmit program) throws SQLException {
		String sql = "insert into programSubmit(studentName,question,studentAnswer,getScore) values(?,?,?,?)";
		int i=qRunner.update(sql,program.getStudentName(),program.getQuestion(),program.getStudentAnswer(),program.getGetScore());
		if(i!=0){
			return true;
		}else{
			return false;
		}
	}

	public boolean removeProgram(String idString) throws SQLException {
		String sql = "delete from programSubmit where id in("+idString+")";
		int i=qRunner.update(sql);
		if(i!=0){
			return true;
		}else{
			return false;
		}
	}
	

}
