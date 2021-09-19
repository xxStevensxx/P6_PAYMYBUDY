package com.pay.my.budy.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.mapper.Mapper;
import com.pay.my.budy.model.Bankaccount;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;

@SpringBootTest
@Transactional
public class ProfilServicesTestIT {
	
	
	@Autowired
	UserRepository repoTest;
	
	@Autowired
	Mapper mapper;
	
	
	@Test
	public void profilTest() {
		
		//GIVEN
		User user = new User("test");
		Bankaccount bank = new Bankaccount("FR76*************", 20.5, 1);
		
		List<Bankaccount> listBank = new ArrayList<Bankaccount>();
		listBank.add(bank);
	
		
		//WHEN
		user.setBankaccount(listBank);
		UserDTO dto = mapper.toDTO(user);
		
		//THEN
		assertEquals(user.getUsername(), dto.getUsername());
		assertEquals(user.getBankaccount().get(0).getIban(), dto.getBankaccounts().get(0).getIban());

		
	}
	
	
	
	@Test
	public void getProfilTest() {
		
		//GIVEN
		User user = new User("test"); 
		repoTest.save(user);
		
		//WHEN
		User actual = repoTest.findByusername(user.getUsername());
		
		
		//THEN
		assertEquals("test", actual.getUsername());
		
	}

}
