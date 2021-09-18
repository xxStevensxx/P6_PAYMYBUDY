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


@Service
public class ProfilServices {
	
	@Autowired
	Mapper mapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankaccountRepository bankRepository;

	
	
	public void profil(String username, UserDTO userDTO) {
		
		User user = mapper.toUser(userDTO);	
		List<Bankaccount> banks = user.getBankaccount();
		Bankaccount bank = new Bankaccount();
		User userFindInRepository = userRepository.findByusername(username);
			
		
		if (user.getFirstname().trim() != "") {userFindInRepository.setFirstname(user.getFirstname());}
		
		if (user.getName().trim() != "") {userFindInRepository.setName(user.getName());}
		
		if (user.getBirthdate() != null) {userFindInRepository.setBirthdate(user.getBirthdate());}
		
		if (user.getAddress().trim() != "") {userFindInRepository.setAddress(user.getAddress());}
		
		for (int i = 0; i < banks.size(); i++) {
			
			bank.setIdAccount(userFindInRepository.getBankaccount().get(i).getIdAccount());
			bank.setIdUser(userFindInRepository.getId());
			bank.setIban(userDTO.getIban());
			bank.setDate(userFindInRepository.getBankaccount().get(i).getDate());
			bank.setMoneyAvailable(userFindInRepository.getBankaccount().get(i).getMoneyAvailable());
			
			
		}
		
			userRepository.save(userFindInRepository);
			bankRepository.save(bank);
		
	}
	
	
	public UserDTO getProfil(String username) {
		
		User user_info = userRepository.findByusername(username);
		UserDTO userDTO = mapper.toDTO(user_info);
			
			return userDTO;
		
	}


}
