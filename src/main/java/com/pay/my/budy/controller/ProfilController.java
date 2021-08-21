package com.pay.my.budy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;



@Controller
public class ProfilController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/profil")
	public String profilController() {
		
		return "/layouts/profil";
	}
	
	@PostMapping
	public String postProfilForm(User user) {
		
		userRepository.save(user);
			return "/layouts/profil"; 
	}

}
