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
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.question.service.MadeService;
import cn.zjlg.onlineexam.student.domain.PageBean;

@SuppressWarnings("serial")
public class MadeServlet extends BaseServlet {
	MadeService madeService=new MadeService();
	//获得制定的选择题ID
	public void  madeSelect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String selectString=request.getParameter("idString");
		boolean flag=madeService.madeSelect(selectString);
		response.getWriter().print(flag);
	}
	//获得制定的判断题ID
	public void  madeJudge(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String judgeString=request.getParameter("idString");
		boolean flag=madeService.madeJudge(judgeString);
		response.getWriter().print(flag);
		
	}
	//获得制定的填空题ID
	public void  madeCloze(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String clozeString=request.getParameter("idString");
		System.out.println(clozeString);
		boolean flag=madeService.madeCloze(clozeString);
		response.getWriter().print(flag);
		
	}
	//返回制定的填空题记录
	public void cloze(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		String clozeString=madeService.getCloze();
		PageBean<Cloze> pageBean= madeService.findAllCloze(page,rows,clozeString);
		List<Cloze> studentList=pageBean.getBeanList(); 
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
	
	public void judge(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		String judgeString=madeService.getJudge();
		PageBean<Judge> pageBean= madeService.findAllJudge(page,rows,judgeString);
		List<Judge> studentList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		Map map=new HashMap();
		map.put("total", pageBean.getTotalRecord());
		map.put("rows", studentList);
		//将对象转化成JSON字符串
		response.getWriter().print(JSONObject.fromObject(map));
		response.getWriter().close();
	}

	public void select(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		String selectString=madeService.getSelect();
		PageBean<QuestionSelect> pageBean= madeService.findAllSelect(page,rows,selectString);
		List<QuestionSelect> studentList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		Map map=new HashMap();
		map.put("total", pageBean.getTotalRecord());
		map.put("rows", studentList);
		//将对象转化成JSON字符串
		response.getWriter().print(JSONObject.fromObject(map));
		response.getWriter().close();
	}

}
