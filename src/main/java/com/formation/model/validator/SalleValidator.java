package com.formation.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formation.model.Salle;

public class SalleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Salle.class.equals(clazz);
		
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Salle a = (Salle) obj;

	
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom",  "nom obligatoire !!");


		System.out.println("Etape Validator");
		
	}

}
