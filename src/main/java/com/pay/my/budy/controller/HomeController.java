package com.pay.my.budy.controller;


import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
	
	@Autowired
	FindByIndexNameSessionRepository<? extends Session> sessions;
	
	@GetMapping(value = {"/", "/home"})
	public String homeController(Principal principal, Model model, HttpSession session) {
				
		model.addAttribute("session_name", principal.getName());		
		session.setAttribute("session_name", model.getAttribute("session_name"));
		
		System.err.println(session.getAttribute("session"));
		
			return "/layouts/index";
	}
}

