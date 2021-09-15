package com.pay.my.budy.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.service.RelationShipServices;

@Controller
public class TransfertController {
	
	@Autowired
	RelationShipServices friendShipServices;
	
	@GetMapping(value = "/transfert")
	public String transfertController(Principal principal, Model model) {
		
		List<UserDTO> friends = friendShipServices.getConnections(principal.getName());
		model.addAttribute("friends", friends);
		
		return "/layouts/transfert";
	}

}
