package com.lovo.controller;

import java.lang.reflect.Field;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovo.beans.UserInfo;
import com.lovo.utils.ReflectHWUtils;



@Controller
public class MusctTestController {
	
	@RequestMapping("/test.do")
	public void test01(UserInfo userInfo)
	{
		System.out.println(userInfo);
		

		if(userInfo.getMusic() !=null){
			for(int i = 0 ;i<userInfo.getMusic().size();i++){
				try {
					boolean isNull = ReflectHWUtils.isNullObject(userInfo.getMusic().get(i), true);
					if(!isNull)
					{
						System.out.println(userInfo.getMusic().get(i));
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				

				
			}
		}
	}

}
