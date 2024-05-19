package com.project.ecommercewebsite.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.ecommercewebsite.modal.CartItem;

public interface CartRepository extends CrudRepository<CartItem, Integer> {

}
