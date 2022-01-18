package com.karis.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	private Boolean isCorrect(String guess) {
		return guess.equals("bushido");
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/guess")
	public String welcome(@RequestParam("code") String code, RedirectAttributes redirectAtt) {
		
//		if(code.equals("bushido")) {
//			return "redirect:/code";
//		}
		if(isCorrect(code)) {
			return "redirect:/code";
		}
		
		redirectAtt.addFlashAttribute("error", "You do not know the way");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String code(Model model) {
		String[] words = {"Loyalty", "Courage", "Veracity", "Compassion","Honor"};
		model.addAttribute("words",words);
		return "code.jsp";
		
	}
}
