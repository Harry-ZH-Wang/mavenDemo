package com.lovo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lovo.beans.DateBean;

@Controller
public class DateController {
	@RequestMapping("/day.do")
	public String DateShow(Model model){
		Date d = new Date();
		DateBean day = new DateBean();
		day.setDate(d);
		model.addAttribute("date", day);
		return "DayShow";
	}

}
