package com.pay.my.budy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.dto.UserSignupDTO;
import com.pay.my.budy.repository.UserRepository;
import com.pay.my.budy.service.UserServices;


/**
 * <b>Voici la classe SignupController  </b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Controller
public class SignupController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SecurityConfiguration security;
	
	@Autowired
	UserServices userService;
	
	
	/**
	 * 
	 * <p>Affichage de la vue du formulaire d'incription
	 * @return, la vue 
	 */
	@GetMapping(value = "/signup")
	public String signupController() {
		
		return "/layouts/signup";		
	}
	
	
	/**
	 * <p> Permet au client de s'inscrire.
	 * @param userSignupDTO, Les infos utilisateur envoyé par le client afin d'etre traité
	 * @param result, affichage des erreurs client a l'ecran lors du remplissage du formulaire.
	 * @return, la vue 
	 */
	@PostMapping(value = "/signup")
	public String postSignupForm(UserSignupDTO userSignupDTO, BindingResult result) {
		
			String url = userService.signup(userSignupDTO);
	
				return url;
	}
	

}
