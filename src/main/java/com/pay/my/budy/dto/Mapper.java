package com.pay.my.budy.dto;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pay.my.budy.model.Bankaccount;
import com.pay.my.budy.model.Relationship;
import com.pay.my.budy.model.Transactions;
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
		
//		userDTO.getFriends().get(0).getFirstname();
		
		if (user.getBankaccount() != null) {
			
			List<BankaccountDTO> listBankAccount = new ArrayList<>();
			
			for (int i = 0; i < user.getBankaccount().size(); i++) {
				
				BankaccountDTO bank = new BankaccountDTO();
				bank.setIban(user.getBankaccount().get(i).getIban());
				bank.setMoneyavailable(user.getBankaccount().get(i).getMoneyAvailable());
				
				listBankAccount.add(bank);
			}
			
			userDTO.setBankaccounts(listBankAccount);
			
		}
		
		
		if (user.getFriends() != null) {
			
			List<FriendDTO> listFriend = new ArrayList<FriendDTO>();
			List<User> listUser = userRepository.findAll();
			
			for (int i = 0; i < user.getFriends().size(); i++) {
								
					for (int j = 0; j < listUser.size(); j++) {
						
					if (user.getFriends().get(i).getFriend() == listUser.get(j).getId()) {
						
						/*
						 * System.err.println(user.getFriends().get(i).getFriend());
						 * System.err.println(listUser.get(j).getId());
						 */
						
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
		
		
		if (user.getTransactions() != null) {
			
			List<User> users = userRepository.findAll();
			List<TransactionDTO> listTransacDTO = new ArrayList<>(); 
			String username = null;
			
			for (int i = 0; i < user.getTransactions().size(); i++) {
				
				if (user.getTransactions().get(i).getFk_iduser() == user.getId()) {
					
					TransactionDTO transacDTO = new TransactionDTO();
					
					for (User getUser : users) {
						
						if (getUser.getId() == user.getTransactions().get(i).getRecipient()) {
							
							 username = getUser.getUsername();
							 
						}
						
					}
					
					transacDTO.setUsername(username);
					transacDTO.setAmount(user.getTransactions().get(i).getAmount());
					transacDTO.setDate(user.getTransactions().get(i).getDate());
					transacDTO.setLabel(user.getTransactions().get(i).getLabel());
					
					listTransacDTO.add(transacDTO);
					
				}
				
			}
			
			userDTO.setTransactions(listTransacDTO);
						
		}
		
			return userDTO;
	}
	
	
	
	
	public User toUser(UserDTO userDTO) {
		
		List<User> users = userRepository.findAll();
		
		User user = new User();
		Relationship relation = new Relationship();
		Bankaccount bankaccount = new Bankaccount();
		Transactions transaction = new Transactions();
		
		List<Relationship> relations = new ArrayList<Relationship>();
		List<Bankaccount> bankaccounts = new ArrayList<Bankaccount>();
		List<Transactions> tranactions = new ArrayList<Transactions>();
		
		user.setFirstname(userDTO.getFirstname());
		user.setName(userDTO.getName());
		user.setBirthdate(userDTO.getBirthdate());
		user.setAddress(userDTO.getAddress());
		user.setUsername(userDTO.getUsername());
		
		
		if (userDTO.getFriend() != null) {
			
			for (int i = 0; i < userDTO.getFriends().size(); i++) {
				
				relation.setFriend(userDTO.getFriends().get(i).getId());
				relation.setUser_id(userDTO.getId());
				
			}
			
		}
		
	
		
		if (userDTO.getBankaccounts() != null) {
			
			for (int i = 0; i < userDTO.getBankaccounts().size(); i++) {
				
				bankaccount.setDate(userDTO.getBankaccounts().get(i).getDate());
				bankaccount.setIban(userDTO.getIban());
				bankaccount.setMoneyAvailable(userDTO.getBankaccounts().get(i).getMoneyavailable());
				bankaccount.setIdUser(userDTO.getId());
								
			}
			
		}
		
	
		
		if (userDTO.getTransactions() != null) {
			for (int i = 0; i < userDTO.getTransactions().size(); i++) {
				
				int recipient = 0;
				
				transaction.setAmount(userDTO.getTransactions().get(i).getAmount());
				transaction.setDate(LocalDate.now());
				transaction.setLabel(userDTO.getLabel());

				
			for (int j = 0; j < users.size(); j++) {
					
					if (users.get(j).getUsername().contains(userDTO.getFriends().get(i).getUsername())) {
						
						recipient = users.get(j).getId();
					}
					
				}
			
				transaction.setRecipient(recipient);
				transaction.setFk_iduser(userDTO.getId());
				
			}
			
		}

		
		relations.add(relation);
		bankaccounts.add(bankaccount);
		tranactions.add(transaction);
		
		user.setFriends(relations);
		user.setBankaccount(bankaccounts);
		user.setTransactions(tranactions);
	
			return user;	
	}


	public User toUser(UserSignupDTO userSignupDTO) {
		 
		User user = new User();
		
		user.setUsername(userSignupDTO.getUsername());
		user.setPassword(userSignupDTO.getPassword());

			return user;	

	}


}
