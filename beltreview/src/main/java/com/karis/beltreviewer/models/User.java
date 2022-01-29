package com.karis.beltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="must include first name")
	@Size(min=2, max=200, message="First name should be between 2-200 characters")
	private String firstName;
	
	@NotBlank(message="must include last name")
	@Size(min=2, max=200, message="Last name should be between 2-200 characters")
	private String lastName;
	
	@Email
    private String email;
	
	@NotEmpty(message="must include city")
	private String city;
	
	@NotEmpty(message="must include state")
	private String state;
	
	@NotBlank
	@Size(min=8, max=255, message="Password should be at least 8 characters long")
    private String password;
	
	@NotBlank
    @Transient //don't save in database
    private String passwordConfirmation;
    
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	    
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
    
	@OneToMany(mappedBy="planner", fetch=FetchType.LAZY)
	private List<Event> eventsPlanned;
	
	@OneToMany(mappedBy="author", fetch=FetchType.LAZY)
	private List<Message> messages;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="attendance",
		joinColumns= @JoinColumn(name="user_id"),
		inverseJoinColumns= @JoinColumn(name="event_id")
		)
	private List<Event> eventsAttending;
	
    public User() {
    }
    
    
    
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public List<Event> getEventsPlanned() {
		return eventsPlanned;
	}



	public void setEventsPlanned(List<Event> eventsPlanned) {
		this.eventsPlanned = eventsPlanned;
	}



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}



	public List<Event> getEventsAttending() {
		return eventsAttending;
	}



	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@PrePersist
    protected void onCreate(){ //when object is created save the Date that the object is created at
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){ //when object is updated save the Date that the object is updated at
        this.updatedAt = new Date();
    }
    
}
