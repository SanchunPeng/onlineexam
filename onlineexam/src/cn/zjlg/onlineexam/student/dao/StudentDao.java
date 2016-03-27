package cn.zjlg.onlineexam.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.zjlg.onlineexam.student.domain.PageBean;
import cn.zjlg.onlineexam.student.domain.RowData;
import cn.zjlg.onlineexam.student.domain.Student;

/**
 * 用户模块持久层
 * 
 * @author Administrator
 * 
 */
public class StudentDao {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 校验用户名是否已存在
	 * 
	 * @param loginname
	 * @return
	 * @throws SQLException
	 */
	public boolean ajaxValidateLoginname(String loginname) throws SQLException {
		String sql = "select count(1) from student where loginname=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(), loginname);
		return number.intValue() == 0;// 表示没有被注册过
	}

	/**
	 * 按用户名和密码查询
	 * 
	 * @param loginname
	 * @param loginpass
	 * @return
	 * @throws SQLException
	 */
	public Student findByLoginnameAndLoginpass(String name,
			String password) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=JdbcUtils.getConnection();
			String sqlString="select * from student where loginname=? and loginpass=?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				return new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));			
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

	@SuppressWarnings("unchecked")
	public PageBean<Student> findAll1(int page,int rows,String uid,String loginname,String loginpass) throws SQLException {
		/*
		 * 1.给出sql模板
		 * 2.给出参数
		 * 3.调用query方法，使用结果处理器：BeanListHandler
		 */
		
		//条件的排列组合种类太多，如何给出sql模板
		
		//给出sql模板的前半部
		StringBuilder sqlBuilder=new StringBuilder("select * from student where 1=1 ");
		
		//判断条件完成想sql中添加where子句
		//创建一个ArrayList,用来装载参数值
		List<Object> params=new ArrayList<Object>();
		
		String uidString=uid;
		if(uidString!=null){
			sqlBuilder.append(" and uid like ?");
			params.add("%"+ uidString +"%");
		}
		String loginnameString=loginname;
		if(loginnameString!=null && !loginnameString.trim().isEmpty()){
			sqlBuilder.append(" and loginname like ?");
			params.add("%"+ loginnameString + "%");
		}
		String loginpassString=loginpass;
		if(loginpassString!=null && !loginpassString.trim().isEmpty()){
			sqlBuilder.append(" and loginpass=?");
			params.add(loginpassString);
		}
//		System.out.println(sqlBuilder);
//		System.out.println(params);
		//执行query
		try {
			return (PageBean<Student>) qr.query(sqlBuilder.toString(),
					new BeanListHandler<Student>(Student.class),params);
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return null;
	}
	
	
	public PageBean<Student> findAll(int page,int rows) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Student> pageBean=new PageBean<Student>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from student";
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
			sqlString="select * from student order by uid limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setInt(1, (page-1)*rows);
			preparedStatement.setInt(2, rows);
			List<Student> beanList=new ArrayList<Student>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Student(resultSet.getString(1),resultSet.getString(2),
						resultSet.getString(3)));
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
	/*
	 * 添加学生信息
	 */
	public boolean add(RowData rowData) throws SQLException {
		String sql = "insert into student values(?,?,?)";
		int i=qr.update(sql, rowData.getUid(), rowData.getLoginname(), rowData.getLoginpass());
		if(i!=0){
			return true;
		}else{
			return false;
		}

	}
	/*
	 * 删除学生信息
	 */
	public boolean removeStudent(String uidString) throws SQLException {
		String sql = "delete from student where uid in("+uidString+")";
		int i=qr.update(sql, uidString);
		if(i!=0){
			return true;
		}else{
			return false;
		}

	}

	public PageBean<Student> findById(int page, int rows, String uidString) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		PageBean<Student> pageBean=new PageBean<Student>();
		pageBean.setPage(page);
		pageBean.setRows(rows);
		connection=JdbcUtils.getConnection();
		String sqlString="select  count(*) from student";
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
			sqlString="select * from student where uid like ? order by uid limit ?,?";
			preparedStatement=connection.prepareStatement(sqlString);
			preparedStatement.setString(1, uidString);
			preparedStatement.setInt(2, (page-1)*rows);
			preparedStatement.setInt(3, rows);
			List<Student> beanList=new ArrayList<Student>();
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				beanList.add(new Student(resultSet.getString(1),resultSet.getString(2),
						resultSet.getString(3)));
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
