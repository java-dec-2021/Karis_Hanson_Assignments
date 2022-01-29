package com.karis.beltreviewer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.beltreviewer.models.Event;
import com.karis.beltreviewer.models.Message;
import com.karis.beltreviewer.models.User;
import com.karis.beltreviewer.repositories.EventRepository;
import com.karis.beltreviewer.repositories.MessageRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private MessageRepository messageRepository;
	
	//List All Events
	public List<Event> allEvents(){
		return eventRepository.findAll();
	}
	
	//List of Events by State 
	public List<Event> findEventByState(String state){
		return eventRepository.findByState(state);
	}
	
	//List of Events no in State
	public List<Event> findEventNotInState(String state){
		return eventRepository.findByStateIsNot(state);
	}
	
	//Get one Event
	public Event findEvent(Long id) {
		return eventRepository.findById(id).orElse(null);
	}
	
	//Create New Event
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}
	
	//Delete Event 
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}
	
	//Update Event
		public Event updateEvent(Event event) {
			return eventRepository.save(event);
		}
	
//	comment message on Event
	public void comment(User user, Event event, String message) {
		messageRepository.save(new Message(message,user,event));
	}
	
	//comment message on Event
//		public void comment(Message message) {
//			messageRepository.save(message);
//		}
//	
//	//manageAttendees
//	public void manageAtendees(Event event, User user, boolean isJoining) {
//		if(isJoining) {
//			event.getAttendees().add(user);
//		}else {
//			event.getAttendees().remove(user);
//		}
//		eventRepository.save(event);
//	}
//	
	//attend event
	public void attendEvent(Event event, User user) {
		List<User> attendees = event.getAttendees();
		attendees.add(user);
		eventRepository.save(event);
	}
	
	//Unattend event
	public void unattendEvent(Event event, User user) {
		List<User> attendees = event.getAttendees();
		attendees.remove(user);
		eventRepository.save(event);
	}
	
}
