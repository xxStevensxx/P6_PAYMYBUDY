package com.pay.my.budy.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ProfilController {
	
	@GetMapping
	public String profilController() {
		
		return "layouts/profil";
	}

}
