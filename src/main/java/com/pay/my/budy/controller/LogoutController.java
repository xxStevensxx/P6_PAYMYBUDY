package com.pay.my.budy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * <b>Voici la classe LogoutController  </b>
 * 
 * 
 * @author Stevens
 * @version beta
 */
@Controller
public class LogoutController {
	
	
	
	/**
	 * 
	 * @return la vue de notre app.
	 */
	@PostMapping(value = "/logout")
	public String logoutController() {
		
		return "/logout_success";
	}

}
