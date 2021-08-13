package com.pay.my.budy.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TransfertController {
	
	@GetMapping
	public String transfertController() {
		
		return "/layouts/transfert";
	}

}
