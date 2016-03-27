package cn.zjlg.onlineexam.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.exam.domain.Score;
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.Program;
import cn.zjlg.onlineexam.question.domain.ProgramSubmit;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;


public class ExamDao {
	private QueryRunner qrQueryRunner=new TxQueryRunner();

	public List<QuestionSelect> selectExam(String selectString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		try {
			String sqlString="select * from questionselect where id in("+selectString+")";
			preparedStatement=connection.prepareStatement(sqlString);
			List<QuestionSelect> beanList=new ArrayList<QuestionSelect>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new QuestionSelect(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5),resultSet.getString(6)
						,resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)
						,resultSet.getInt(10)));
			}
			return beanList;
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

	public List<Judge> judgeExam(String judgeString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		try {
			String sqlString="select * from judge where id in("+judgeString+")";
			preparedStatement=connection.prepareStatement(sqlString);
			List<Judge> beanList=new ArrayList<Judge>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Judge(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
						resultSet.getInt(6)));
			}
			return beanList;
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

	public List<Cloze> clozeExam(String clozeString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		try {
			String sqlString="select * from cloze where id in("+clozeString+")";
			preparedStatement=connection.prepareStatement(sqlString);
			List<Cloze> beanList=new ArrayList<Cloze>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Cloze(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
						resultSet.getInt(6)));
			}
			return beanList;
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

	public String getJudge() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		String sqlString="select idString from made where type='judge'";
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

	public String getCloze() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		String sqlString="select idString from made where type='cloze'";
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
	
	
	
	

	public int selectCount(List<String> selects,String selectString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		try {
			String sqlString="select * from questionselect where id in("+selectString+")";
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			int selectCount=0;
			int i=0;
			while(resultSet.next()){
				if(selects.get(i).equals(resultSet.getString(7))){
					selectCount=selectCount+resultSet.getInt(10);	
				}else{
					selectCount=selectCount+0;
				}
				i++;
			}
			return selectCount;
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
		return 0;
	}

	public int judgeCount(List<String> judges,String judgeString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		try {
			String sqlString="select * from judge where id in("+judgeString+")";
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			int judgeCount=0;
			int i=0;
			while(resultSet.next()){
				if(judges.get(i).equals(resultSet.getString(3))){
					judgeCount=judgeCount+resultSet.getInt(6);	
				}else{
					judgeCount=judgeCount+0;
				}
				i++;
			}
			return judgeCount;
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
		return 0;
	}

	public int clozeCount(List<String> clozes,String clozeString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		try {
			String sqlString="select * from cloze where id in("+clozeString+")";
			preparedStatement=connection.prepareStatement(sqlString);
			resultSet=preparedStatement.executeQuery();
			int clozeCount=0;
			int i=0;
			while(resultSet.next()){
				if(clozes.get(i).equals(resultSet.getString(3))){
					clozeCount=clozeCount+resultSet.getInt(6);	
				}else{
					clozeCount=clozeCount+0;
				}
				i++;
			}
			return clozeCount;
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
		return 0;
	}

	public String getProgram() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		String sqlString="select idString from made where type='program'";
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

	public List<Program> programExam(String programString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		connection=JdbcUtils.getConnection();
		try {
			String sqlString="select * from program where id in("+programString+")";
			preparedStatement=connection.prepareStatement(sqlString);
			List<Program> beanList=new ArrayList<Program>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Program(resultSet.getInt(1),resultSet.getString(2),
						resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),
						resultSet.getInt(6)));
			}
			return beanList;
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

	public Score findStudent(String studentName) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=JdbcUtils.getConnection();
			String sqlString="select * from score where studentName=?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setString(1, studentName);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				return new Score(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)
						, resultSet.getString(4)
						, resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));			
			}
		} catch (Exception e) {
		}finally{
			try {
				if(preparedStatement!=null)	preparedStatement.close();
				if(connection!=null) connection.close();

			} catch (SQLException e) {

			}
		}
		return null;
	}

	public void addProgramSubmit(String loginname, String question, String program) throws SQLException {
		String sqlSelect="select * from programsubmit where studentName=?";
		ProgramSubmit programSubmit; 
		programSubmit=qrQueryRunner.query(sqlSelect, new BeanHandler<ProgramSubmit>(ProgramSubmit.class),loginname);
		if(programSubmit==null){
			String sql = "insert into programsubmit(studentName,question,studentAnswer) values(?,?,?)";
			qrQueryRunner.update(sql,loginname,question,program);
		}else{
			String sqlString="UPDATE programsubmit SET studentName=?,question=?,studentAnswer=? WHERE studentName=?";
			Object[] params={loginname,question,program,loginname};
			qrQueryRunner.update(sqlString, params);
		}
		
		
	}

	public void addScore(String loginname, int score, int selectCount, int judgeCount,int clozeCount) throws SQLException {
		String scoreString=score+"";
		String selectString=selectCount+"";
		String judgeString=judgeCount+"";
		String clozesString=clozeCount+"";
		String sql = "insert into score(studentName,score,selectScore,judge,cloze) values (?,?,?,?,?)";
		qrQueryRunner.update(sql,loginname,scoreString,selectString,judgeString,clozesString);
		
	}

	
	

}
