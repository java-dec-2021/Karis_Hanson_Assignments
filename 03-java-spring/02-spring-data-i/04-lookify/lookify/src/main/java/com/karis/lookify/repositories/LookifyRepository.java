package com.karis.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karis.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	List<Lookify> findAll(); //SELECT * FROM lookify
	
	
	List<Lookify> findByArtistContaining(String search);
	
	List<Lookify> findTop10ByOrderByRatingDesc();
}
