package cn.zjlg.onlineexam.question.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.service.JudgeService;
import cn.zjlg.onlineexam.student.domain.PageBean;

@SuppressWarnings("serial")
public class JudgeServlet extends BaseServlet {

	JudgeService judgeService=new JudgeService();
	public void datagridJudge(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		PageBean<Judge> pageBean= judgeService.findAll(page,rows);
		List<Judge> studentList=pageBean.getBeanList(); 
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
		PageBean<Judge> pageBean= judgeService.findById(page,rows,id);
		List<Judge> studentList=pageBean.getBeanList(); 
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
	
	public void  addJudge(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		String chapter=request.getParameter("chapter");
		String grade=request.getParameter("grade");
		String pointString=request.getParameter("point");
		int point=Integer.parseInt(pointString);
		Judge judge=new Judge(question,answer,chapter,grade,point);
		boolean flag=judgeService.add(judge);
		response.getWriter().print(flag);
		
	}
	public void  removeJudge(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String idString=request.getParameter("idString");
		boolean flag=judgeService.removeJudge(idString);
		response.getWriter().print(flag);	
	}
	

}
