package com.pay.my.budy.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.dto.FriendDTO;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.repository.UserRepository;
import com.pay.my.budy.service.UserServices;

@Controller
public class ContactController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServices userServices;
	
	@GetMapping(value = "/contact")
	public String contactController(Principal principal, Model model) {
		
		List<UserDTO> friends = userServices.getConnections(principal.getName());
		model.addAttribute("friends", friends);

			return "/layouts/contact";
	}
	
	
	@PostMapping(value = "/contact")
	public String postContactForm(FriendDTO friendDTO, Principal principal, BindingResult result) {
		
		userServices.addConnection(friendDTO.getUsername(), principal.getName());

			return "/layouts/contact";
		
	}

}
