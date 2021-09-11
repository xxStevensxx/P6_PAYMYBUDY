package com.pay.my.budy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.constant.Constante;
import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserDTO;
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
	
	@Autowired
	Mapper mapper;
		

	public void profil(String username, UserDTO userDTO) {
		

		User userFindInRepository = userRepository.findByusername(username);
		User user = mapper.toUser(userDTO);			
		
				
		if (user.getFirstname().trim() != "") {userFindInRepository.setFirstname(user.getFirstname());}
		
		if (user.getName().trim() != "") {userFindInRepository.setName(user.getName());}
		
		if (user.getBirthdate() != null) {userFindInRepository.setBirthdate(user.getBirthdate());}
		
		if (user.getAddress().trim() != "") {userFindInRepository.setAddress(user.getAddress());}

				
			userRepository.save(userFindInRepository);
		
	}
	
	
	public UserDTO getProfil(String username) {
		
		User user_info = userRepository.findByusername(username);
		UserDTO userDTO = mapper.toDTO(user_info);
			
			return userDTO;
		
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
	
	
	
	public String addConnection(User user, BindingResult result) {
		

		User user_info = userRepository.findByusername(user.getUsername());
		String connection = user_info.getUsername();
		
		if (connection == null || connection == "") {
			
			
			
		}
		
		return null;
		

	}
	
	
}