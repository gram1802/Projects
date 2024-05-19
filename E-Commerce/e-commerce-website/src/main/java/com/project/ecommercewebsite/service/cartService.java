package com.project.ecommercewebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommercewebsite.modal.CartItem;
import com.project.ecommercewebsite.repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class cartService {
	
	@Autowired
	CartRepository repo;
	
	public void addToCart(CartItem c) {
		repo.save(c);
	}
	
	public List<CartItem> getCartItems() {
		return (List<CartItem>) repo.findAll();
	}
	
	public void deleteCartItem(Integer id) {
		repo.deleteById(id);
	}

}
