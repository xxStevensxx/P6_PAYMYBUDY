package com.pay.my.budy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.constant.Constante;
import com.pay.my.budy.model.Authority;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.AuthorityRepository;
import com.pay.my.budy.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	SecurityConfiguration security;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorityRepository authRepository;
		

	public void profil(String username, User user) {
			
		User userFindInRepository = userRepository.findByusername(username);
		
		userFindInRepository.setFirstname(user.getFirstname());
		userFindInRepository.setName(user.getName());
		userFindInRepository.setBirthdate(user.getBirthdate());
		userFindInRepository.setAddress(user.getAddress());
				
			userRepository.save(userFindInRepository);
		
	}
	
	
	
	public void signup(User user) {		
		
		user.setPassword(security.passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		User user_info = userRepository.findByusername(user.getUsername());
		
		Authority authority = new Authority();
		authority.setUser_id(user_info.getId());
		authority.setUsername(user.getUsername());
		authority.setAuthority(Constante.USER);
		
		authRepository.save(authority);
		
		
		
	}
	
	
}