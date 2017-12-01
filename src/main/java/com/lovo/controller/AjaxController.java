package com.lovo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping(value = "/ajaxTest.do")
	public @ResponseBody Map<String, Object>ajaxTest(String ELTest01,String ELTest02,Model mode){
		
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer buffer = new StringBuffer();
		System.out.println(ELTest01);
		System.out.println(ELTest02);
		if((ELTest01!=null&&!("".equals(ELTest01)))&&(ELTest02!=null&&!("".equals(ELTest02)))){
			if(ELTest01.equals(ELTest02)){
				buffer.append("<option value ='volvo' selected='selected'>两个框输入值相等</option>");
			}else{
				buffer.append("<option value ='volvo' selected='selected'>两个框输入值不等</option>");
			}
			
		}
		System.out.println(buffer.toString());
		map.put("key", buffer.toString());
		return map;
	}
}
