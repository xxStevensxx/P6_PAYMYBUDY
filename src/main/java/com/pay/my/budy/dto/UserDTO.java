package com.pay.my.budy.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class UserDTO {
	
	private int id;
	private String name;
	private String firstname;
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = {"M/d/yy", "dd.MM.yyyy"})
	private LocalDate birthdate;
	private String address;
	private String username;
	private String friend;
	
	private double amount;
	
	private List<BankaccountDTO> bankaccounts;
	private List<FriendDTO> friends;	
	private List<TransactionDTO> transactions;
	
	
	
	public UserDTO() {}
	public UserDTO(String name, String firstname, String address, String username, LocalDate birthdate) {}
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<BankaccountDTO> getBankaccounts() {
		return bankaccounts;
	}
	public void setBankaccounts(List<BankaccountDTO> bankaccounts) {
		this.bankaccounts = bankaccounts;
	}
	public List<FriendDTO> getFriends() {
		return friends;
	}
	public void setFriends(List<FriendDTO> friends) {
		this.friends = friends;
	}
	public List<TransactionDTO> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFriend() {
		return friend;
	}
	public void setFriend(String friend) {
		this.friend = friend;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
