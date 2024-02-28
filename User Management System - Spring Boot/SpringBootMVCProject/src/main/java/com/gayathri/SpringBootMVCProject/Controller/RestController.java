package com.gayathri.SpringBootMVCProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gayathri.SpringBootMVCProject.modal.User;
import com.gayathri.SpringBootMVCProject.services.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/save-user")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) {
		User user=new User(username,firstname,lastname,password,age);
		userService.saveMyUser(user);
		return "user saved";
	}
}
