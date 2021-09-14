package com.pay.my.budy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.constant.Message;
import com.pay.my.budy.dto.UserSignupDTO;
import com.pay.my.budy.repository.UserRepository;
import com.pay.my.budy.service.UserServices;

@Controller
public class SignupController {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SecurityConfiguration security;
	
	@Autowired
	UserServices userService;
	
	
	@GetMapping(value = "/signup")
	public String signupController() {
		
		return "/layouts/signup";		
	}
	
	
	@PostMapping(value = "/signup")
	public String postSignupForm(@ModelAttribute("user") @Valid UserSignupDTO userSignupDTO, BindingResult result) {
		
		Boolean exist = userService.signup(userSignupDTO);
		
			if (exist == false ) {
				
				 ObjectError err = new ObjectError("email", Message.EMAIL_ERROR);
				 result.addError(err);
	
			}
		
			if (result.hasErrors()) {
				
				return "/layouts/signin";
	
			}
		
				return "/layouts/signin";
	}
	

}
