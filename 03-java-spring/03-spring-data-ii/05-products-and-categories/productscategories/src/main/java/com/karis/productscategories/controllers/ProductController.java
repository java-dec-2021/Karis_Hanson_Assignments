package com.karis.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.karis.productscategories.models.Category;
import com.karis.productscategories.models.Product;
import com.karis.productscategories.services.CategoryService;
import com.karis.productscategories.services.ProductService;

@Controller
public class ProductController {
	@Autowired 
	private CategoryService categoryService; 
	@Autowired
	private ProductService productService;

	
	@RequestMapping("/products")
	public String allProducts(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "products.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProducts(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@RequestMapping(value="/products/new", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}else {
			productService.createProduct(product);
			return "redirect:/products";
		}
	
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
//		List<Product> products = categoryService.findProductsofCategory(category);
//		model.addAttribute("productsInCategory", products);
		List<Category> categoriesNot = productService.findCategoriesNotofProduct(product);
		model.addAttribute("categoriesNotInProduct", categoriesNot);
		
		return "showProduct.jsp";
	}
	
	@RequestMapping(value="/addCategory/{id}", method=RequestMethod.POST)
	public String addCategory(@PathVariable("id") Long product_id, @RequestParam("category") Long category_id) {
		Product product =productService.findProduct(product_id);
		Category category = categoryService.findCategory(category_id);
		categoryService.addRelationship(category, product);
		return "redirect:/products/{id}";
	}
}
