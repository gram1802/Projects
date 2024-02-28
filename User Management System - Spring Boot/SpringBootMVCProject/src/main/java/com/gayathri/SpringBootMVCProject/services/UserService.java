package com.gayathri.SpringBootMVCProject.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gayathri.SpringBootMVCProject.modal.User;
import com.gayathri.SpringBootMVCProject.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void saveMyUser(User user) {
		
		userRepo.save(user);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRepo.findByUsernameAndPassword(username, password);
	}
	
	public List<User> showAlluser(){
		List<User> users = new ArrayList<>();
		for(User user : userRepo.findAll()) {
			users.add(user);
		}
		return users;
	}
	
	
	public void updateMyUser(int id, User user) {
		User existingUser = userRepo.findById(id);
		existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setAge(user.getAge());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        // Save the updated user to the database
        userRepo.save(existingUser);
	}
	
	public void deleteUserById(int id) {
		userRepo.deleteById(id);
	}

}
