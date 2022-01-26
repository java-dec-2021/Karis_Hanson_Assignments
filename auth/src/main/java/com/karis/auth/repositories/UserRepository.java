package com.karis.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karis.auth.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	//Find a use by their email address 
	User findByEmail(String email);
}
