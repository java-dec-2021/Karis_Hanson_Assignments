package com.karis.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private Date getDate() {
		Date now = new Date();
		return now;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
		
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		
		model.addAttribute("date", getDate());
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		
		model.addAttribute("time", getDate());
		return "time.jsp";
	
	}
	
}
