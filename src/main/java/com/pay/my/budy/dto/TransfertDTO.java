package com.pay.my.budy.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;


@Component
public class TransfertDTO {
	

	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = {"M/d/yy", "dd.MM.yyyy"})
	private LocalDate date;
	private String username;
	private String friend;
	private double amount;
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
