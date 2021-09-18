package com.pay.my.budy.service;

import org.springframework.stereotype.Service;

@Service
public class Calcul {
	
	
	public double fivePercent(double amount) {
		
		return amount * 0.5;
		
	}
	
	
	public double somme(double moneyavailable, double montant) {
		
		double resultat = moneyavailable - montant;
		
		return resultat * 0.5;
		
	}
	
	
	public double add(double a, double b) {
		
		
		return a + b;
	}
	
	
	public double less(double a, double b) {
		
		return a - b;
	}
	
	
	
}
