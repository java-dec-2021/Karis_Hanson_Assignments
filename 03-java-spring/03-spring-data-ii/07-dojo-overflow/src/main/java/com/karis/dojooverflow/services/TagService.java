package com.karis.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.dojooverflow.models.Question;
import com.karis.dojooverflow.models.Tag;
import com.karis.dojooverflow.repositories.QuestionRepository;
import com.karis.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private QuestionRepository questionRepository; 
	
	@Autowired
	private TagRepository tagRepository; 
	
	//Find All Tags 
	public List<Tag> allTags() {
		return this.tagRepository.findAll();
			 
	}
	//Create Tag
	public Tag createTag(Tag tag) {
		return tagRepository.save(tag);
	}
	
	//retrieve a Tag
	public Tag findTag(Long id) {
		return this.tagRepository.findById(id).orElse(null);
	}
	
	 //Find Questions that belong to the Tag
	 public List<Question> findQuestionsofTag(Tag tag){
		 return questionRepository.findAllByTags(tag);
	 }
	 
	 //Find Categories that don't belong to the product
	 public List<Question> findQuestionsNotofTag(Tag tag){
		 return questionRepository.findByTagsNotContains(tag);
	 }
	
	//Update Tag
		public Tag updateTag(Tag tag) {
			return tagRepository.save(tag);
		}
	
	 //Delete 
	 public void deleteProduct(Long id) {
		 this.tagRepository.deleteById(id);
	 }

}


