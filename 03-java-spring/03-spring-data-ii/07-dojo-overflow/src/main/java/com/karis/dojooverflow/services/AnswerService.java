package com.karis.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.dojooverflow.models.Answer;
import com.karis.dojooverflow.models.Question;
import com.karis.dojooverflow.models.Tag;
import com.karis.dojooverflow.repositories.AnswerRepository;
import com.karis.dojooverflow.repositories.QuestionRepository;
import com.karis.dojooverflow.repositories.TagRepository;

@Service
public class AnswerService {
	@Autowired
	private QuestionRepository questionRepository; 
	
	@Autowired
	private TagRepository tagRepository; 
	
	@Autowired
	private AnswerRepository answerRepository;
	
	//Find All Answers
	public List<Answer> allAnswers() {
		return this.answerRepository.findAll();
			 
	}
	//Create Answer
	public Answer createAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	//retrieve a Answer
	public Answer findAnswer(Long id) {
		return this.answerRepository.findById(id).orElse(null);
	}
	
	//Update Answer
		public Answer updateAnswer(Answer answer) {
			return answerRepository.save(answer);
		}
	
	
	 //Delete 
	 public void deleteAnswer(Long id) {
		 this.answerRepository.deleteById(id);
	 }
	 
}
