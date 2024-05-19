package com.project.ecommercewebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommercewebsite.modal.Category;
import com.project.ecommercewebsite.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class categoryService {
	
	@Autowired
	CategoryRepository repo;
	
	public void addCategory(Category cat) {
		repo.save(cat);
	}
	
	public List<Category> getAllCategories(){
		return (List<Category>) repo.findAll();
	}

	public void deleteCategoryByID(Integer id) {
		repo.deleteById(id);
		
	}
}
