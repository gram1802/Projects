package com.project.ecommercewebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.ecommercewebsite.modal.Category;
import com.project.ecommercewebsite.modal.Product;
import com.project.ecommercewebsite.repository.ProductRepository;

@Service
@Transactional
public class productService {
	
	@Autowired
	ProductRepository repo;
	
	public void addProduct(Product p) {
		repo.save(p);
	}
	public List<Product> getAllProducts(){
		return (List<Product>) repo.findAll();
	}
	
	public void deleteProductByID(Integer id) {
		repo.deleteById(id);
		
	}
	 public Optional<Product> getProductById(Integer id){
		 return repo.findById(id);
	 }
	 
	 public void updateProduct(Product updatedProduct) {
	        Optional<Product> existingProductOptional = getProductById(updatedProduct.getId());
	       
	        Product existingProduct = existingProductOptional.get();
	        existingProduct.setName(updatedProduct.getName());
	        existingProduct.setCategories(updatedProduct.getCategories());
	        existingProduct.setPrice(updatedProduct.getPrice());
	        existingProduct.setWeight(updatedProduct.getWeight());
	        existingProduct.setDescription(updatedProduct.getDescription());
	        existingProduct.setImageName(updatedProduct.getImageName());
	        repo.save(existingProduct);
	       
	    }

}
