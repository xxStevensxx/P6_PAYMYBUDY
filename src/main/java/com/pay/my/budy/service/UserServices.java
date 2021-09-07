package com.pay.my.budy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository userRepository;

	public void profilServices(String username, User user) {
			
		User userFindInRepository = userRepository.findByusername(username);
		
		userFindInRepository.setFirstname(user.getFirstname());
		userFindInRepository.setName(user.getName());
		userFindInRepository.setBirthdate(user.getBirthdate());
		userFindInRepository.setAddress(user.getAddress());
				
			userRepository.save(userFindInRepository);
		
	}
	
	
}