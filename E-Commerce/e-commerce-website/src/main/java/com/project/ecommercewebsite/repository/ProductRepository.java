package com.project.ecommercewebsite.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.ecommercewebsite.modal.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {

}
