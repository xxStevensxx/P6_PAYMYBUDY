package com.pay.my.budy.dto;

import java.time.LocalDate;

import com.pay.my.budy.model.User;

public class Mapper {
	
	
	
	public UserDTO toDTO(User user) {
		
		String name = user.getName();
		String firstname = user.getFirstname();
		LocalDate birthdate = user.getBirthdate();
		String address = user.getAddress();
		
			return new UserDTO(name, firstname, birthdate, address);
	}
	
	
	public User toUser(UserDTO userDTO) {
		
			return new User(userDTO.getFirstname(), userDTO.getName(), userDTO.getBirthdate(), userDTO.getAddress());	
	}
	

}
