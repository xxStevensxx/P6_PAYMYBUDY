package com.pay.my.budy.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.dto.UserDTO;
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
	public String profilController (Principal principal, Model model) {
		
		UserDTO userDTO = userServices.getProfil(principal.getName());
		model.addAttribute("userDTO",userDTO);
		
			return "/layouts/profil";
	}
	
	
	@PostMapping(value = "/profil")
	public String postProfilForm(@ModelAttribute("userDTO") UserDTO userDTO, Principal principal, BindingResult result) {
							
		userServices.profil(principal.getName(), userDTO);
			
			return "/layouts/profil"; 

	}

}
