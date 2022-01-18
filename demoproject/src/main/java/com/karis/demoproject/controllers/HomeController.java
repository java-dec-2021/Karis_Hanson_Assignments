package com.karis.demoproject.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HomeController {

	@RequestMapping("/")
	public String hello(@RequestParam(value="q", required = false)String searchQuery) {
		return "You searched for: "+ searchQuery;
	}
	
	@RequestMapping("/users/{name}")
	public String welcome(@PathVariable("name") String userName) {
		return "Welcome "+ userName;
	}
}
