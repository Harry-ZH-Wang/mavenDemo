package com.lovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovo.beans.ContantsBean;

@Controller
public class ContantsController {
	
	@RequestMapping("/contantsTest.do")
	public String ContantsTest(Model mode)
	{
		//这里模拟数据库查询出的数据,语言字段存的为1
		ContantsBean test = new ContantsBean("language");
		test.setKey("02");
		mode.addAttribute("test", test);
		return "contantsTest";
		
	}

}
