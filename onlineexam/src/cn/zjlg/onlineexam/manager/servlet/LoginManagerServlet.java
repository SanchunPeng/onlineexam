package cn.zjlg.onlineexam.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.manager.domain.Json;
import cn.zjlg.onlineexam.manager.domain.Manager;
import cn.zjlg.onlineexam.manager.service.ManagerService;

@SuppressWarnings("serial")
public class LoginManagerServlet extends BaseServlet {
	ManagerService managerService = new ManagerService();

	/*
	 * 登录验证
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		Manager manager = managerService.login(name, password);
		Json json = new Json();
		if (manager == null) {
			json.setSuccess(false);
			json.setMsg("用户名或密码错误");
			response.getWriter().print(json.toString());
			response.getWriter().close();
		} else {
			json.setSuccess(true);
			json.setMsg("登录成功");
			response.getWriter().print(json);
			response.getWriter().close();
		}
	}

}
