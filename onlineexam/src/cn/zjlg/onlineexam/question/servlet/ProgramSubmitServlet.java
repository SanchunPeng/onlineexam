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
import cn.zjlg.onlineexam.question.domain.ProgramSubmit;
import cn.zjlg.onlineexam.question.service.ProgramSubmitService;
import cn.zjlg.onlineexam.student.domain.PageBean;



@SuppressWarnings("serial")
public class ProgramSubmitServlet extends BaseServlet {
	ProgramSubmitService programSubmitService=new ProgramSubmitService();
	public void datagridProgram(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		PageBean<ProgramSubmit> pageBean= programSubmitService.findAll(page,rows);
		List<ProgramSubmit> programList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		Map map=new HashMap();
		map.put("total", pageBean.getTotalRecord());
		map.put("rows", programList);
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
	
	public void  addProgram(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String studentName=request.getParameter("studentName");
		String question=request.getParameter("question");
		String answer=request.getParameter("studentAnswer");
		String getScore=request.getParameter("getScore");
		int point=0;
		if(getScore!=null){
			point=Integer.parseInt(getScore);
		}
				
		ProgramSubmit program=new ProgramSubmit(studentName,question,answer,point);
		boolean flag=programSubmitService.add(program);
		response.getWriter().print(flag);
		
	}
	public void  removeProgram(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String idString=request.getParameter("idString");
		boolean flag=programSubmitService.remove(idString);
		response.getWriter().print(flag);	
	}
	
	

}
