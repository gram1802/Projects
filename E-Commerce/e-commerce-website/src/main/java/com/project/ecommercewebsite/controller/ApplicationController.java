package com.project.ecommercewebsite.controller;

import java.io.File;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.ecommercewebsite.modal.Category;
import com.project.ecommercewebsite.modal.Product;
import com.project.ecommercewebsite.service.categoryService;
import com.project.ecommercewebsite.service.productService;



@Controller
@RequestMapping("/website")
public class ApplicationController {
	
	@Autowired
	private categoryService service;
	
	@Autowired
	private productService service1;
	
	@GetMapping("/admin")
	public String adminWelcome() {
		return "admin";
	}
	
	@GetMapping("/addCategory")
	public String adminAddCategory() {
		return "addCategory";
	}
	
	@GetMapping("/addProduct")
	public String adminAddProduct(Model model) {
		List<Category> ls = service.getAllCategories();
		model.addAttribute("category",ls);
		return "addProduct";
	}
	
	@GetMapping("/displayProducts")
	public String displayingProduct(Model model) {
		List<Product> ls = service1.getAllProducts();
		model.addAttribute("products",ls);
		return "displayProduct";
	}
	
	@PostMapping("/saveCategory")
	public String addingCategory(@ModelAttribute Category cat,Model model) {
		service.addCategory(cat);
		List<Category> ls = service.getAllCategories();
		model.addAttribute("category",ls);
		return "displayCategory";
	}
	
	@PostMapping("/saveProduct")
	public String addingroduct(@RequestParam MultipartFile picture,@ModelAttribute Product p) {
		try {
			String filename = UUID.randomUUID().toString()  + ".jpg";
			String filePath = "C:/Users/gayat/Documents/E-Commerce/e-commerce-website/src/main/resources/static/images/" + filename;
			picture.transferTo(new File(filePath));
		    p.setImageName(filename);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		service1.addProduct(p);
		return "redirect:/website/displayProducts";
	}
	
	@GetMapping("/displayCategory")
	public String displayingCategory(Model model) {
		List<Category> ls = service.getAllCategories();
		model.addAttribute("category",ls);
		return "displayCategory";
	}
	
	@PostMapping("/deleteCategory/{id}")
	public String deletingCategory(@PathVariable Integer id) {
		service.deleteCategoryByID(id);
		return "redirect:/website/displayCategory";
	}
	
	@PostMapping("/deleteProduct/{id}")
	public String deletingProduct(@PathVariable Integer id) {
		service1.deleteProductByID(id);
		return "redirect:/website/displayProducts";
	}
	
	@PostMapping("/updateProduct/{id}")
	public String updatingProduct(@PathVariable Integer id,Model model) {
		Optional<Product> p = service1.getProductById(id);
		Product product = p.get();
		model.addAttribute("product", product);
		return "updateProduct";
	}
	
	@PostMapping("/newProduct")
	public String addingUpdatedProduct(@ModelAttribute Product updatedProduct) {
		service1.updateProduct(updatedProduct);
        return "redirect:/website/displayProducts";
	}
	

	

}
