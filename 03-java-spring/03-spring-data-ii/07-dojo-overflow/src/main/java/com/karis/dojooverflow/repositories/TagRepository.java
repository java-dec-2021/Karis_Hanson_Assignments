package com.karis.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karis.dojooverflow.models.Question;
import com.karis.dojooverflow.models.Tag;


@Repository
public interface TagRepository extends CrudRepository<Tag,Long>{
		List<Tag> findAll(); //SELECT * FROM tags
	
	//Retrieves a list of all products for a particular category 
		List<Tag> findAllByQuestions(Question question);
		
		//Retrieves a list of any products a particular category does not belong to
		List<Tag> findByQuestionsNotContains(Question question);
}
