package com.karis.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karis.dojosninjas.models.Ninja;
import com.karis.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	//Find All Ninjas 
	public List<Ninja> allNinjas() {
		return this.ninjaRepository.findAll();
			 
	}
	//Create Ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	//retrieve one Ninja
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	//Update Ninja
		public Ninja updateNinja(Ninja ninja) {
			return ninjaRepository.save(ninja);
		}
	
	 //Delete 
	 public void deleteNinja(Long id) {
		 this.ninjaRepository.deleteById(id);
	 }
}
