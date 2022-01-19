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
public class HomeController {
	@Autowired 
	private CategoryService categoryService; 
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/categories/new";
	}
	
	@RequestMapping("/categories")
	public String allCategories(Model model) {
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		return "categories.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@RequestMapping(value="/categories/new", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			categoryService.createCategory(category);
			return "redirect:/categories";
		}
	
	}
	
	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
//		List<Product> products = categoryService.findProductsofCategory(category);
//		model.addAttribute("productsInCategory", products);
		List<Product> productsNot = categoryService.findProductsNotofCategory(category);
		model.addAttribute("productsNotInCategory", productsNot);
		
		return "showCategory.jsp";
	}
	
	@RequestMapping(value="/addProduct/{id}", method=RequestMethod.POST)
	public String addProduct(@PathVariable("id") Long category_id, @RequestParam("product") Long product_id) {
		Product product =productService.findProduct(product_id);
		Category category = categoryService.findCategory(category_id);
		categoryService.addRelationship(category, product);
		return "redirect:/categories/{id}";
	}
}
	

