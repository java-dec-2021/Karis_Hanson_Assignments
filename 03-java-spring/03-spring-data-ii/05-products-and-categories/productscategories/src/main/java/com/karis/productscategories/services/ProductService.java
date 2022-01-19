package com.karis.productscategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karis.productscategories.models.Category;
import com.karis.productscategories.models.Product;
import com.karis.productscategories.repositories.CategoryRepository;
import com.karis.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private ProductRepository productRepository; 
	
	//Find All Products 
	public List<Product> allProducts() {
		return this.productRepository.findAll();
			 
	}
	//Create Product
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	//retrieve a Product
	public Product findProduct(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	 //Find Category that belong to the product
	 public List<Category> findCategoriesofProducts(Product product){
		 return categoryRepository.findAllByProducts(product);
	 }
	 
	 //Find Categories that don't belong to the product
	 public List<Category> findCategoriesNotofProduct(Product product){
		 return categoryRepository.findByProductsNotContains(product);
	 }
	
	//Update Product
		public Product updateProduct(Product product) {
			return productRepository.save(product);
		}
	
	 //Delete 
	 public void deleteProduct(Long id) {
		 this.productRepository.deleteById(id);
	 }

}


