package com.pay.my.budy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;

@Controller
public class SignupController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SecurityConfiguration security;
	
	
	@GetMapping(value = "/signup")
	public String signupController() {
		
		return "/layouts/signup";		
	}
	
	
	@PostMapping(value = "/signup")
	public String postSignupForm(User user) {
		
		user.setPassword(security.passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
			return "/layouts/signin";
	}
	

}
