package com.lovo.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 键值对方式处理公用常量对象
 * @author WZH
 *
 */
public class ContantsBean {
	
	/**
	 * 常量名
	 */
	private String key;
	
	/**
	 * 常量值
	 */
	private String value;
	
	/**
	 * 常量类型
	 */
	private String model;
	
	private List<ContantsBean> contants;
	
	
	//实际开发中在此不就加载在项目启动中已经加载到内存或缓存中的值,此段后面的静态块和静态常量不要
	//public  List<Map<String, List<ContantsBean>>> contantsList = ContantsInit(model);
	
	/**
	 * 常量集合
	 */
	public static List<Map<String, List<ContantsBean>>> contantsList;

	/**
	 * 这里直接初始化一下，实际情况中为常量表中或配置中查询出的值
	 */
	static
	{
		contantsList = new ArrayList<>();
		ContantsBean c1 = new ContantsBean("01", "中文");
		ContantsBean c2 = new ContantsBean("02", "英文");
		ContantsBean c3 = new ContantsBean("03", "日文");
		List<ContantsBean> ListTemp1 = new ArrayList<>();
		ListTemp1.add(c1);
		ListTemp1.add(c2);
		ListTemp1.add(c3);
		Map<String, List<ContantsBean>> MapTemp1 = new HashMap<String, List<ContantsBean>>();
		MapTemp1.put("language", ListTemp1);
		
		ContantsBean c4 = new ContantsBean("01", "中国");
		ContantsBean c5 = new ContantsBean("02", "英国");
		ContantsBean c6 = new ContantsBean("03", "日本");
		List<ContantsBean> ListTemp2 = new ArrayList<>();
		ListTemp2.add(c4);
		ListTemp2.add(c5);
		ListTemp2.add(c6);
		
		Map<String, List<ContantsBean>> MapTemp2 = new HashMap<String, List<ContantsBean>>();
		MapTemp2.put("contry", ListTemp2);
		contantsList.add(MapTemp1);
		contantsList.add(MapTemp2);
	}
	
	public ContantsBean() {
		super();
	}

	
	
	public ContantsBean(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}


    /**
     * 通过常量类型 初始化对应常量集合
     * @param model
     */
	public ContantsBean(String model) {
		super();
		this.model = model;
		for (Map<String, List<ContantsBean>> temp : contantsList) 
		{
			if(null != temp.get(model))
			{
				this.contants = temp.get(model);
				break;
			}
			
		}
		
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 通过键取值
	 * @return
	 */
	public String getValue() {
		for (ContantsBean bean : contants) 
		{
			if(this.key.equals(bean.getKey()))
			{
				return bean.getThisValue();
			}
		}
		
		return "";
	}

	/**
	 * get方法已经更改，重新定义一个私有的获取本类值的方法
	 * @return
	 */
	private String getThisValue() 
	{
		return value;
	}	
	public void setValue(String value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		ContantsBean test = new ContantsBean("language");
		test.setKey("01");
		System.out.println(ContantsBean.class.getName());
		System.out.println(test.getValue());
	}
	
}
