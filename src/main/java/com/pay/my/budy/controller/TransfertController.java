package com.pay.my.budy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransfertController {
	
	@GetMapping(value = "/transfert")
	public String transfertController() {
		
		return "/layouts/transfert";
	}

}
