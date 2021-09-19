package com.pay.my.budy.controller;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.dto.UserDTO;

import com.pay.my.budy.repository.UserRepository;
import com.pay.my.budy.service.ProfilServices;


/**
 * <b>Voici la classe ProfilController  </b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Controller
public class ProfilController {
	
	@Autowired
	ProfilServices profilServices;
	
	@Autowired
	UserRepository userRepository;	
	
	
	/**
	 * 
	 * On recupere les infos users via la couche service le tout est mappé en DTO puis envoé dans le model qui affichera les infos dans la vue.
	 * @param principal, ce parametre nous permet de savoir qui utilise l'application grace a son interface qui nous retourne le nom ou l'id
	 * @param model, ce param envoi l'objet desiré avec un nom que l'ont peux definir dans notre template jsp, html ou autre.
	 * @return, la vue html
	 */
	@GetMapping(value = "/profil")
	public String profilController (Principal principal, Model model) {
		
		UserDTO userDTO = profilServices.getProfil(principal.getName());		
		model.addAttribute("userDTO",userDTO);
		
			return "/layouts/profil";
	}
	
	/**
	 * 
	 * <p> C'est ici les info utilisateurs a mettre a jour seront envoyé à la couche services puis traité.
	 * @param userDTO, Les infos utilisateur envoyé par le client afin d'etre traité
	 * @param principal, ce parametre nous permet de savoir qui utilise l'application grace a son interface qui nous retourne le nom ou l'id
	 * @param result, affichage des erreurs client a l'ecran lors du remplissage du formulaire.
	 * @return "/layouts/profil", la vue qui sera appeler apres le process
	 */
	@PostMapping(value = "/profil")
	public String postProfilForm(UserDTO userDTO, Principal principal, BindingResult result, Model model) {					
		
		UserDTO newUserDTO = profilServices.profil(principal.getName(), userDTO);
		model.addAttribute("userDTO",newUserDTO);

			return "/layouts/profil"; 

	}

}
