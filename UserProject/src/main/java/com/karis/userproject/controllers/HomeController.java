package com.karis.userproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.karis.userproject.models.Project;
import com.karis.userproject.models.User;
import com.karis.userproject.services.UserService;
import com.karis.userproject.services.ProjectService;
import com.karis.userproject.validator.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private ProjectService projectService;
	
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
	
	//***************dashboard routes***************
	//Dashboard
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		//if a user is in session
		if(session.getAttribute("userId")!=null) {
			List<Project> projects = projectService.allProjects();
			User user=userService.findById((Long)session.getAttribute("userId"));
			model.addAttribute("projects", projects);
			model.addAttribute("user", user);
			return "dashboard.jsp";
					
		}else {
			return "redirect:/";
		}
	}
	
	//New Project Page
	@GetMapping("/projects/new")
	public String index(@ModelAttribute("newProject") Project project, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
		return "new.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	//Create Project
	@PostMapping("/projects/create")
	public String createProject(@Valid @ModelAttribute("newProject") Project project,BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			if(result.hasErrors()) {
				return "new.jsp";
			}else {
				projectService.createProject(project);
				return "redirect:/dashboard";
			}
		}else {
			return "redirect:/";
		}
	}
	
	//Get One Project Details
	@GetMapping("/projects/{id}")
	public String getProject(@PathVariable("id") Long projectId, Model model, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			Project project=projectService.getOneProject(projectId);
			model.addAttribute("project", project);
			Long userId =(Long)session.getAttribute("userId");
			model.addAttribute("loggedInUser", userId);
			return "project.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	//Delete Project
	@GetMapping("projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long projectId, HttpSession session) {
		Project project = projectService.getOneProject(projectId);
		Long userId = project.getUser().getId();
		Long sessionId =(Long)session.getAttribute("userId");
		
		if(userId.equals(sessionId)) {
			projectService.deleteProject(projectId);
			return "redirect:/dashboard";
		}else {
			return "redirect:/";
		}
	}
	
	//Edit-page
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long projectId, @ModelAttribute("editedProject") Project project, Model model, HttpSession session) {
		Project editProject = projectService.getOneProject(projectId);
		Long userId = editProject.getUser().getId();
		Long sessionId =(Long)session.getAttribute("userId");

		if(userId.equals(sessionId)) {
//		Project editProject = projectService.getOneProject(projectId);
			model.addAttribute("editProject", editProject);
			return "edit.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	//Update Project
	@PostMapping("/projects/update/{id}")
	public String updateProject(@PathVariable("id") Long id, @Valid @ModelAttribute("editedProject") Project project, BindingResult result, Model model ) {
		if(result.hasErrors()) {
			Project editProject = projectService.getOneProject(id);
			model.addAttribute("editProject", editProject);
			return "edit.jsp";
		}else {
			projectService.updateProject(id, project.getProjectName(), project.getDescription());
			return "redirect:/dashboard";
		}
	}
	
	//Like Project
	@GetMapping("/projects/like/{projectId}")
	public String like(@PathVariable("projectId") Long projectId, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findById(userId);
			Project project = projectService.getOneProject(projectId);
			projectService.likeProject(project, user);
			return "redirect:/dashboard";
		}else {
			return "redirect:/";
		}
	}
	
	//Unlike Project
	@GetMapping("/projects/unLike/{projectId}")
	public String unLike(@PathVariable("projectId") Long projectId, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			Long userId = (Long) session.getAttribute("userId");
			User user = userService.findById(userId);
			Project project = projectService.getOneProject(projectId);
			projectService.unLikeProject(project, user);
			return "redirect:/dashboard";
		}else {
			return "redirect:/";
		}
	}
}





