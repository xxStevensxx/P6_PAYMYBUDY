package com.pay.my.budy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pay.my.budy.model.MyUserPrincipal;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByusername(username);
		
		if (user == null) {
			
			throw new UsernameNotFoundException(username);	
		}
		
				return user;
	}

}
