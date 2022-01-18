package com.karis.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.karis.dojosninjas.models.Ninja;


public interface NinjaRepository extends CrudRepository<Ninja,Long> {
	
	List<Ninja> findAll(); //SELECT * FROM ninjas
}
