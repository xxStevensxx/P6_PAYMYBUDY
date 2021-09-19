package com.pay.my.budy.test.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculTest {
	
	
	@Test
	public void fivePercentTest() {
		
		//GIVEN
		double a = 10;
		double result = 9.5;
		
		
		//WHEN
		double sommeOne = a * 0.05;
		double sommeTwo = a - sommeOne;
		
		
		
		//THEN
		assertEquals(result, sommeTwo);
		
	}
	
	
	@Test
	public void addTest() {
		
		//GIVEN
		double a = 6.6;
		double b = 5.5;
		
				
		//WHEN
				
		double result = a + b;
		
		//THEN
		assertEquals(12.1, result);
		
		
	}
	
	
	
	@Test
	public void lessTest() {
		
		//GIVEN
		double a = 6;
		double b = 5;
		
		
		//WHEN
		double result = a - b;
		
		
		//THEN
		assertEquals(1, result);
		
	}

}
