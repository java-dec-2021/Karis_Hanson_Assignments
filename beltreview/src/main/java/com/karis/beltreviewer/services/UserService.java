package com.karis.beltreviewer.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.beltreviewer.models.User;
import com.karis.beltreviewer.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository; 
	
	//register user and hash their password
	public User registerUser(User user) {
		//hash the user's password
		String hashedPass=BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		//reset password to be the hashed password
		user.setPassword(hashedPass);
		//save the user to the database
		return userRepository.save(user);
	}
	
	//find user by email
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	//find user by id
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//authenticate user
	public boolean authenticateUser(String email, String password ) {
		//find the user by email - check if user exists
		User user = userRepository.findByEmail(email);
		//if user cannot be found by email, return false
		if(user ==null) {
			return false;
		//else user exists
		}else {
			//if the passwords match, return true, else return false
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
}
