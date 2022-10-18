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

/**
 * <b>Voici la classe TransfertController</b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Controller
public class TransfertController {
	
	@Autowired
	TransfertServices transfertServices;
	
	@Autowired
	RelationShipServices relationServices;
	
	
	/**
	 * 
	 * @param principal, ce parametre nous permet de savoir qui utilise l'application grace a son interface qui nous retourne le nom ou l'id
	 * @param model, ce param envoi l'objet desiré avec un nom que l'ont peux definir dans notre template jsp, html ou autre.
	 * @return return la vue qui sera rappelé
	 */
	@GetMapping(value = "/transfert")
	public String transfertController(Principal principal, Model model) {
		
		
		UserDTO transfertDTO = transfertServices.DisplayInfotransfert(principal.getName());
				
		model.addAttribute("transfertDTO", transfertDTO);
		
			return "/layouts/transfert";
	}
	
	
	/**
	 * 
	 * @param principal, ce parametre nous permet de savoir qui utilise l'application grace a son interface qui nous retourne le nom ou l'id
	 * @param transfertDTO, Les infos de paiement utilisateur envoyé par le client afin d'etre traité
	 * @param model, ce param envoi l'objet desiré avec un nom que l'ont peux definir dans notre template jsp, html ou autre.
	 * @return return la vue qui sera rappelé
	 * @throws Exception toute forme d'exeption sera levé
	 */
	@PostMapping(value = "/transfert")
	public String transferMoney(Principal principal, UserDTO transfertDTO, Model model) throws Exception {
		
		
		Boolean check = transfertServices.checkAmount(principal.getName(), transfertDTO);

		if (check == true) {
			
			UserDTO userDTO = transfertServices.transfertBis(principal.getName(), transfertDTO);
			model.addAttribute("transfertDTO", userDTO);
			
				return "/layouts/transfert_success";
		}else {
			
				return "/layouts/transfert_error";
		}

		
	}

}
