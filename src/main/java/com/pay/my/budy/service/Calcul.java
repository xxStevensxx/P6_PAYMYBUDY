package com.pay.my.budy.service;

import org.springframework.stereotype.Service;


/**
 * <b>Voici la classe Calcul</b>
 * 
 *
 * 
 * @author Stevens
 * @version beta
 */
@Service
public class Calcul {
	
	
	/**
	 * 
	 * @param amount le montant d'ou l'ont doit dewduire les 5%.
	 * @return le montant - les 5%;
	 */
	public double fivePercent(double amount) {
		
		double result = amount * 0.05;
		
		
		return amount - result;
		
	}
	
	
	/**
	 * 
	 * @param moneyavailable, argent disponible sur le compte du payeurs
	 * @param montant montant qui sera envoyé
	 * @return le resultat - 5%;
	 */
	public double somme(double moneyavailable, double montant) {
		
		double resultat = moneyavailable - montant;
		
		return resultat * 0.5;
		
	}
	
	
	/**
	 * 
	 * @param a, la somme a
	 * @param b, la somme b
	 * @return l'adition des deux sommes
	 */
	public double add(double a, double b) {
		
		
		return a + b;
	}
	
	
	/**
	 * 
	 * @param a, la somme a
	 * @param b, la somme b
	 * @return, la soustraction des deux sommes.
	 */
	public double less(double a, double b) {
		
		return a - b;
	}
	
	
	
}
