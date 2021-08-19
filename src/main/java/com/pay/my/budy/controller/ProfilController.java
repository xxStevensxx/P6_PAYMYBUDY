package com.pay.my.budy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilController {
	
	@GetMapping(value = "/profil")
	public String profilController() {
		
		return "/layouts/profil";
	}

}
