package com.ikk.demo.data.validation;

import org.springframework.stereotype.Service;

@Service
public class SecurityValidation implements IValidation{

	public boolean validate(int ikkId, String code) {
		//Get the code for ikkId.
		//If code matches, return true
		//else, increment find the count and increment. If it's configured numbe of them, block
		/*
		 * -code
		 * -isBlocked
		 * -count
		 */
		
		
		return false;
	}
	
}
