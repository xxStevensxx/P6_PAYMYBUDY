package com.pay.my.budy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping(value = {"/", "/home"})
	public String homeController() {
		
		return "/layouts/index";
	}
}