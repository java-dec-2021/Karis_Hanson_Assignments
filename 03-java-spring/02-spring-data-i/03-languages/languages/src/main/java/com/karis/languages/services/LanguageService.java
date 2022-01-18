package com.karis.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karis.languages.models.Language;
import com.karis.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepo; 
	
	public LanguageService(LanguageRepository repo) {
		this.languageRepo = repo;
	}
	
	//Find All Languages 
	 public List<Language> allLanguages() {
		 return this.languageRepo.findAll();
		 
	 }
	 //Get one Language
	 public Language findLanguage(Long id) {
//		 return this.languageRepo.findById(id).orElse(null);
		 
		 Optional<Language> optionalLanguage = languageRepo.findById(id);
			if(optionalLanguage.isPresent()) {
				return optionalLanguage.get(); //return Language object
			}else {
				return null;
			}
	 }
	 //Create One Language 
	 public Language createLanguage(Language newLang) {
		 return this.languageRepo.save(newLang);
	 }
	 
	 //Update Language
	 public Language updateLanguage(Long id, Language updatedLang) {
		 Optional<Language> language = languageRepo.findById(id);
			if(language.isPresent()) {
				Language newLang= language.get();
				newLang.setName(updatedLang.getName());
				newLang.setCreator(updatedLang.getCreator());
				newLang.setCurrentVersion(updatedLang.getCurrentVersion());
				return languageRepo.save(newLang);	
			}else {
				return null;
			}
	 }
	 
	 //Delete 
	 public void deleteLanguage(Long id) {
		 this.languageRepo.deleteById(id);
	 }
}
 