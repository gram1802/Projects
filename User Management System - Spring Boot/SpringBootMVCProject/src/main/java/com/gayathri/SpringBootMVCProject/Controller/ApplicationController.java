package com.gayathri.SpringBootMVCProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gayathri.SpringBootMVCProject.modal.User;
import com.gayathri.SpringBootMVCProject.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/app")
public class ApplicationController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String welcome() {
		return "register";
	}
	
	@RequestMapping("/initial")
	public String home() {
		return "welcomepage";
	}
	
	@PostMapping("/add")
	public String Userregister(@ModelAttribute User user) {
		userService.saveMyUser(user);
		return "login";
	}
	
	@RequestMapping("/sign-in")
	public String SignIn() {
		return "login";
	}
	
	@PostMapping("/logging")
	public String LogIn(@ModelAttribute User user, HttpSession session) {
		User record = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if( record != null) {
			session.setAttribute("user", record);
			return "welcomepage";
		}
			
		else
			return "login";
	}
	
	@RequestMapping("/All-Users")
	public String ShowUser(Model model) {
		model.addAttribute("users",userService.showAlluser());
		return "display";
	}
	
	@RequestMapping("/Update")
	public String UpdateUser(Model model, HttpSession session) {
		User u = (User) session.getAttribute("user");
		model.addAttribute("u",u);
		return "update";
	}
	
	
	@PostMapping("/updating")
	public String updatting(@ModelAttribute User user, HttpSession session,Model model) {
		User existing = (User) session.getAttribute("user");
		int id = existing.getId();
		userService.updateMyUser(id, user);
		return "welcomepage";
	}
	
	@RequestMapping("Delete")
	public String DeleteUser() {
		return "delete";
	}
	
	@PostMapping("deleting")
	public String deleting(HttpSession session) {
		User user = (User) session.getAttribute("user");
		int id = user.getId();
		userService.deleteUserById(id);
		return "register";
	}
	
	

}
