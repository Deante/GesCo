package com.formation.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.formation.dao.MatiereDao;
import com.formation.model.Couleur;
import com.formation.model.Matiere;
import com.formation.model.validator.MatiereValidator;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private MatiereDao matiereDao;

	private Validator matiereValid = new MatiereValidator();;

	@RequestMapping(value = "/listMatiere", method = RequestMethod.GET)
	public String listMatiere(Model model) {

		List<Matiere> matieres = new ArrayList<>();
		matieres = matiereDao.findAll();
		model.addAttribute("matieres", matieres);
		if (!model.containsAttribute("matiere")) {
	        model.addAttribute("matiere", new Matiere());
	    }
		List<Couleur> couleurs = new ArrayList<Couleur>(EnumSet.allOf(Couleur.class));
		model.addAttribute("couleurs", couleurs);
		return "matiere/listMatiere";
	}

	@RequestMapping("/show/{id}")
	public String afficheMatiere(Model model, @PathVariable("id") Long id) {

		return "matiere/jspname";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMatiereP(@ModelAttribute("matiere") Matiere matiere, Model model, BindingResult result, RedirectAttributes redirectAttrs) {

		matiereValid.validate(matiere, result);
		
		if (result.hasErrors()) {
			List<FieldError> Errors = result.getFieldErrors();
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.matiere", result);
			redirectAttrs.addFlashAttribute("matiere", matiere);
		} else {
			matiereDao.save(matiere);
		}
		return "redirect:/matiere/listMatiere";
	}

	@RequestMapping("del/{id}")
	public String supprMatiere(Model model, @PathVariable("id") Long id) {
		Matiere matiere = matiereDao.findByPrimaryKey(id);
		matiereDao.delete(matiere);

		return "redirect:/matiere/listMatiere";
	}

	@RequestMapping("edit/{id}")
	public String modifMatiere(Model model, @PathVariable("id") Long id) {
		Matiere matiere = matiereDao.findByPrimaryKey(id);
		model.addAttribute("matiere", matiere);
		List<Couleur> couleurs = new ArrayList<Couleur>(EnumSet.allOf(Couleur.class));
		model.addAttribute("couleurs", couleurs);
		return "matiere/editMatiere";

	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String modifMatiere(Model model, @PathVariable("id") Long id, @ModelAttribute("matiere") Matiere matiere) {

		matiereDao.update(matiere);
		return "redirect:/matiere/listMatiere";

	}
}
