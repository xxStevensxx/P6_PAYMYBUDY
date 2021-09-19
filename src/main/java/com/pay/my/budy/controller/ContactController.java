package com.pay.my.budy.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.dto.FriendDTO;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.repository.UserRepository;
import com.pay.my.budy.service.RelationShipServices;


/**
 * <b>Voici la classe ContactController  </b>
 * 
 * <p> C'est le controller qui enverra nos data vers la couche service
 * 
 * @author Stevens
 * @version beta
 */
@Controller
public class ContactController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RelationShipServices friendShipServices;
	
	
	
	
	/**
	 * 
	 * @param principal, ce parametre nous permet de savoir qui utilise l'application grace a son interface qui nous retourne le nom ou l'id
	 * @param model, ce param envoi l'objet desiré avec un nom que l'ont peux definir dans notre template jsp, html ou autre.
	 * @return, nous renvoi la vue apres que toutes les operation ce soit deroulé.
	 * 
	 */
	@GetMapping(value = "/contact")
	public String contactController(Principal principal, Model model) {
		
		List<UserDTO> friends = friendShipServices.getConnections(principal.getName());
		model.addAttribute("friends", friends);

			return "/layouts/contact";
	}
	
	
	
	/**
	 * 
	 * @param friendDTO, les informations soumises par le client sont des DTO qui seront  mappé puis puis traités plus tard.  
	 * @param principal, ce param envoi l'objet desiré avec un nom que l'ont peux definir dans notre template jsp, html ou autre.
	 * @return, nous renvoi la vue apres que toutes les operation ce soit deroulé.
	 */
	@PostMapping(value = "/contact")
	public String postContactForm(@Valid FriendDTO friendDTO, Principal principal, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "/layouts/contact";
			
		}
		
		friendShipServices.addConnection(friendDTO.getUsername(), principal.getName());

			return "/layouts/contact";
		
	}

}
