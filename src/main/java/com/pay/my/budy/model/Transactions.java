package com.pay.my.budy.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="transactions")
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = {"M/d/yy", "dd.MM.yyyy"})
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "amount")
	private double amount;

	@Column(name = "label")
	private String label;
	
	@Column(name = "fk_iduser")
	private int fk_iduser;
	
	@Column(name = "recipient")
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

}

