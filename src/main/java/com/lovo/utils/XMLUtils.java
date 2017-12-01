package com.lovo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.lovo.beans.Product;

/**
 * XML简单工具类
 * 
 * @author WZH
 * 
 */
public class XMLUtils {

	/**
	 * 读取并解析XML文件方法
	 * @param xmlUrl 如果是读取本地工程文件使用此参数传入文件路径
	 * @param xml  如果是传入xml字符串使用此参数
	 * @return 解析后的XML字符串
	 */
	public List<Product> readXML(String xmlUrl, String xml) {
		
		List<Product> list=new ArrayList<Product>();
		FileInputStream inXml = null;
		Document doc = null;
		
		// 判断为需解析的XML为本地文件或xml字符串
		try {
			
			if (xmlUrl !=null && !("".equals(xmlUrl))) {
				inXml = new FileInputStream(new File(xmlUrl));
				SAXReader saxReader = new SAXReader();
				// xml文档对应实体文档
				doc = saxReader.read(inXml);

			}
			if (xml !=null &&!("".equals(xml))) {
				// 将xml格式字符串转化为DOM对象
				doc = DocumentHelper.parseText(xml);
			}
			
			//获取shopping根元素下所有子元素
			List<Element> elementList=doc.selectNodes("//shopping/product");
			
			//以直接通过标签获取到XML的值
			for (Element em : elementList) {
				Product temp=new Product();
				//得到product标签的属性
				temp.setId(Long.parseLong(em.attributeValue("code")));
				//获取标签内文本值的方法
				temp.setName(em.elementText("name"));
				temp.setPrice(Double.parseDouble(em.elementText("price")));
				temp.setFactory(em.elementText("factory"));
				list.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				
				if(inXml != null){
					inXml.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;

	}
	
	/**
	 * 创建一个XML实体文件的方法
	 * @param products 商品集合
	 * @param fileName 文件名
	 * @param src 文件保存地址
	 * @return true 创建成功，false 创建失败
	 */
	public boolean createXMLFile(List<Product> products,String fileName,String src){
		
		//默认创建成功
		boolean flag = true;
		try {
			//创建document对象
			Document document = DocumentHelper.createDocument();
			//创建根节点
			Element shoppingtElement = document.addElement("shopping");
			//加入一行注释
			shoppingtElement.addComment("这是一个商品的XML");
			//循环添加商品子节点
			for(int i = 0;i < products.size(); i++){
				//为shipping加入一个子节点
				Element product = shoppingtElement.addElement("product");
				//为product添加一个code属性
				product.addAttribute("code", String.valueOf(products.get(i).getId()));
				//为product添加子节点
				Element name = product.addElement("name");
				Element price = product.addElement("price");
				Element factory = product.addElement("factory");
				//给节点添加文本内容
				name.setText(products.get(i).getName());
				price.setText(String.valueOf(products.get(i).getPrice()));
				factory.setText(products.get(i).getFactory());
			}
			
			//生成XML文件
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			//判断保存目录是否存在
			File path = new File(src);
			if(!path.exists()){
				path.mkdirs();
				System.out.println("-----文件目录不存在，创建对应目录------------");
			}
			
			File xmlFile = new File(src+"\\"+fileName+".xml");
			XMLWriter writer = new XMLWriter(new FileOutputStream(xmlFile), format);
			writer.write(document);
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
		
	}
	
	/**
	 * 根据XML字符串创建一个实体XML文件
	 * @param products 商品集合
	 * @param fileName 文件名
	 * @param src 文件保存地址
	 * @param xmlStr 传入的xml格式文件
	 * @return true 创建成功，false 创建失败
	 */
	public boolean createXMLByStr(List<Product> products,String fileName,String src,String xmlStr){
		//默认转换成功
		boolean flag = true;
		try {
			//获取document对象
			Document document = DocumentHelper.parseText(xmlStr);
			//获取shopping根元素下所有子元素
			List<Element> elementList=document.selectNodes("//shopping/product");
			if(products.size() > 0){
				//模板中已经存在一条空白的标签，这里这么写是为了展现修改方法
				Element em = elementList.get(0);
			    em.addAttribute("code", String.valueOf(products.get(0).getId()));
			    em.element("name").setText(products.get(0).getName());
				em.element("price").setText(String.valueOf(products.get(0).getPrice()));
				em.element("factory").setText(products.get(0).getFactory());

			}
			//如果超过一条数据需要向XML追加节点
			if(products.size() > 1){
				//获取product节点上级父节点
				Element em = elementList.get(0).getParent();
				//循环添加商品子节点
				for(int i = 1;i < products.size(); i++){
					//为shipping加入一个子节点
					Element product = em.addElement("product");
					//为product添加一个code属性
					product.addAttribute("code", String.valueOf(products.get(i).getId()));
					//为product添加子节点
					Element name = product.addElement("name");
					Element price = product.addElement("price");
					Element factory = product.addElement("factory");
					//给节点添加文本内容
					name.setText(products.get(i).getName());
					price.setText(String.valueOf(products.get(i).getPrice()));
					factory.setText(products.get(i).getFactory());
				}
			}
			
			//生成XML文件
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			//判断保存目录是否存在
			File path = new File(src);
			if(!path.exists()){
				path.mkdirs();
				System.out.println("-----文件目录不存在，创建对应目录------------");
			}
			
			File xmlFile = new File(src+"\\"+fileName+".xml");
			XMLWriter writer = new XMLWriter(new FileOutputStream(xmlFile), format);
			writer.write(document);
			writer.flush();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
		
		return flag;
		
	}
	
	
	public static void main(String[] args) {
		XMLUtils util = new XMLUtils();
		List<Product> list=new ArrayList<Product>();
		list.add(new Product(1L, "电脑", 6666, "联想"));
		list.add(new Product(2L, "手机", 7777, "苹果"));
		list.add(new Product(3L, "电视", 8888, "索尼"));
		
		String xml = "<?xml version='1.0' encoding='utf-8'?>"
				+ "<shopping><product>"
				+ "<name></name><"
				+ "price></price>"
				+ "<factory></factory>"
				+ "</product>"
				+ "</shopping>";
		System.out.println(util.createXMLByStr(list, "test", "c:\\test",xml));
		
		
		//System.out.println(util.createXMLFile(list, "test", "c:\\test"));
		
		/*String src = "C:/shopping.xml";
		System.out.println("------读取XML文件并解析-------");
		System.out.println(util.readXML(src, null));
		
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
		System.out.println("------读取XML格式字符串并解析-------");
		System.out.println(util.readXML(null, xml));*/
		
	}
}
