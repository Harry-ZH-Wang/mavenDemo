package com.lovo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovo.utils.CPTest;

@Controller
public class CopyController {

	@RequestMapping(value = "/copy.do")
	public void copy(String oldPath,String newPath,String sex,String check){
		System.out.println(sex+"     "+check);
		//System.out.println(oldPath);
		//System.out.println(newPath);
		//CPTest t = new CPTest();
		//t.copyTest(oldPath, newPath);
	}
}
