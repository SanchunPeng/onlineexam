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
import cn.zjlg.onlineexam.question.domain.Program;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;
import cn.zjlg.onlineexam.student.domain.PageBean;

public class ProgramDao {
	private QueryRunner queryRunner=new TxQueryRunner();

	public PageBean<Program> findAll(int page, int rows) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Program> pageBean=new PageBean<Program>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from program";
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
			sqlString="select * from program order by id limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<Program> beanList=new ArrayList<Program>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Program(resultSet.getInt(1),resultSet.getString(2),
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

	public boolean add(Program program) throws SQLException {
		String sql = "insert into program(question,answer,chapter,grade,point) values(?,?,?,?,?)";
		int i=queryRunner.update(sql,program.getQuestion(),program.getAnswer(),program.getChapter(),program.getGrade(),
				program.getPoint());
		if(i!=0){
			return true;
		}else{
			return false;
		}
	}

	public boolean removeProgram(String idString) throws SQLException {
		String sql = "delete from program where id in("+idString+")";
		int i=queryRunner.update(sql);
		if(i!=0){
			return true;
		}else{
			return false;
		}

	}

}
