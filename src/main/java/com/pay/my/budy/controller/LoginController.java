package com.pay.my.budy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	
	@GetMapping(value = "/signin")
	public String loginController() {
		
			return "/layouts/signin";
			
	}
	
	
	@PostMapping
	public String postLogiinForm() {
		
		return "/layouts/index"; 
		
	}

}