package com.test;

import java.util.ArrayList;
import java.util.List;

public class checkNameTest {

	public static void main(String[] args) {
		List<String> oldName = new ArrayList<String>();
		oldName.add("小明");
		oldName.add("小芳");
		oldName.add("张三");
		List<String> newName = new ArrayList<String>();
		newName.add("小芳");
		newName.add("小芳b");
		newName.add("小芳A");
		String flag  = "1";
		
		for (String name : newName) {
			if(!oldName.contains(name))
			{
				flag = "0";
				break;
			}
		}
		
//		
//		
//		for(int i = 0;i < oldName.size(); i++)
//		{
//			for(int j = 0; j < newName.size();j++)
//			{
//				if(!newName.get(j).equals(oldName.get(i)))
//				{
//					flag  = "0";
//					break;
//				}
//			}
//			if("0".equals(flag))
//			{
//				break;
//			}
//		}
//		if("1".equals(flag))
//		{
//			for(int j = 0; j < newName.size();j++)
//			{
//				for(int i = 0;i < oldName.size(); i++)
//				{
//					if(!newName.get(j).equals(oldName.get(i)))
//					{
//						flag = "0";
//						break;
//					}
//				}
//				if(flag == "0")
//				{
//					break;
//				}
//			}
//		}
		System.out.println(flag);
	}
}
