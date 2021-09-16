package com.pay.my.budy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.repository.UserRepository;


@Service
public class TransfertServices {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RelationShipServices relationServices;
	
	@Autowired
	Mapper mapper;
	
	public UserDTO DisplayInfotransfert(String username) {
		
		UserDTO userDTO = mapper.toDTO(userRepository.findByusername(username));	
				
				return userDTO;
		
	}

}
