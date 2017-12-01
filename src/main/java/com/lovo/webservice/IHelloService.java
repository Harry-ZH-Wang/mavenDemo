package com.lovo.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * SOAP协议的webservice接口
 * @author WZH
 *服务器端，服务提供者
 */

/*
 * @WebService 标记为一个webservice接口
 * 1.targetNamespace：指定你想要的名称空间，默认认是使用接口实现类的包名的反缀，
 * 但是在实际测试中发现cxf+spring编写webservice的时候，targetNamespace要指向
 * 服务类的接口所在的包名而不是实现类的包名，否则，在客户端将不能识别可用的服务
 * 2.serviceName： 对外发布的服务名，指定 Web Service 的服务名称：wsdl:service。
 * 缺省值为 Java 类的简单名称 + Service。（字符串）
 * 3.portName：  wsdl:portName。缺省值为 WebService.name+Port。
 * 
 * @SOAPBinding 消息绑定， 这个标记怎么说，我这里测试的时候加不加都无所谓，但是有同仁说过
 * 不加这个有时候会出现客户端无法识别，有的人又报错，所以还是加上吧
 * Exception in thread "main" com.sun.xml.internal.ws.model.RuntimeModelerException: 
 * runtime modeler error: Wrapper class org.soap.service.jaxws.Add is not found. Have you run APT to generate them?
 */
@WebService(targetNamespace ="http://webservice.lovo.com/",serviceName="HelloService",portName="HellowServicePort")
@SOAPBinding(style=Style.RPC)
public interface IHelloService {
	
	/*
	 * @WebResult 注释用于定制从返回值至 WSDL 部件或 XML 元素的映射。将此注释应用于客户机或服务器服务端点接口（SEI）上的方法，
	 * 或者应用于 JavaBeans 端点的服务器端点实现类
	 * 1.name：当返回值列示在 WSDL 文件中并且在连接上的消息中找到该返回值时，指定该返回值的名称。对于 RPC 绑定，这是用于表示返回值的
	 * 2.targetNamespace：指定返回值的 XML 名称空间。仅当操作类型为 RPC 或者操作是文档类型并且参数类型为 BARE 时才使用此参数。（字符串）
	 * 
	 * @WebMethod 注释表示作为一项 Web Service 操作的方法，将此注释应用于客户机或服务器服务端点接口（SEI）上的方法，
	 * 或者应用于 JavaBeans 端点的服务器端点实现类。
	 * 1.operationName：指定与此方法相匹配的wsdl:operation 的名称。缺省值为 Java 方法的名称。（字符串）
	 * 
	 * @WebParam 注释用于定制从单个参数至 Web Service 消息部件和 XML 元素的映射
	 * 1.name ：参数的名称。如果操作是远程过程调用（RPC）类型并且未指定partName 属性，
	 * 那么这是用于表示参数的 wsdl:part 属性的名称。如果操作是文档类型或者参数映射至某个头，那么 -name 是用于表示该参数的 XML 元素的局部名称。
	 * 如果操作是文档类型、参数类型为 BARE 并且方式为 OUT 或 INOUT，那么必须指定此属性。（字符串）
	 */
	
	@WebResult(name="helloRequest",targetNamespace="http://webservice.lovo.com/")
	@WebMethod(operationName="sayHello1")
	public String hello(@WebParam(name="msg")String message);
	
	@WebResult(name="loginRequest",targetNamespace="http://webservice.lovo.com/")
	@WebMethod(operationName="login")
	public String login(@WebParam(name="userName")String userName,@WebParam(name="password")String password);
}
