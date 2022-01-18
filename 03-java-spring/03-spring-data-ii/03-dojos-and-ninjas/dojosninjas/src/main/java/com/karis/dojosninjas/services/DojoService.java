package com.karis.dojosninjas.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karis.dojosninjas.models.Dojo;
import com.karis.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	//Find All Dojos 
	public List<Dojo> allDojos() {
		return this.dojoRepository.findAll();
			 
	}
	//Create Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//retrieve a Dojo
//	public Dojo findDojo(Long id) {
//		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
//		if(optionalDojo.isPresent()) {
//			return optionalDojo.get();
//		} else {
//			return null;
//		}
//	}
	//retrieve a Dojo
	public Dojo findDojo(Long id) {
		return this.dojoRepository.findById(id).orElse(null);
	}
	
	//Update Dojo
		public Dojo updateDojo(Dojo dojo) {
			return dojoRepository.save(dojo);
		}
	
	 //Delete 
	 public void deleteDojo(Long id) {
		 this.dojoRepository.deleteById(id);
	 }

}
