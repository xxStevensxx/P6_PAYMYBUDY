package com.pay.my.budy.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		
		
//		List<UserDTO> transfertDTO = relationServices.getConnections(principal.getName());
		UserDTO transfertDTO = transfertServices.DisplayInfotransfert(principal.getName());
		
		model.addAttribute("transfertDTO", transfertDTO);
		
			return "/layouts/transfert";
	}

}
