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

import com.karis.dojosninjas.models.Ninja;
import com.karis.dojosninjas.services.DojoService;
import com.karis.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired 
	private NinjaService ninjaService; 
	
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("/ninjas")
	public String index(Model model) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		model.addAttribute("ninjas", ninjas);
		return "ninjas.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("allDojos", dojoService.allDojos());
		return "newninja.jsp";
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.allDojos());
			return "newninja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos";
		}
	
	}
	@RequestMapping("/ninjas/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Ninja ninja = ninjaService.findNinja(id);
		model.addAttribute("ninja", ninja);
		return "showninja.jsp";
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
	
	@RequestMapping(value="/ninjas/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		ninjaService.deleteNinja(id);
		return "redirect:/dojos";
	}
}
