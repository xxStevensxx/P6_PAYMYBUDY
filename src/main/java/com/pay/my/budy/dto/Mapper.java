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
		
		UserDTO userDTO = new UserDTO();
			
		userDTO.setFirstname(user.getFirstname());
		userDTO.setName(user.getName());
		userDTO.setBirthdate(user.getBirthdate());
		userDTO.setAddress(user.getAddress());
		userDTO.setUsername(user.getUsername());
 

			return userDTO;
	}
	
	
	public User toUser(UserDTO userDTO) {
		
		User user = new User();
		
		user.setFirstname(userDTO.getFirstname());
		user.setName(userDTO.getName());
		user.setBirthdate(userDTO.getBirthdate());
		user.setAddress(userDTO.getAddress());
		user.setUsername(userDTO.getUsername());

		
			return user;	
	}


	public User toUser(UserSignupDTO userSignupDTO) {
		
		User user = new User();
		
		user.setUsername(userSignupDTO.getUsername());
		user.setPassword(userSignupDTO.getPassword());

			return user;	

	}
	

}
