package com.lovo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.Log4jTest;

@Controller
public class httpClientServer {

	Logger log=Logger.getLogger(httpClientServer.class);
	
	@RequestMapping(value="/htteTestServlet.do",method=RequestMethod.POST)
	public void doPostServer(HttpServletRequest request, HttpServletResponse response){

		try {
			//设置编码集
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			//方法1 ，从消息体中取值
			//获取消息体内容
			BufferedReader reader = request.getReader();
			StringBuffer buffer = new StringBuffer();
			String temp = null;
			while((temp = reader.readLine()) != null){
				System.out.println(temp);
				buffer.append(temp);
			}
			//进行URL解码
			String rspTtr = URLDecoder.decode(buffer.toString(),"utf-8");
			//返回处理后的消息体
			response.getOutputStream().write(rspTtr.getBytes("UTF-8"));
			
			//方法2：因为封装到body，也可以直接用gerparameter取值
			//对请求的报文进行处理
/*			String xml = request.getParameter("xml");
			System.out.println("服务端"+xml);
			//响应客户端，返回报文
			response.getOutputStream().write(xml.getBytes("UTF-8"));*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
