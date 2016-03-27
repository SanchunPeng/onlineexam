package cn.zjlg.onlineexam.student.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.exam.domain.Score;
import cn.zjlg.onlineexam.exam.service.ExamService;
import cn.zjlg.onlineexam.manager.domain.Json;
import cn.zjlg.onlineexam.question.domain.Judge;
import cn.zjlg.onlineexam.student.domain.PageBean;
import cn.zjlg.onlineexam.student.domain.RowData;
import cn.zjlg.onlineexam.student.domain.Student;
import cn.zjlg.onlineexam.student.service.StudentService;

@SuppressWarnings("serial")
public class LoginStudentServlet extends BaseServlet {
	StudentService studentService = new StudentService();
	ExamService examService=new ExamService();
	public String ajaxValidateLoginname(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 */
		String loginname = req.getParameter("loginname");
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = studentService.ajaxValidateLoginname(loginname);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}

	public String ajaxValidateVerifyCode(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1. 获取输入框中的验证码
		 */
		String verifyCode = req.getParameter("verifyCode");
		/*
		 * 2. 获取图片上真实的校验码
		 */
		String vcode = (String) req.getSession().getAttribute("vCode");
		/*
		 * 3. 进行忽略大小写比较，得到结果
		 */
		boolean b = verifyCode.equalsIgnoreCase(vcode);
		/*
		 * 4. 发送给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}

	/**
	 * 登录功能
	 * 
	 * @param req
	 * @param resp
	 * @return 
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException 
	 */
	public void loginValidate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String name = req.getParameter("login");
		String password = req.getParameter("password");
		Student student = studentService.login(name, password);
		Score score=examService.findStudent(name);
		Json json = new Json();
		if (student == null) {
			json.setSuccess(false);
			json.setMsg("用户名或密码错误");
			resp.getWriter().print(json.toString());
			resp.getWriter().close();
			//return "r:/loginStudent.jsp";
		} else {
			if(score!=null){
				json.setSuccessExam(true);
			}
			HttpSession session = req.getSession();
			session.setAttribute("sessionStudent",student);
			session.setAttribute("sessionScore",score);
			//String string=(String) session.getAttribute("sessionName");
			//System.out.println(string);
			json.setSuccess(true);
			json.setMsg("登录成功");
			json.setStudent(student);		
			resp.getWriter().print(json);
			resp.getWriter().close();
			//return "r:/exam.jsp";//重定向到主页
		}
	}

	/*
	 *查询学生信息
	 */
	public void datagridStudent1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		String uid=request.getParameter("uid");
		String loginname=request.getParameter("loginname");
		String loginpass=request.getParameter("loginpass");
		PageBean<Student> pageBean= studentService.findAll1(page,rows,uid,loginname,loginpass);
		List<Student> studentList=pageBean.getBeanList(); 
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
		PageBean<Student> pageBean= studentService.findById(page,rows,uidString);
		List<Student> studentList=pageBean.getBeanList(); 
		//response.getWriter().print(JSONArray.fromObject(studentList));// 使用JSON-lib将list转化成json字符串形式
		Map map=new HashMap();
		map.put("total", pageBean.getTotalRecord());
		map.put("rows", studentList);
		//将对象转化成JSON字符串
		response.getWriter().print(JSONObject.fromObject(map));
		response.getWriter().close();
	}
	/*
	 * 添加学生信息
	 */
	public void  addStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String uid=request.getParameter("uid");
		String loginname=request.getParameter("loginname");
		String loginpass=request.getParameter("loginpass");
		RowData rowData=new RowData(uid, loginname, loginpass);
		boolean flag=studentService.add(rowData);
		response.getWriter().print(flag);
		
	}
	
	/*
	 * 删除学生信息
	 */
	public void  removeStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		String uidString=request.getParameter("uidString");
		boolean flag=studentService.removeStudent(uidString);
		response.getWriter().print(flag);
		
		
	}
	
	
	/*
	 * 返回所有学生信息
	 */
	public void datagridStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		int page=getPage(request);
		int rows=getRows(request);
		PageBean<Student> pageBean= studentService.findAll(page,rows);
		List<Student> studentList=pageBean.getBeanList(); 
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
