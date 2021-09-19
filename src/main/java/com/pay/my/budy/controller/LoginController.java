package com.pay.my.budy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <b>Voici la classe LoginController  </b>
 * 
 * 
 * @author Stevens
 * @version beta
 */

@Controller
public class LoginController {
	
	
	/**
	 * <p> Controller qui nous affiche notre lgin personalisé on peux voir dans la classe SecurityConfiguration que le login est mappé via cet url
	 * @return, la vue de notre login form.
	 */
	@GetMapping(value = "/signin")
	public String loginController() {
		
			return "/layouts/signin";
			
	}
	
	/**
	 * <p> On peux tres bien ce passer de ce controller car le processing du login est geré par spring-security
	 * @return, la vue
	 */
	@PostMapping(value = "/signin")
	public String postLoginForm() {
		
		return "/layouts/index"; 
		
	}
}

