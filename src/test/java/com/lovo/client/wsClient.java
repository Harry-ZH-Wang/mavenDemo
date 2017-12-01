package com.lovo.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class wsClient {
	
	/**
	 * XML 类 第一个参数表示地址，第二个参数表示端口名
	 * 这里第一个参数是wsdl 表头targetNamespace
	 * 第二个参数是service name
	 */
	private static final QName SERVICE_NAME =  new QName("http://webservice.lovo.com/", "HelloService");
	private static final QName PORT_NAME = new QName("http://webservice.lovo.com/", "HellowServicePort");
	
	//编程方式一 begin -----------------------
	public static void testSayHello()
	{
		try {
			//创建Serivce业务类
			Service service = Service.create(SERVICE_NAME);
			//连接地址  <soap:address location="http://localhost:8080/Spring/webservice/HelloService"/>
			String endPointAddress = "http://localhost:8080/mavenDemo/webservice/HelloService";
			//配置业务访问参数 portName, bindingId, endpointAddress,
			//这里因为是SOPA11的所有配置11，SOAP现在有11和12两种 可通过xmlns:ns1="http://schemas.xmlsoap.org/soap/http" 判断
			service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endPointAddress);
			
			//把本地客户端的接口与网络上的WSDL连接起来
			HellowService hs = service.getPort(HellowService.class);
			System.out.println(hs.hello("小明"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//end-------------------------------------
	
	
	//编程方式二 begin  不知道为什么 Service.create报错，可能是jar原因-----------------------
	public static void testSayHello2()
	{
		try 
		{
			//创建WSDL的URL，注意不是服务地址  
			URL url = new URL("http://localhost:8080/mavenDemo/webservice?wsdl");
			//创建服务名，代码有写成了静态常量，这里直接引用
			
			//创建服务视图
			javax.xml.ws.Service service = Service.create(url, SERVICE_NAME);
			//获取服务实例
			HellowService hs = service.getPort(new QName("http://webservice.lovo.com/", "HellowServicePort"), HellowService.class);
			System.out.println(hs.hello("小明"));
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	//end-------------------------------------
	
	public static void main(String[] args) {
		testSayHello();
	    //testSayHello2();
	}

}
