package com.pay.my.budy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.model.User;
import com.pay.my.budy.service.UserServices;



@Controller
public class ProfilController {
	
	@Autowired
	UserServices userServices;
	
	@GetMapping(value = "/profil")
	public String profilController() {
		
		return "/layouts/profil";
	}
	
	@PostMapping(value = "/profil")
	public String postProfilForm(HttpSession session, User user) {
		
		userServices.profilServices(session.getAttribute("session_name").toString(), user);
			return "/layouts/profil"; 
	}

}
