package com.lovo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lovo.dao.IstudentDao;




@Controller
public class JmeterController {
	
	@Autowired
	@Qualifier(value="studentDao")
	private IstudentDao studentDao;
	
	int count = 0;
	
	@RequestMapping(value = "/jemter.do",method=RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String time = request.getParameter("time");
		String name = studentDao.selectStudent(1L).getStudentName();
		PrintWriter out = response.getWriter();
		count++;
		System.out.println("数据库查询结果"+name+"访问时间戳："+time+"访问次数为："+count+" 次");
		out.write("数据库查询结果"+name+"访问时间戳："+time+"访问次数为："+count+" 次");
	}
}
