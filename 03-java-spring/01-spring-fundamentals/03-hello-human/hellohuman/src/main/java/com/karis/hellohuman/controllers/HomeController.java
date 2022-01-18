package com.karis.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {

//	@RequestMapping("/home")
//	public String index() {
//		return "Hello Human";
//	}
//	
	@RequestMapping("/")
	public String name(
			@RequestParam(value="name", required = false, defaultValue="Human") String name,
			@RequestParam(value="last_name", required = false, defaultValue="") String lastName,
			@RequestParam(value = "times", required = false, defaultValue="") String times,
			Model model){

		System.out.println(name);
		System.out.println(lastName);
		System.out.println(times);
		
		model.addAttribute("name", name);
		model.addAttribute("lastName", lastName);
		model.addAttribute("times",times);
		
		return "index.jsp";
	}
	
//	
//	@RequestMapping("/name")
//	public String nameTimes(@RequestParam(value="name") String name, @RequestParam(value="times") int number) {
//		 String nameNum = "";
//		 for(int i = 0; i < number; i++) {
//			 nameNum = nameNum + "Hello " + name + " ";
//		 }
//		 return nameNum;
//		 
//		
//	}
}
	
