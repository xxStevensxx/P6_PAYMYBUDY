package com.pay.my.budy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;

/**
 * <b>Voici la classe MyUserDetailsService qui implements UserDetailsService </b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    UserRepository userRepository;

	
	/**
	 * 
	 * <p> method qui stock les infos user avant de les encapsuler dans l'authentication
	 * @param username, le nom passé en param afin de trouver l'user.
	 * @throws UsernameNotFoundException renvoi une exeption si aucun nom n'est retrouvé
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByusername(username);
		
		if (user == null) {
			
			throw new UsernameNotFoundException(username);	
		}
		
				return user;
	}

}
