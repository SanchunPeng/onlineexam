package cn.zjlg.onlineexam.question.servlet;

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
import cn.itcast.servlet.BaseServlet;
import cn.zjlg.onlineexam.question.domain.Made;
import cn.zjlg.onlineexam.question.service.Made1Service;

@SuppressWarnings("serial")
public class Made1Servlet extends BaseServlet {
	Made1Service made1Service=new Made1Service();  
	public void datagridMade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SQLException {
		List<Made> madeList=new ArrayList<Made>(); 
		madeList=made1Service.getMade();
		Map map=new HashMap();
		map.put("total", 4);
		map.put("rows", madeList);
		//将对象转化成JSON字符串
		response.getWriter().print(JSONObject.fromObject(map));
		response.getWriter().close();
	}

}
