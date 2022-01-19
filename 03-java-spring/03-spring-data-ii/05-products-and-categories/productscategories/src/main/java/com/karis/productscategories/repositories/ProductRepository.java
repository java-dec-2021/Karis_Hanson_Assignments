package com.karis.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karis.productscategories.models.Category;
import com.karis.productscategories.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll(); //SELECT * FROM products
	
	//Retrieves a list of all products for a particular category 
		List<Product> findAllByCategories(Category category);
		
		//Retrieves a list of any products a particular category does not belong to
		List<Product> findByCategoriesNotContains(Category category);
}
