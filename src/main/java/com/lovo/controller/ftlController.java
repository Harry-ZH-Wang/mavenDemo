package com.lovo.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.beans.UserBean;

@Controller
@RequestMapping(value="/ftl")
public class ftlController {
    
    @RequestMapping(value="/firstFtl.do",method=RequestMethod.GET)
    public String  index(HttpServletRequest requset,HttpServletResponse response,Model mode) {
       
    	mode.addAttribute("msg", "hi freemarker");
    	
        return "MyFtl";
    }
    
    @RequestMapping(value="/expression.do")
    public String expressionTest(HttpServletRequest requset,HttpServletResponse response,Model mode)
    {
		//页面测试用集合,简单数据类型
    	
    	List<Object> testList = new ArrayList<Object>();
    	
    	testList.add("1");
    	testList.add("2");
    	testList.add("3");
    	mode.addAttribute("list",testList);
    	return "expressionTest";
    	
    }
    
    @RequestMapping(value="/expressionUser.do")
    public String expressionUset(HttpServletRequest requset,HttpServletResponse response,Model mode)
    {
    	
    	UserBean bean = new UserBean();
    	bean.setName("小明");
    	bean.setAge(20L);
    	bean.setSex(null);
    	//不对classBean做null处理
    	bean.setClassBean(null);
    	mode.addAttribute("user", bean);
    	
    	return "expressionUser";
    }
    
    @RequestMapping(value="/expressionAssagin.do")
    public String expressionAssagin(HttpServletRequest requset,HttpServletResponse response,Model mode)
    {
    	mode.addAttribute("root", "后台封装的变量");
    	return "expressionAssagin";
    }

}
