package cn.zjlg.onlineexam.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.exam.domain.Score;
import cn.zjlg.onlineexam.exam.service.ScoreService;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.domain.PageBean;

@SuppressWarnings("serial")
public class ScoreServlet extends BaseServlet {
	ScoreService scoreService=new ScoreService();

	
	public void  addScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String id=request.getParameter("id");
		String studentName=request.getParameter("studentName");
		String score=request.getParameter("score");
		boolean flag=scoreService.add(id, studentName, score);
		response.getWriter().print(flag);
		
	}
	
	/*
	 * 删除学生信息
	 */
	public void  removeScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String uidString=request.getParameter("uidString");
		boolean flag=scoreService.removeScore(uidString);
		response.getWriter().print(flag);
		
		
	}
	public void  query(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		String changeString=request.getParameter("changeString");
		PageBean<Score> pageBean= scoreService.findAll(page,rows,changeString);
		List<Score> studentList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		Map map=new HashMap();
		map.put("total", pageBean.getTotalRecord());
		map.put("rows", studentList);
		//将对象转化成JSON字符串
		response.getWriter().print(JSONObject.fromObject(map));
		response.getWriter().close();
		
	}
	
	
	/*
	 * 返回所有学生信息
	 */
	public void datagridScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		PageBean<Score> pageBean= scoreService.findAll(page,rows);
		List<Score> studentList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		Map map=new HashMap();
		map.put("total", pageBean.getTotalRecord());
		map.put("rows", studentList);
		//将对象转化成JSON字符串
		response.getWriter().print(JSONObject.fromObject(map));
		response.getWriter().close();
	}
	public void findById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		String uidString=request.getParameter("id");	
		int id=Integer.parseInt(uidString);
		PageBean<Score> pageBean= scoreService.findById(page,rows,id);
		List<Score> studentList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		Map map=new HashMap();
		map.put("total", pageBean.getTotalRecord());
		map.put("rows", studentList);
		//将对象转化成JSON字符串
		response.getWriter().print(JSONObject.fromObject(map));
		response.getWriter().close();
	}
	/*
	 * 获取当前页码
	 */
	public  int getPage(HttpServletRequest request) {
		String page = request.getParameter("page");
		if(page != null && !page.trim().isEmpty()){
			return Integer.parseInt(page);
		}	
		return 1;
	}
	/*
	 * 获取每页数
	 */
	public  int getRows(HttpServletRequest request) {
		String rows = request.getParameter("rows");
		return Integer.parseInt(rows);
		
	}

}
