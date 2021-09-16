package com.pay.my.budy.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



public class TransfertDTO {
	
	private String name;
	private String firstname;
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = {"M/d/yy", "dd.MM.yyyy"})
	private LocalDate birthdate;
	private String address;
	private String username;
	private String iban;
	private double moneyavailable;
	private List<FriendDTO> relationship;
	private List<?> bankaccount;
	
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
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public double getMoneyavailable() {
		return moneyavailable;
	}
	public void setMoneyavailable(double moneyavailable) {
		this.moneyavailable = moneyavailable;
	}
	public List<FriendDTO> getRelationship() {
		return relationship;
	}
	public void setRelationship(List<FriendDTO> relationship) {
		this.relationship = (List<FriendDTO>) relationship;
	}
	public List<?> getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(List<?> bankaccount) {
		this.bankaccount = bankaccount;
	}
	
}
