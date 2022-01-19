package com.karis.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Size(min=2, max=50, message="Subject should be between 2-50 characters")
	private String subject;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; 
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt; 
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="tags_questions",
		joinColumns=@JoinColumn(name="tag_id"),
		inverseJoinColumns=@JoinColumn(name="question_id")
		)
	private List<Question> questions; 
	
	public Tag() {
		
	}

	public Tag(String subject, List<Question> questions) {
		this.subject = subject;
		this.questions = questions;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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
