package com.pay.my.budy.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class BankaccountDTO {
	
	private String iban;
	private double moneyavailable;
	private LocalDate date;
	
	
	
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
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	

	

}
