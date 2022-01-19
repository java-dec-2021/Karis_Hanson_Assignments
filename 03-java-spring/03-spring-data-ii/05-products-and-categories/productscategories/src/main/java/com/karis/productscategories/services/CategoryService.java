package com.karis.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.productscategories.models.Category;
import com.karis.productscategories.models.Product;
import com.karis.productscategories.repositories.CategoryRepository;
import com.karis.productscategories.repositories.ProductRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private ProductRepository productRepository; 
	
	//Find All Categories
	public List<Category> allCategories() {
		return this.categoryRepository.findAll();
			 
	}
	//Create Category
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	//retrieve a Category
	public Category findCategory(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
	
	//Update Category
		public Category updateCategory(Category category) {
			return categoryRepository.save(category);
		}
	
	
	 //Delete 
	 public void deleteCategory(Long id) {
		 this.categoryRepository.deleteById(id);
	 }
	 
	 //Find Products that belong to the category
	 public List<Product> findProductsofCategory(Category category){
		 return productRepository.findAllByCategories(category);
	 }
	 
	 //Find Products that don't belong to the category
	 public List<Product> findProductsNotofCategory(Category category){
		 return productRepository.findByCategoriesNotContains(category);
	 }
	 
	 //Add Relationship
	 public void addRelationship(Category category, Product product) {
		 //add "category" to this products list of categories 
		 product.getCategories().add(category);
		 // Save the "product" because changes were made to the category list. 
		 productRepository.save(product);
		 
	 }
	 
	 //Remove Relationship 
	 public void removeRelationship(Category category, Product product) {
		 //remove the "category" from this products list of categories 
		 product.getCategories().remove(category);
		 productRepository.save(product);
	 }
}
