package com.karis.dojooverflow.controllers;

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

import com.karis.dojooverflow.models.Answer;
import com.karis.dojooverflow.models.Question;
import com.karis.dojooverflow.models.Tag;
import com.karis.dojooverflow.services.AnswerService;
import com.karis.dojooverflow.services.QuestionService;
import com.karis.dojooverflow.services.TagService;



@Controller
public class HomeController {
	@Autowired 
	private QuestionService questionService; 
	@Autowired
	private TagService tagService;
	@Autowired 
	private AnswerService answerService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions")
	public String allQuestions(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "questions.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newquestion.jsp";
	}
	
	@RequestMapping(value="/questions/new", method=RequestMethod.POST)
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {

		if(result.hasErrors()) {
			return "newquestion.jsp";
		}else {
			//Check if Tag is already in the database (request Param?)
			//If yes, add it to the question, but don't go to (Save) method
			//if no, save the new tag 
			
			questionService.createQuestion(question);
			return "redirect:/questions";
		}
	
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		Question question = questionService.findQuestion(id);
		model.addAttribute("question", question);
		
		return "showQuestion.jsp";
	}
	
	//@PostMapping("/answers")
	
	
//	@RequestMapping(value="/addProduct/{id}", method=RequestMethod.POST)
//	public String addProduct(@PathVariable("id") Long category_id, @RequestParam("product") Long product_id) {
//		Tag product =productService.findProduct(product_id);
//		Question category = categoryService.findCategory(category_id);
//		categoryService.addRelationship(category, product);
//		return "redirect:/categories/{id}";
//	}
}
	

