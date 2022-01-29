package com.karis.beltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.karis.beltreviewer.models.State;
import com.karis.beltreviewer.models.User;
import com.karis.beltreviewer.services.UserService;
import com.karis.beltreviewer.validator.UserValidator;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("states",State.States);
		return "index.jsp";
	}
	//Register a User
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult results,
			HttpSession session, Model model) {
			userValidator.validate(user,results);
		
		if(results.hasErrors()) {
			model.addAttribute("states",State.States);
			return "index.jsp";
		}else {
			//register the new user
			User newUser=userService.registerUser(user);
			//put userId into session
			session.setAttribute("userId", newUser.getId());
			session.setAttribute("userName", newUser.getFirstName());
			
			return "redirect:/dashboard";
		}
	}
	//login user
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
		//if the user is authenticated, save their user id in session
		if(userService.authenticateUser(email, password)) {
			User user=userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getFirstName());
			return "redirect:/dashboard";
		}else {
			
			redirectAttributes.addFlashAttribute("error", "Invalid user/password");
			return "redirect:/";
		}
	}
	//logout user
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
