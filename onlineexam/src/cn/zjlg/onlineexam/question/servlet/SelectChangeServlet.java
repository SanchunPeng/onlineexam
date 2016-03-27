package cn.zjlg.onlineexam.question.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.Program;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.question.service.SelectChangeService;
import cn.zjlg.onlineexam.student.domain.PageBean;

@SuppressWarnings("serial")
public class SelectChangeServlet extends BaseServlet {
	SelectChangeService selectChangeService=new SelectChangeService();
	
	public void change(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String chapter=request.getParameter("chapter");
		PageBean<Program> pageBean= selectChangeService.find(chapter);
		List<Program> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
	public void changeFromScore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String grade=request.getParameter("grade");
		PageBean<Program> pageBean= selectChangeService.findFromScore(grade);
		List<Program> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
	
	public void changeFromClozeChapter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String chapter=request.getParameter("chapter");
		PageBean<Cloze> pageBean= selectChangeService.findFromClozeChapter(chapter);
		List<Cloze> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
	public void changeFromSelectChapter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String chapter=request.getParameter("chapter");
		PageBean<QuestionSelect> pageBean= selectChangeService.changeFromSelectChapter(chapter);
		List<QuestionSelect> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
	public void changeFromJudgeChapter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String chapter=request.getParameter("chapter");
		PageBean<Judge> pageBean= selectChangeService.changeFromJudgeChapter(chapter);
		List<Judge> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
	
	public void changeFromClozeGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String grade=request.getParameter("grade");
		PageBean<Cloze> pageBean= selectChangeService.findFromClozeGrade(grade);
		List<Cloze> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
	public void changeFromJudgeGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String grade=request.getParameter("grade");
		PageBean<Judge> pageBean= selectChangeService.changeFromJudgeGrade(grade);
		List<Judge> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
	public void changeFromSelectGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String grade=request.getParameter("grade");
		PageBean<QuestionSelect> pageBean= selectChangeService.changeFromSelectGrade(grade);
		List<QuestionSelect> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		//将对象转化成JSON字符串
		response.getWriter().print(JSONArray.fromObject(programList));
		response.getWriter().close();		
	}
}
