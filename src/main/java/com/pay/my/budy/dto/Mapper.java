package com.pay.my.budy.dto;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pay.my.budy.model.User;
import com.pay.my.budy.repository.UserRepository;

@Component
public class Mapper {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDTO userDTO;
	
	@Autowired
	User user;
	
	public UserDTO toDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
			
		userDTO.setFirstname(user.getFirstname());
		userDTO.setName(user.getName());
		userDTO.setBirthdate(user.getBirthdate());
		userDTO.setAddress(user.getAddress());
		userDTO.setUsername(user.getUsername());
		
		if (!user.getBankaccount().isEmpty()) {
			
			List<BankaccountDTO> listBankAccount = new ArrayList<>();
			
			for (int i = 0; i < user.getBankaccount().size(); i++) {
				
				BankaccountDTO bank = new BankaccountDTO();
				bank.setIban(user.getBankaccount().get(i).getIban());
				bank.setMoneyavailable(user.getBankaccount().get(i).getMoneyAvailable());
				
				listBankAccount.add(bank);
			}
			
			userDTO.setBankaccounts(listBankAccount);
			
		}
		
		
		if (!user.getFriends().isEmpty()) {
			
			List<FriendDTO> listFriend = new ArrayList<FriendDTO>();
			List<User> listUser = userRepository.findAll();
			
			for (int i = 0; i < user.getFriends().size(); i++) {
								
					for (int j = 0; j < listUser.size(); j++) {
						
					if (user.getFriends().get(i).getFriend() == listUser.get(j).getId()) {
						
						System.err.println(user.getFriends().get(i).getFriend());
						System.err.println(listUser.get(j).getId());
						
					FriendDTO friendsDTO = new FriendDTO();
						
						friendsDTO.setUsername(listUser.get(j).getUsername());
						friendsDTO.setAddress(listUser.get(j).getAddress());
						friendsDTO.setFirstname(listUser.get(j).getFirstname());
						friendsDTO.setName(listUser.get(j).getName());
						friendsDTO.setBirthdate(listUser.get(j).getBirthdate());
						
						listFriend.add(friendsDTO);
						
						}

					}
				}
				
				

			
			userDTO.setFriends(listFriend);
		}
		
			return userDTO;
	}
	
	
	public User toUser(UserDTO userDTO) {
		
		User user = new User();
		
		user.setFirstname(userDTO.getFirstname());
		user.setName(userDTO.getName());
		user.setBirthdate(userDTO.getBirthdate());
		user.setAddress(userDTO.getAddress());
		user.setUsername(userDTO.getUsername());

		
			return user;	
	}


	public User toUser(UserSignupDTO userSignupDTO) {
		
		User user = new User();
		
		user.setUsername(userSignupDTO.getUsername());
		user.setPassword(userSignupDTO.getPassword());

			return user;	

	}


}
