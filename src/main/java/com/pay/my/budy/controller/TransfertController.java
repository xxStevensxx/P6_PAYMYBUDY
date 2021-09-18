package com.pay.my.budy.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.service.RelationShipServices;
import com.pay.my.budy.service.TransfertServices;

@Controller
public class TransfertController {
	
	@Autowired
	TransfertServices transfertServices;
	
	@Autowired
	RelationShipServices relationServices;
	
	@GetMapping(value = "/transfert")
	public String transfertController(Principal principal, Model model) {
		
		
		UserDTO transfertDTO = transfertServices.DisplayInfotransfert(principal.getName());
		
		System.err.println(transfertDTO);
		
		model.addAttribute("transfertDTO", transfertDTO);
		
			return "/layouts/transfert";
	}
	
	
	@PostMapping(value = "/transfert")
	public String transferMoney(Principal principal, UserDTO transfertDTO, Model model) {
		
		System.err.println(transfertDTO);
		UserDTO userDTO = transfertServices.transfertBis(principal.getName(), transfertDTO);
		model.addAttribute("transfertDTO", userDTO);

		
			return "/layouts/transfert";

		
	}

}
