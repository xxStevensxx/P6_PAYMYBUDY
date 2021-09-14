package com.pay.my.budy.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;

public class ProfilServices {
	
	@Autowired
	Mapper mapper;
	
	@Autowired
	UserRepository userRepository;
	
	
	public void profil(String username, UserDTO userDTO) {
		
		User user = mapper.toUser(userDTO);			
		User userFindInRepository = userRepository.findByusername(username);
		
		
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


}
