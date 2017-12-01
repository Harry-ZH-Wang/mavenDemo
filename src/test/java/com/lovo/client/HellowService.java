package com.lovo.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * 客户端调用者，根据wsdl初始化接口对象
 * @author WZH
 *
 *targetNamespace 对应wsdl抬头 targetNamespace，serviceName和portName分别对应wsdl结尾的wsdl:service name="HelloService"
 *和wsdl:port binding="tns:HelloServiceSoapBinding" name="HellowServicePort">
 *因为wsdl文档中有指定SOAP类型,所以需书写类型 <soap:operation soapAction="" style="rpc"/>
 */
@WebService(targetNamespace="http://webservice.lovo.com/",serviceName="HelloService",portName="HellowServicePort")
@SOAPBinding(style=Style.RPC)
public interface HellowService {
	/**
	 * 方法名对应wsdl wsdl:operation name="login"
	 * @param username 参数名对应 wsdl:part name="userName" type="xsd:string"
	 * @param password
	 * @return
	 * 
	 * 方法名映射 <wsdl:operation name="login">
	 * 	地址映射<soap:body namespace="http://webservice.lovo.com" use="literal"/>
	 * 参数映射：<wsdl:part name="userName" type="xsd:string"> <wsdl:part name="password" type="xsd:string">
	 */
	@WebResult(name="login",targetNamespace="http://webservice.lovo.com/")
	@WebMethod(operationName = "login")
	public String login(@WebParam(name = "userName")String username , @WebParam(name = "password")String password);
	
	@WebResult(name="helloRequest",targetNamespace="http://webservice.lovo.com/")
	@WebMethod(operationName="sayHello1")
	public String hello(@WebParam(name="msg")String msg);
	
}
