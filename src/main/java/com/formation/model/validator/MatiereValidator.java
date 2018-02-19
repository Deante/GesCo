package com.formation.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formation.model.Matiere;

public class MatiereValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Matiere.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Matiere matiere = (Matiere) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "nom.empty", "A name is required");

	}

}
