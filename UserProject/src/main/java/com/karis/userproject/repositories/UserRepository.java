package com.karis.userproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karis.userproject.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	//Find a use by their email address 
	User findByEmail(String email);
}
