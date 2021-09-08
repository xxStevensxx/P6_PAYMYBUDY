package com.pay.my.budy.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;
import com.pay.my.budy.service.UserServices;



@Controller
public class ProfilController {
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping(value = "/profil")
	public String profilController(Principal principal, Model model) {
		
		User user = userRepository.findByusername(principal.getName());
		model.addAttribute("user", user);
		
			return "/layouts/profil";
	}
	
	
	@PostMapping(value = "/profil")
	public String postProfilForm(Principal principal, User user) {
		
		userServices.profil(principal.getName(), user);
			return "/layouts/profil"; 
	}

}
