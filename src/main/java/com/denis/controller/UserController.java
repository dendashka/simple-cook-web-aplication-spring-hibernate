package com.denis.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.denis.entity.Role;
import com.denis.entity.User;
import com.denis.repository.UserRepository;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

	@Autowired
	UserRepository userRepo;	
	
	@GetMapping
	public String userList(Model model) {
		model.addAttribute("userlist", userRepo.findAll());
		return "userlist";
	}
	
	@GetMapping("{user}")
	public String userEditForm(@PathVariable User user, Model model) {
		model.addAttribute("user", user);		
		model.addAttribute("roles", Role.values());
		return "useredit";
	}
	
	@PostMapping("")
	public String userSave(
			@RequestParam String username,
			@RequestParam Map<String, String> form,
			@RequestParam("userid") User user ){
		
		user.setUsername(username);
		Set<String> roles =  Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
		
		user.getRole().clear();
		
		for(String key: form.keySet()) {
			if(roles.contains(key)) {
				user.getRole().add(Role.valueOf(key));
			}
		}
		
		userRepo.save(user);
		
		return "redirect:/user";
	}
	
}
