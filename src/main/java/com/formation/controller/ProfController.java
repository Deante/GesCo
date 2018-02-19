package com.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.dao.ProfDao;
import com.formation.model.Prof;
import com.formation.model.validator.ProfValidator;

@Controller
@RequestMapping("/prof")
public class ProfController {

	@Autowired
	ProfDao profDao;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewArtistForm(Model model) {
		model.addAttribute("action", "Ajouter");     
                                                    
		Prof a = new Prof();

		model.addAttribute("prof", a);
		return "prof/addProf";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewArtistForm(@ModelAttribute("prof") Prof prof, BindingResult result) {

		Validator profValidator = new ProfValidator();
		profValidator.validate(prof, result);
	
		if( result.hasErrors()) {System.err.println("errorsencountered!!");
			return "prof/addProf";
		}

		
		if (prof.getId() <= 0) {
			profDao.save(prof);
		} else {
			profDao.update(prof);
		}
		return "redirect:/prof/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getAddNewArtistForm(@PathVariable(value = "id")  Long id, Model model) {
		model.addAttribute("action", "Editer");

		Prof a = profDao.findByPrimaryKey(id);
		if (a == null) {
			return "redirect:/error";
		}
		model.addAttribute("prof", a);
		return "prof/addProf";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProfDetail(Model model, @PathVariable("id") Long id) {
		Prof a = profDao.findByPrimaryKey(id);

		model.addAttribute("profFromDb", a);
		return "prof/showProf";
	}

	@RequestMapping(value = "/list")
	public String listArtist(Model model) {
		List<Prof> listArt = profDao.findAll();
		model.addAttribute("listeProfs", listArt);
		return "prof/listProf";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProf(Model model, @PathVariable("id") Long id) {
		Prof a = profDao.findByPrimaryKey(id);
		profDao.delete(a);

		return "redirect:/prof/list";

	}

}