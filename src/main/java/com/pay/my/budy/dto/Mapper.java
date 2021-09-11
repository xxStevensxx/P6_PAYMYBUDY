package com.pay.my.budy.dto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pay.my.budy.model.User;

@Component
public class Mapper {
	
	@Autowired
	UserDTO userDTO;
	
	@Autowired
	User user;
	
	public UserDTO toDTO(User user) {
			
		userDTO.setFirstname(user.getFirstname());
		userDTO.setName(user.getName());
		userDTO.setBirthdate(user.getBirthdate());
		userDTO.setAddress(user.getAddress());
		userDTO.setUsername(user.getUsername());
 

			return userDTO;
	}
	
	
	public User toUser(UserDTO userDTO) {
		
		user.setFirstname(userDTO.getFirstname());
		user.setName(userDTO.getName());
		user.setBirthdate(userDTO.getBirthdate());
		user.setAddress(userDTO.getAddress());
		user.setUsername(userDTO.getUsername());

		
			return user;	
	}
	

}
