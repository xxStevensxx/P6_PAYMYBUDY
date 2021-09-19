package com.pay.my.budy.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.constant.Role;
import com.pay.my.budy.dto.UserSignupDTO;
import com.pay.my.budy.mapper.Mapper;
import com.pay.my.budy.model.Authority;
import com.pay.my.budy.model.Bankaccount;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.AuthorityRepository;
import com.pay.my.budy.repository.BankaccountRepository;
import com.pay.my.budy.repository.UserRepository;

/**
 * <b>Voici la classe UserServices </b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Service
public class UserServices {
	
	@Autowired
	SecurityConfiguration security;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthorityRepository authRepository;
	
	@Autowired
	BankaccountRepository bankRepository;
	
	@Autowired
	Mapper mapper;
		
	
	/**
	 * 
	 * @param userSignupDTO, l'objet  userSignupDTO qui sera mappé en user afin de creer ses infos et ouvrir son compte PAymybudy automatiquement
	 */
	public void signup(UserSignupDTO userSignupDTO) {	
		
		
		User user = mapper.toUser(userSignupDTO);
		User user_info = userRepository.findByusername(user.getUsername());

		
		if (user_info == null) {
			
			user.setPassword(security.passwordEncoder().encode(user.getPassword()));
			userRepository.save(user);
			
			User userToPersist = userRepository.findByusername(user.getUsername());

			
			Bankaccount bank = new Bankaccount();
			bank.setIdUser(userToPersist.getId());
			bank.setMoneyAvailable(0.0);
			
			bankRepository.save(bank);	
			
			Authority authority = new Authority();
			authority.setUser_id(userToPersist.getId());
			authority.setUsername(user.getUsername());
			authority.setAuthority(Role.USER);
			
			authRepository.save(authority);
			
			
		}
	

		
	}
	
	
	
	
	
	
}