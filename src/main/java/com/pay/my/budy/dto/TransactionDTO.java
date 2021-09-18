package com.pay.my.budy.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


@Component
public class TransactionDTO {
	
	
	private int id;
	
	private LocalDate date;
	
	private double amount;

	private String label;
	
	private int fk_iduser;
	
	private String username;
	
	private int recipient;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getFk_iduser() {
		return fk_iduser;
	}

	public void setFk_iduser(int fk_iduser) {
		this.fk_iduser = fk_iduser;
	}

	public int getRecipient() {
		return recipient;
	}

	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
