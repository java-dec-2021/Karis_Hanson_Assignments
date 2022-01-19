package com.karis.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karis.productscategories.models.Category;
import com.karis.productscategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
	List<Category> findAll(); //SELECT * FROM categories
	
	//Retrieves a list of all categories for a particular product 
	List<Category> findAllByProducts(Product product);
	
	//Retrieves a list of any categories a particular product does not belong to
	List<Category> findByProductsNotContains(Product product);
}
