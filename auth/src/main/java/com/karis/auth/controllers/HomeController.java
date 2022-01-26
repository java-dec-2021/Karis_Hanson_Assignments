package com.karis.auth.controllers;

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

import com.karis.auth.models.User;
import com.karis.auth.services.UserService;
import com.karis.auth.validator.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	//Register a User
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult results,
			HttpSession session) {
		userValidator.validate(user,results);
		
		if(results.hasErrors()) {
			return "index.jsp";
		}else {
			//register the new user
			User newUser=userService.registerUser(user);
			//put userId into session
			session.setAttribute("userId", newUser.getId());
			
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
	
	//***************dashboard routes***************
	//Dashboard
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		//if a user is in session
		if(session.getAttribute("userId")!=null) {
			User user=userService.findById((Long)session.getAttribute("userId"));
			model.addAttribute("user", user);
			return "dashboard.jsp";
					
		}else {
			return "redirect:/";
		}
	}
	
}
