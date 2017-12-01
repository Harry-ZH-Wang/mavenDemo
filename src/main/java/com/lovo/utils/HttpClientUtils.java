package com.lovo.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientUtils {
	
	public static String postHttp(String url,String body) {
		String mesg = null;
		//构建HttpClient实例
		HttpClient httpClient = new HttpClient();
		//设置请求超时时间
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
		//设置响应超时时间
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(60000);
		
		//构造PostMethod的实例
		PostMethod postMethod=new PostMethod(url);
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
		//封装消息体内容
		NameValuePair[] data = {new NameValuePair("xml",body)};
		postMethod.setRequestBody(data);
		/*List<NameValuePair> form = new ArrayList<>();
	    form.add(new BasicNameValuePair("tpl", req.getTpl()));
	    form.add(new BasicNameValuePair("bizNo", req.getBizNo()));
	    form.add(new BasicNameValuePair("reqTime", req.getReqTime() + ""));*/
		
		try {
			//执行post请求
			httpClient.executeMethod(postMethod);
			//可以对响应回来的报文进行处理
		    mesg = postMethod.getResponseBodyAsString();
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接释放资源的方法
			postMethod.releaseConnection();
			//((SimpleHttpConnectionManager)httpClient.getHttpConnectionManager()).shutdown();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		
		
		return mesg;
	}

	public static void main(String[] args) {
		
		String xml = "<?xml version='1.0' encoding='utf-8'?>"
				+ "<shopping><product code='1'>"
				+ "<name>老坛酸菜</name><"
				+ "price>3.5</price>"
				+ "<factory>统一</factory>"
				+ "</product><product code='2'>"
				+ "<name>加多宝</name>"
				+ "<price>6</price>"
				+ "<factory>加多宝</factory>"
				+ "</product>"
				+ "</shopping>";
		System.out.println(xml);
		String a  = postHttp("http://localhost:8080/Spring/htteTestServlet.do", xml);
		System.out.println("客户端"+a);
	}
}
