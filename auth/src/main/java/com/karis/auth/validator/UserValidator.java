package com.karis.auth.validator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.karis.auth.models.User;
import com.karis.auth.repositories.UserRepository;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserRepository uRepo; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("password","match", "Passwords do not match");
		}
		if(uRepo.findByEmail(user.getEmail())!=null) {
			errors.rejectValue("email", "unique","Email address is already taken");
			
		}
	}
	
}
