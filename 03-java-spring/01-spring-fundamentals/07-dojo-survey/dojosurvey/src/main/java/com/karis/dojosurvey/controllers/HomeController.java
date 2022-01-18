package com.karis.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karis.dojosurvey.models.Survey;

@Controller
public class HomeController {
	private String[] getLanguages() {
		return new String[] {"C++", "Java", "Python", "MERN"};
	}
	private String[] getLocations() {
		return new String[] {"Seattle", "Dallas", "San Jose", "Chicago","Online"};
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("locations", getLocations());
		model.addAttribute("languages", getLanguages());
		
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String submit(@RequestParam("name") String name, @RequestParam("location") String location, 
			@RequestParam("language") String language, @RequestParam("comment") String comment, Model model) {
			
			model.addAttribute("result", new Survey(name,location,language,comment));
		
			if(language.equals("Java")) {
				return "java.jsp";
			}
			return "result.jsp";
	}
	
	
}
