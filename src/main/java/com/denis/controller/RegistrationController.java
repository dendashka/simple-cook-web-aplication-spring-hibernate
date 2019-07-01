package com.denis.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.denis.entity.Role;
import com.denis.entity.User;
import com.denis.repository.UserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/registration") 
	public String registration(Map<String, Object> map) {
		
		return "registration";
	}
	
	@PostMapping("/registration") 
	public String addUser(User user, Map<String, Object> map) {
		User userFromDB = userRepo.findByUsername(user.getUsername());
		if(userFromDB !=null) {
			map.put("message", "User exists");
			return "registration";
		}
		
		user.setActive(true);
		user.setRole(Collections.singleton(Role.USER));
		userRepo.save(user);
		
		return "redirect:/login";
	}

}
