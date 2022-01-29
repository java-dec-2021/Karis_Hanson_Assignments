package com.karis.beltreviewer.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.karis.beltreviewer.models.Event;
import com.karis.beltreviewer.models.Message;
import com.karis.beltreviewer.models.State;
import com.karis.beltreviewer.models.User;
import com.karis.beltreviewer.services.EventService;
import com.karis.beltreviewer.services.UserService;

@Controller
public class EventController {
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService; 
	
	private String now() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	
	//Dashboard Route
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		//if a user is in session
		if(session.getAttribute("userId")!=null) {
			User user =userService.findById((Long)session.getAttribute("userId"));
			List<Event> eventsInState = eventService.findEventByState(user.getState());
			List<Event> eventsOutState=eventService.findEventNotInState(user.getState());
			model.addAttribute("eventsInState", eventsInState);
			model.addAttribute("eventsOutState", eventsOutState);
			model.addAttribute("user", user);
			return "dashboard.jsp";
						
		}else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/events/new")
	public String newEvent(HttpSession session, @ModelAttribute("newEvent") Event event, Model model) {
		if(session.getAttribute("userId")!=null) {
			model.addAttribute("states", State.States);
			model.addAttribute("now", now());
			return "new.jsp";
		}else {
			return "redirect:/";
		}
	
	}
	@PostMapping("/events/create")
	public String createEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("now",now());
			model.addAttribute("states", State.States);
			model.addAttribute("newState", event.getState());
			return "new.jsp";
		}else {
			eventService.createEvent(event);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/events/edit/{eventId}")
	public String editEvent(HttpSession session, @ModelAttribute("editedEvent") Event event, Model model, @PathVariable("eventId") Long id) {
		Event oldEvent = eventService.findEvent(id);
		Long userId = oldEvent.getPlanner().getId();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date =df.format(oldEvent.getEventDate());
		Long sessionId = (Long)session.getAttribute("userId");
		if(userId.equals(sessionId)) {
				model.addAttribute("oldEvent", oldEvent);
				model.addAttribute("states", State.States);
				model.addAttribute("date", date);
				return "edit.jsp";
		}else {
			return "redirect:/";
		}
	
	}
	@PostMapping("/events/update/{id}")
	public String updateEvent(@Valid @ModelAttribute("editedEvent") Event event,BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			model.addAttribute("states", State.States);
			model.addAttribute("oldEvent", eventService.findEvent(id));
			return "edit.jsp";
		}else {
			eventService.updateEvent(event);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/events/delete/{eventId}")
	public String deleteEvent(@PathVariable("eventId") Long id, HttpSession session) {
		Event event = eventService.findEvent(id);
		Long userId = event.getPlanner().getId();
		Long sessionId = (Long)session.getAttribute("userId");
		if(userId.equals(sessionId)) {
			eventService.deleteEvent(id);
			return "redirect:/dashboard";
		}else {
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/events/{eventId}")
	public String showEvent(@PathVariable("eventId") Long id, HttpSession session, Model model, @ModelAttribute("message") Message message) {
		if(session.getAttribute("userId")!=null) {
			User loggedInUser =userService.findById((Long)session.getAttribute("userId"));
			Event event = eventService.findEvent(id);
			
			model.addAttribute("event", event);
			model.addAttribute("loggedInUser", loggedInUser);
			return "show.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	//AttendEvent
	@GetMapping("events/{eventId}/a/join")
	public String attend(@PathVariable("eventId") Long eventId, HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			User loggedInUser =userService.findById((Long)session.getAttribute("userId"));
			Event event = eventService.findEvent(eventId);
			eventService.attendEvent(event, loggedInUser);
			return "redirect:/dashboard";
			
		}else {
			return "redirect:/";
		}
	}
	//Unattend Event
		@GetMapping("events/{eventId}/a/cancel")
		public String unattend(@PathVariable("eventId") Long eventId, HttpSession session) {
			if(session.getAttribute("userId")!=null) {
				User loggedInUser =userService.findById((Long)session.getAttribute("userId"));
				Event event = eventService.findEvent(eventId);
				eventService.unattendEvent(event, loggedInUser);
				return "redirect:/dashboard";
				
			}else {
				return "redirect:/";
			}
		}
		
	//Add Message comment
		@PostMapping("events/{eventId}/comment")
		public String comment(@RequestParam("message") String message, @PathVariable("eventId") Long eventId, HttpSession session,RedirectAttributes redirs, Model model) {
			Long userId =(Long)session.getAttribute("userId");
			User loggedInUser =userService.findById(userId);
			Event event = eventService.findEvent(eventId);
			if(userId==null) {
				return "redirect:/";
			}
			if(message.equals("")) {
				model.addAttribute("event", event);
				model.addAttribute("loggedInUser", loggedInUser);
				redirs.addFlashAttribute("error", "Comment cannot be blank");
				return "redirect:/events/{eventId}";
			}
			eventService.comment(loggedInUser, event, message);
			return "redirect:/events/{eventId}";
			
		}
	
	
	
}
