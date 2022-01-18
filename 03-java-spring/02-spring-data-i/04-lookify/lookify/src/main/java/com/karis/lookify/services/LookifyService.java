package com.karis.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karis.lookify.models.Lookify;
import com.karis.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepo; 
	
	public LookifyService(LookifyRepository repo) {
		this.lookifyRepo = repo;
	}
	
	//Find All lookify 
	 public List<Lookify> allLookify() {
		 return this.lookifyRepo.findAll();
		 
	 }
	 //Get one Language
	 public Lookify findLookify(Long id) {
//		 return this.lookifyRepo.findById(id).orElse(null);
		 
		 Optional<Lookify> optionalLookify = lookifyRepo.findById(id);
			if(optionalLookify.isPresent()) {
				return optionalLookify.get(); //return Lookify object with id
			}else {
				return null;
			}
	 }
	 //Create One Lookify 
	 public Lookify createLookify(Lookify newLookify) {
		 return this.lookifyRepo.save(newLookify);
	 }
	 
	 //Update Lookify
	 public Lookify updateLookify(Long id, Lookify updatedLookify) {
		 Optional<Lookify> lookify = lookifyRepo.findById(id);
			if(lookify.isPresent()) {
				Lookify newLookify= lookify.get();
				newLookify.setTitle(updatedLookify.getTitle());
				newLookify.setArtist(updatedLookify.getArtist());
				newLookify.setRating(updatedLookify.getRating());
				return lookifyRepo.save(newLookify);	
			}else {
				return null;
			}
	 }
	 
	 //search Artist
	 public List<Lookify> searchLookify(String search) {
		 return this.lookifyRepo.findByArtistContaining(search);
		 
	 }
	 
	 //get Top Ten
	 public List<Lookify> getTopTen(){
		 return this.lookifyRepo.findTop10ByOrderByRatingDesc();
	 }
	 
	 //Delete 
	 public void deleteLookify(Long id) {
		 this.lookifyRepo.deleteById(id);
	 }
}
 