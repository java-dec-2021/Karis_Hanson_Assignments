package com.karis.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.karis.dojosninjas.models.Dojo;
import com.karis.dojosninjas.services.DojoService;


@Controller
public class HomeController {

	@Autowired 
	private DojoService dojoService; 
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/dojos";
	}
	
	@RequestMapping("/dojos")
	public String dojos(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newdojo.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	
	}
	@RequestMapping("/dojos/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		return "showdojo.jsp";
	}
	
//	@RequestMapping("languages/{id}/edit")
//	public String edit(@PathVariable("id") Long id, Model model) {
//		Language language = languageService.findLanguage(id);
//		model.addAttribute("language", language);
//		return "edit.jsp";
//	}
	
//	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
//	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
//		if(result.hasErrors()) {
//			return "edit.jsp";
//		}else {
//			languageService.updateLanguage(id,language);
//			return "redirect:/languages";
//		}
//	}
	
	@RequestMapping(value="/dojos/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		dojoService.deleteDojo(id);
		return "redirect:/dojos";
	}
	
}
