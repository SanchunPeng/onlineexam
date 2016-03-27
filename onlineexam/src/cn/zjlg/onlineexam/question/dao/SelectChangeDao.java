package cn.zjlg.onlineexam.question.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.Program;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.dao.JdbcUtils;
import cn.zjlg.onlineexam.student.domain.PageBean;
import cn.zjlg.onlineexam.student.domain.Student;

public class SelectChangeDao {
	private QueryRunner queryRunner=new TxQueryRunner();

	public PageBean<Program> find(String chapter) throws SQLException {
		String chapterString=getChapter(chapter);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Program> pageBean=new PageBean<Program>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from program where chapter=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, chapterString);
		resultSet=preparedStatement.executeQuery();
		List<Program> beanList=new ArrayList<Program>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new Program(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
	public String getChapter(String chapter){
		String chapterString="";
		if(chapter.equals("chapter1")){
			chapterString="第一章";
		}else if(chapter.equals("chapter2")){
			chapterString="第二章";
		}else if(chapter.equals("chapter3")){
			chapterString="第三章";
		}else{
			chapterString="第四章";
		}
		return chapterString;
	}
	
	public String getGrade(String grade){
		String gradeString="";
		if(grade.equals("programEsay")){
			gradeString="易";
		}else{
			gradeString="难";
		}
		return gradeString;
	}

	public PageBean<Program> findFromScore(String grade) {
		String gradeString=getGrade(grade);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Program> pageBean=new PageBean<Program>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from program where grade=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, gradeString);
		resultSet=preparedStatement.executeQuery();
		List<Program> beanList=new ArrayList<Program>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new Program(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
	public PageBean<Cloze> findFromClozeChapter(String chapter) {
		String chapterString=getChapter(chapter);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Cloze> pageBean=new PageBean<Cloze>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from cloze where chapter=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, chapterString);
		resultSet=preparedStatement.executeQuery();
		List<Cloze> beanList=new ArrayList<Cloze>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new Cloze(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
	public PageBean<Cloze> findFromClozeGrade(String grade) {
		String gradeString=getGrade(grade);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Cloze> pageBean=new PageBean<Cloze>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from cloze where grade=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, gradeString);
		resultSet=preparedStatement.executeQuery();
		List<Cloze> beanList=new ArrayList<Cloze>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new Cloze(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
	public PageBean<QuestionSelect> changeFromSelectChapter(String chapter) {
		String chapterString=getChapter(chapter);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<QuestionSelect> pageBean=new PageBean<QuestionSelect>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from questionSelect where chapter=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, chapterString);
		resultSet=preparedStatement.executeQuery();
		List<QuestionSelect> beanList=new ArrayList<QuestionSelect>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new QuestionSelect(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
	public PageBean<Judge> changeFromJudgeChapter(String chapter) {
		String chapterString=getChapter(chapter);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Judge> pageBean=new PageBean<Judge>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from judge where chapter=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, chapterString);
		resultSet=preparedStatement.executeQuery();
		List<Judge> beanList=new ArrayList<Judge>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new Judge(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
	public PageBean<Judge> changeFromJudgeGrade(String grade) {
		String gradeString=getGrade(grade);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Judge> pageBean=new PageBean<Judge>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from judge where grade=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, gradeString);
		resultSet=preparedStatement.executeQuery();
		List<Judge> beanList=new ArrayList<Judge>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new Judge(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
	public PageBean<QuestionSelect> changeFromSelectGrade(String grade) {
		String gradeString=getGrade(grade);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<QuestionSelect> pageBean=new PageBean<QuestionSelect>();
		try{
		connection=JdbcUtils.getConnection();
		String sqlString="select * from questionSelect where grade=?";
		preparedStatement=connection.prepareStatement(sqlString);
		preparedStatement.setString(1, gradeString);
		resultSet=preparedStatement.executeQuery();
		List<QuestionSelect> beanList=new ArrayList<QuestionSelect>();
		int i=0;
		boolean selected=false;
			while(resultSet.next()){
				i++;
				if(i==1){
					selected=true;
				}
				beanList.add(new QuestionSelect(resultSet.getInt(1),resultSet.getInt(1)+"."+resultSet.getString(2),selected));
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
