package cn.zjlg.onlineexam.question.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.question.service.QuestionSelectService;
import cn.zjlg.onlineexam.student.domain.PageBean;

@SuppressWarnings("serial")
public class SingleSelectServlet extends BaseServlet {

	QuestionSelectService questionSelectService=new QuestionSelectService();
	
	/*
	 * 返回所有信息
	 */
	public void datagridSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		PageBean<QuestionSelect> pageBean= questionSelectService.findAll(page,rows);
		List<QuestionSelect> studentList=pageBean.getBeanList(); 
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
		PageBean<QuestionSelect> pageBean= questionSelectService.findById(page,rows,id);
		List<QuestionSelect> studentList=pageBean.getBeanList(); 
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
	
	public void  addSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String question=request.getParameter("question");
		String optionA=request.getParameter("optionA");
		String optionB=request.getParameter("optionB");
		String optionC=request.getParameter("optionC");
		String optionD=request.getParameter("optionD");
		String answer=request.getParameter("answer");
		String chapter=request.getParameter("chapter");
		String grade=request.getParameter("grade");
		String pointString=request.getParameter("point");
		int point=Integer.parseInt(pointString);
		QuestionSelect questionSelect=new QuestionSelect(question,optionA,optionB,optionC,optionD,answer,chapter,grade,point);
		boolean flag=questionSelectService.add(questionSelect);
		response.getWriter().print(flag);
		
	}
	public void  removeSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String uidString=request.getParameter("idString");
		boolean flag=questionSelectService.removeSelect(uidString);
		response.getWriter().print(flag);	
	}

}
