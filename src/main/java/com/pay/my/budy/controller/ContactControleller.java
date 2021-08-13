package com.pay.my.budy.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ContactControleller {
	
	
	@GetMapping(value = "/contact")
	public String contactController() {
		
		return "/layouts/contact";
	}

}
