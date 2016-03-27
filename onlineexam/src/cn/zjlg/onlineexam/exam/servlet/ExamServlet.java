package cn.zjlg.onlineexam.exam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.exam.domain.Score;
import cn.zjlg.onlineexam.exam.service.ExamService;
import cn.zjlg.onlineexam.manager.domain.Json;
import cn.zjlg.onlineexam.question.domain.Cloze;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.question.domain.Program;
import cn.zjlg.onlineexam.question.domain.QuestionSelect;
import cn.zjlg.onlineexam.student.domain.Student;

@SuppressWarnings("serial")
public class ExamServlet extends BaseServlet {

	ExamService examService=new ExamService();
	public String selectExam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String selectString=examService.getSelect();
		List<QuestionSelect> questionSelects=examService.selectExam(selectString);
		
		String judgeString=examService.getJudge();
		List<Judge> judges=examService.judgeExam(judgeString);
		
		String clozeString=examService.getCloze();
		List<Cloze> clozes=examService.clozeExam(clozeString);
		
		String programString=examService.getProgram();
		List<Program> programs=examService.programExam(programString);
		
		request.setAttribute("selectList",questionSelects);		
		request.setAttribute("judgeList", judges);
		request.setAttribute("clozeList", clozes);
		request.setAttribute("programList", programs);
		return "f:/examCenter.jsp";
	}
	
	public void  count(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<String> selects=new ArrayList<String>();
		List<String> judges=new ArrayList<String>();
		List<String> clozes=new ArrayList<String>();
		for(int i=1;i<=10;i++){
			String selectOption=request.getParameter("selectOption"+i);
			if(selectOption==null){
				selects.add("no answer");
			}else{
				selects.add(selectOption);
			}
			String judgeOption=request.getParameter("judgeOption"+i);
			if(judgeOption==null){
				judges.add("no answer");
			}else{
				judges.add(judgeOption);
			}	
			String cloze=request.getParameter("cloze"+i);
			if(cloze==null){
				clozes.add("no answer");
			}else{
				clozes.add(cloze);
			}
		}
		String programString=examService.getProgram();
		List<Program> programs=examService.programExam(programString);
		String question=programs.get(0).getQuestion();
		String program="";
		program=request.getParameter("program1");
		if(program==null||program.trim().isEmpty()){
			program="no answer";
		}
		//System.out.println(program);
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("sessionStudent");
		if(student==null){
			//response.sendRedirect("/onlineexam/loginStudent.jsp");
			/*RequestDispatcher rd =  request.getRequestDispatcher("/loginStudent.jsp");
			rd.forward(request, response);*/
			Json json=new Json();
			String msg="你还没有登录，请重新登录！！！";
			json.setSuccess(false);
			json.setMsg(msg);
			response.getWriter().print(json);
			response.getWriter().close();
			
		}else{
		String loginname=student.getLoginname();
	
		examService.addProgramSubmit(loginname,question,program);
		
		
		String selectString=examService.getSelect();
		String judgeString=examService.getJudge();
		String clozeString=examService.getCloze();
		int selectCount=examService.selectCount(selects,selectString);
		int judgeCount=examService.judgeCount(judges,judgeString);
		int clozeCount=examService.clozeCount(clozes,clozeString);
		int score=selectCount+judgeCount+clozeCount;
		
		examService.addScore(loginname,score,selectCount,judgeCount,clozeCount);
		
		double selectPercent=selectCount/10.0;
		double judgePercent=judgeCount/10.0;
		double clozePercent=clozeCount/8.0;
		String msg="你的客观题分数是"+score+"  "+"选择题正确率:"+selectPercent+"  "+"判断题正确率:"+judgePercent+"  "
				+"填空题正确率:"+clozePercent+"  "+"程序题分数待老师查阅！！";
		//System.out.println(msg);
		Score scoreNew=examService.findStudent(loginname);
		HttpSession sessionNew = request.getSession();
		session.setAttribute("sessionScore",sessionNew);
		Json json=new Json();
		json.setSuccess(true);
		json.setMsg(msg);
		response.getWriter().print(json);
		response.getWriter().close();
		}
	}

}
