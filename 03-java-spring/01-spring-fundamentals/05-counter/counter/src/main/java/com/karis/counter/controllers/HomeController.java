package com.karis.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		// If count is not already in session
		if(session.getAttribute("count") == null) {
			//Use setAttribute to initialize the count in session
			session.setAttribute("count", 1);
		} else {
			//increment the count by 1 using getAttribue and setAttribue
			 Integer theCount = (Integer) session.getAttribute("count");
			 Integer newCount = theCount+1;
			 System.out.println("theCount"+ theCount);
			 System.out.println("newCount"+ newCount);
			 session.setAttribute("count", newCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		System.out.println("CurretnCount: "+currentCount);
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
	
	@RequestMapping("/destroy_session")
	public String delete_visits(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("countToShow", 0);
		return "counter.jsp";
	}
	@RequestMapping("/increment")
	public String increment_by_2(HttpSession session) {
	// If count is not already in session
			if(session.getAttribute("count") == null) {
				//Use setAttribute to initialize the count in session
				session.setAttribute("count", 2);
			} else {
				//increment the count by 2 using getAttribue and setAttribue
				Integer theCount = (Integer) session.getAttribute("count");
				Integer newCount = theCount+2;
		
				session.setAttribute("count", newCount);
			}
			return "counter2.jsp";
	}
	
}
