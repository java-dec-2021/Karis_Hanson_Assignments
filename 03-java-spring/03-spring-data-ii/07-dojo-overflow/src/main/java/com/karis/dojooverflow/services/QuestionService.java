package com.karis.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.dojooverflow.models.Question;
import com.karis.dojooverflow.models.Tag;
import com.karis.dojooverflow.repositories.AnswerRepository;
import com.karis.dojooverflow.repositories.QuestionRepository;
import com.karis.dojooverflow.repositories.TagRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository; 
	
	@Autowired
	private TagRepository tagRepository; 
	
	@Autowired
	private AnswerRepository answerRepository;
	
	//Find All Questions
	public List<Question> allQuestions() {
		return this.questionRepository.findAll();
			 
	}
	//Create Question
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	//retrieve a Question
	public Question findQuestion(Long id) {
		return this.questionRepository.findById(id).orElse(null);
	}
	
	//Update Questiono
		public Question updateQuestion(Question question) {
			return questionRepository.save(question);
		}
	
	
	 //Delete 
	 public void deleteQuestion(Long id) {
		 this.questionRepository.deleteById(id);
	 }
	 
	 //Find Tags that belong to the Question
	 public List<Tag> findTagsofQuestion(Question question){
		 return tagRepository.findAllByQuestions(question);
	 }
	 
	 //Find Tags that don't belong to the Question
	 public List<Tag> findTagsNotofQuestion(Question question){
		 return tagRepository.findByQuestionsNotContains(question);
	 }
	 
	 //Add Relationship
	 public void addRelationship(Question question, Tag tag) {
		 //add "tag" to this questions list of tags 
		 question.getTags().add(tag);
		 // Save the "question" because changes were made to the tags list. 
		questionRepository.save(question);
		 
	 }
	 
	 //Remove Relationship 
	 public void removeRelationship(Question question, Tag tag) {
		 //remove the "category" from this products list of categories 
		 question.getTags().remove(tag);
		 questionRepository.save(question);
	 }
}
