package com.formation.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.formation.model.Prof;

public class ProfValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Prof.class.equals(clazz);
		
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Prof a = (Prof) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "prof.addProf.input.prenom.empty",
				"introduisez votre prénom!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "prof.addProf.input.nom.empty", "il faut un nom !!");

		if (a.getPrenom() != null && a.getPrenom().length() < 3 || a.getPrenom().length() > 24) {
			errors.rejectValue("prenom", "prof.addProf.input.prenom.notvalid", "prénom invalide");
		}

		if (a.getNom() != null && a.getNom().length() < 3 || a.getNom().length() > 24) {
			errors.rejectValue("nom", "prof.addProf.input.nom.notvalid", "nom invalide");
		}

	}

}
