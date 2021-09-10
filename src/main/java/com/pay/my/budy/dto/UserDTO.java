package com.pay.my.budy.dto;

import java.time.LocalDate;

public class UserDTO {
	
	
	private String firstname;
	private String name;
	private LocalDate birthdate;
	private String address;
	
	
	
	public UserDTO() {}
	public UserDTO(String firstname, String name, LocalDate birthdate, String address) {}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

}
