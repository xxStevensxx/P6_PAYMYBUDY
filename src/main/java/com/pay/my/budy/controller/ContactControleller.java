package com.pay.my.budy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactControleller {
	
	
	@GetMapping(value = "/contact")
	public String contactController() {
		
		return "/layouts/contact";
	}

}
