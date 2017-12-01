package com.lovo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lovo.beans.Message;
import com.lovo.beans.User;


@Controller
public class LoginController {

	@RequestMapping("/Login.do")
	public String Login(@ModelAttribute("user") User user, Model model){
		System.out.println("进入");

		user.setName("小明");
		user.setSex("男");
		user.setUserName("叶良辰");
		model.addAttribute("user", user);
		
		return "index";
		
	}
	
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, Model model,String sss) throws InterruptedException{
		System.out.println(sss);
		model.addAttribute("user", user);
		System.out.println("进入提交Post");
		//模拟停顿10秒
		Thread.sleep(5000);
		System.out.println(user);
		return "redirect:register.do";
		//return "redirect:firstLogin.do";
		//return "index";
	}
	@RequestMapping(value="/register.do",method=RequestMethod.GET)
	public String registerGet(@ModelAttribute("user") User user, Model model,String sss) throws InterruptedException{
		System.out.println(sss);
		model.addAttribute("user", user);
		
		System.out.println("进入提交Get");
		return "index";
		
	}
	
	@RequestMapping("/firstLogin.do")
	public String fistLogin(@ModelAttribute("user") User user, Model model,String sss)
	{
		System.out.println("进入首次登陆");
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping("/fileUpload.do")
	public @ResponseBody Message fileUpload(HttpServletRequest request,@RequestParam("fileUpload") MultipartFile file,
			@RequestParam("fileName") String fileName,@ModelAttribute("user") User user,Model model,Message mes){
		
		//简单判断文件是否为空
		if(!file.isEmpty()){
			
			try {
				// 文件保存路径  
				String filePath = request.getSession().getServletContext().getRealPath("/") + "fileUpload/"  
	                    + file.getOriginalFilename();
				file.transferTo(new File(filePath));
				mes.setMessage("OK");
			} catch (Exception e) {
				mes.setMessage("NG");
				e.printStackTrace();
			}
		}
		user.setFile(fileName);
		System.out.println(fileName);
		model.addAttribute("user", user);
		System.out.println(user);
		return mes;
		
	}
}
