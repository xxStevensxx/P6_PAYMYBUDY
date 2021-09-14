package com.pay.my.budy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pay.my.budy.dto.Mapper;
import com.pay.my.budy.dto.UserDTO;
import com.pay.my.budy.model.Relationship;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.RelationShipRepository;
import com.pay.my.budy.repository.UserRepository;

public class RelationShipServices {
	
	@Autowired
	Mapper mapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RelationShipRepository relationRepository;
	
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
		Relationship myFriendRelationShip = null;
		
		List<Relationship> listRelationShip = new ArrayList<Relationship>();

		List<User> listConnection = userRepository.findAll();
		
		for (int index = 0; index < listConnection.size(); index++) {
			
			if (listConnection.get(index).getUsername().contains(username)) {
				
				 user = listConnection.get(index);
				
			}
			
		}
		
		
		for (int index = 0; index < listConnection.size(); index++) {
			
			if (email != null && email.trim() != "") {
			
				if (listConnection.get(index).getUsername().contains(email)) {
					
					relationShip = new Relationship();
					myFriendRelationShip = new Relationship();
					
					relationShip.setFriend(listConnection.get(index).getId());
					relationShip.setUser_id(user.getId());
					
					myFriendRelationShip.setFriend(user.getId());
					myFriendRelationShip.setUser_id(listConnection.get(index).getId());
					
					listRelationShip.add(relationShip);
					listRelationShip.add(myFriendRelationShip);
				
				}
			}
		}
		
			relationRepository.saveAll(listRelationShip);		

 	}

}
