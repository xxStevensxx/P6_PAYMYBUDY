package com.pay.my.budy.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pay.my.budy.config.SecurityConfiguration;
import com.pay.my.budy.constant.Constante;
import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.model.Authority;
import com.pay.my.budy.model.Relationship;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.AuthorityRepository;
import com.pay.my.budy.repository.RelationShipRepository;
import com.pay.my.budy.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	SecurityConfiguration security;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RelationShipRepository relationRepository;
	
	@Autowired
	AuthorityRepository authRepository;
	
	@Autowired
	Mapper mapper;
		

	public void profil(String username, UserDTO userDTO) {
		

		User userFindInRepository = userRepository.findByusername(username);
		User user = mapper.toUser(userDTO);			
		
				
		if (user.getFirstname().trim() != "") {userFindInRepository.setFirstname(user.getFirstname());}
		
		if (user.getName().trim() != "") {userFindInRepository.setName(user.getName());}
		
		if (user.getBirthdate() != null) {userFindInRepository.setBirthdate(user.getBirthdate());}
		
		if (user.getAddress().trim() != "") {userFindInRepository.setAddress(user.getAddress());}

				
			userRepository.save(userFindInRepository);
		
	}
	
	
	public UserDTO getProfil(String username) {
		
		User user_info = userRepository.findByusername(username);
		UserDTO userDTO = mapper.toDTO(user_info);
			
			return userDTO;
		
	}

	
	
	
	public void signup(User user) {		
		
		user.setPassword(security.passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		User user_info = userRepository.findByusername(user.getUsername());
		
		Authority authority = new Authority();
		authority.setUser_id(user_info.getId());
		authority.setUsername(user.getUsername());
		authority.setAuthority(Constante.USER);
		
		authRepository.save(authority);
		
		
		
	}
	
	
	
	public List<UserDTO> getConnections(String username) {
		
		User user = userRepository.findByusername(username);
		
 		List<Relationship> relationship = user.getFriends();
		List<UserDTO> listDtoFriend = new ArrayList<UserDTO>();
		List<Integer> listIdFriend = new ArrayList<Integer>();
		
		for (int index = 0; index < relationship.size(); index++) {
			
			int friendID = relationship.get(index).getFriend();
			listIdFriend.add(friendID);
			
		}
		
		List<User> friendList = userRepository.findAllById(listIdFriend);
		
		
		for (int index = 0; index < friendList.size(); index++) {
			
			User friend = new User();
			UserDTO userDTO = new UserDTO();

			friend = friendList.get(index);
			userDTO = mapper.toDTO(friend);
			listDtoFriend.add(userDTO);
			
			
		}
		
				return listDtoFriend;
		
	}
	
	
	
	public void addConnection(String email, String username) {
		
		User user = null;
		Relationship relationShip = null;
		List<User> listConnection = userRepository.findAll();
		
		for (int index = 0; index < listConnection.size(); index++) {
			
			if (listConnection.get(index).getUsername().contains(username)) {
				
				 user = listConnection.get(index);
				
			}
			
		}
		
		
		for (int index = 0; index < listConnection.size(); index++) {
			
			if (listConnection.get(index).getUsername().contains(email)) {
				
				relationShip = new Relationship();
				relationShip.setFriend(listConnection.get(index).getId());
				relationShip.setUser_id(user.getId());
			
			}

		}
		
			relationRepository.save(relationShip);		

	}
	
	
}