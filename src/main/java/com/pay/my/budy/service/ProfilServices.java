package com.pay.my.budy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.model.Bankaccount;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.BankaccountRepository;
import com.pay.my.budy.repository.UserRepository;

/**
 * <b>Voici la classe ProfilServices </b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Service
public class ProfilServices {
	
	@Autowired
	Mapper mapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankaccountRepository bankRepository;

	
	/**
	 * 
	 * @param username, le username passé en param afin de traiter 
	 * @param userDTO les infos (type DTO) de la vue qui a traversé la vue et le controller pour etre mappé en user via mapper.toUSER dans la couche service
	 */
	public void profil(String username, UserDTO userDTO) {
		
		User user = mapper.toUser(userDTO);			
		List<Bankaccount> bank = user.getBankaccount();
		User userFindInRepository = userRepository.findByusername(username);
			
		
		if (user.getFirstname().trim() != "") {userFindInRepository.setFirstname(user.getFirstname());}
		
		if (user.getName().trim() != "") {userFindInRepository.setName(user.getName());}
		
		if (user.getBirthdate() != null) {userFindInRepository.setBirthdate(user.getBirthdate());}
		
		if (user.getAddress().trim() != "") {userFindInRepository.setAddress(user.getAddress());}

				
			userRepository.save(userFindInRepository);
			bankRepository.saveAll(bank);
		
	}
	
	/**
	 * 
	 * @param username, la variable qui nous permettra de retrouvé l'utilisateur.
	 * @return userDTO, un DTO qui sera transmit au differente couche jusqu'a la vue
	 */
	public UserDTO getProfil(String username) {
		
		User user_info = userRepository.findByusername(username);
		UserDTO userDTO = mapper.toDTO(user_info);
			
			return userDTO;
		
	}


}
