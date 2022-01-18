package com.karis.lookify.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.karis.lookify.models.Lookify;
import com.karis.lookify.services.LookifyService;

@Controller
public class LookifyController {
	
	@Autowired
	private LookifyService lookifyService;
	
//	private final LanguageService languageService;
//	public LanguagesController(LanguageService languageService) {
//		this.languageService = languageService;
//	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("lookify") Lookify lookify) {
		List<Lookify> lookifys = lookifyService.allLookify();
		model.addAttribute("lookifys", lookifys);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("lookify") Lookify lookify) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			lookifyService.createLookify(lookify);
			return "redirect:/dashboard";
		}
	
	}
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lookify lookify = lookifyService.findLookify(id);
		model.addAttribute("lookify", lookify);
		return "show.jsp";
	}
	
//	@RequestMapping("languages/{id}/edit")
//	public String edit(@PathVariable("id") Long id, Model model) {
//		Lookify language = languageService.findLanguage(id);
//		model.addAttribute("language", language);
//		return "edit.jsp";
//	}
	
//	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
//	public String update(@Valid @ModelAttribute("language") Lookify language, BindingResult result, @PathVariable("id") Long id) {
//		if(result.hasErrors()) {
//			return "edit.jsp";
//		}else {
//			languageService.updateLanguage(id,language);
//			return "redirect:/languages";
//		}
//	}
	
	@RequestMapping("/search/TopTen")
	public String top(Model model) {
		List<Lookify> topTen = lookifyService.getTopTen();
		model.addAttribute("topTen", topTen);
		return "top.jsp";
	}
	
	@RequestMapping(value="/songs/search")
	public String search(@RequestParam("search") String search, Model model) {
		List<Lookify> searchResults = lookifyService.searchLookify(search);
		model.addAttribute("results", searchResults);
		model.addAttribute("artist", search);
		return "search.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		lookifyService.deleteLookify(id);
		return "redirect:/dashboard";
	}
	
	
}

