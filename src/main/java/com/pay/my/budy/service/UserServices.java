package com.pay.my.budy.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.constant.Role;
import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserSignupDTO;
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
		
	
	public void signup(UserSignupDTO userSignupDTO) {	
		
		User user = mapper.toUser(userSignupDTO);
	
		user.setPassword(security.passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		
		User user_info = userRepository.findByusername(user.getUsername());
		
		Authority authority = new Authority();
		authority.setUser_id(user_info.getId());
		authority.setUsername(user.getUsername());
		authority.setAuthority(Role.USER);
		
		authRepository.save(authority);
		
	}
	
	
	
	
	
	
}