package com.project.ecommercewebsite.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ecommercewebsite.modal.CartItem;
import com.project.ecommercewebsite.modal.Category;
import com.project.ecommercewebsite.modal.Product;
import com.project.ecommercewebsite.service.cartService;
import com.project.ecommercewebsite.service.categoryService;
import com.project.ecommercewebsite.service.productService;

@Controller
public class HomeController {
	
	@Autowired
	categoryService crepo;
	
	@Autowired
	productService rrepo;
	
	@Autowired
	cartService srepo;
	
	@GetMapping("/home")
	public String userHomePage() {
		return "index";
	}
	
	@GetMapping("/shop")
	public String userShopPage(@RequestParam(required = false) String x, Model model) {
		
		List<Product> ls2 = rrepo.getAllProducts();
		
		  if (x != null && !x.isEmpty()) {
	            // Filter products by category
	            ls2 = ls2.stream()
	                    .filter(product -> product.getCategories().getName().equals(x))
	                    .collect(Collectors.toList());
	        }
		  
		List<Category> ls1 = crepo.getAllCategories();
		model.addAttribute("categories", ls1);
		model.addAttribute("products", ls2);
		return "shopItems";
	}
	
	@GetMapping("/displayCart")
	public String displayCart(Model model) {
		
        List<CartItem> cartItems = srepo.getCartItems();
        model.addAttribute("cartItems", cartItems);
		return "myCart";
	}
	
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam("productId") Integer productId) {
		
		java.util.Optional<Product> productOptional = rrepo.getProductById(productId);
		
		Product product = productOptional.get();
        
        // Create a new CartItem and associate it with the retrieved Product
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1); 
       
        // Save the CartItem to the database
        srepo.addToCart(cartItem);
       
		return "redirect:/displayCart";
	}
	
	@GetMapping("/deleteCartItem")
	public String deleteFromCart(@RequestParam("cartItemId") Integer cartItemId) {
		srepo.deleteCartItem(cartItemId);
		return "myCart";
	}

}
