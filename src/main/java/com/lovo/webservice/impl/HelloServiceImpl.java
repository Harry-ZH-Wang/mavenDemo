package com.lovo.webservice.impl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.stereotype.Service;

import com.lovo.webservice.IHelloService;

/*
 * endpointInterface： 服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口,简单的说就写接口的全路径
 */
@WebService(endpointInterface="com.lovo.webservice.IHelloService")
@SOAPBinding(style=Style.RPC)
public class HelloServiceImpl implements IHelloService {

	@Override
	public String hello(String message) {
		
		return "你好" + message;
	}

	@Override
	public String login(String userName, String password) {
		String req = null;
		//这里做个假的登录验证
		if("小明".equals(userName)&&"123456".equals(password))
		{
			req = "登录成功";
		}else
		{
			req = "登录失败";
		}
		return req;
	}

}
