package com.formation.controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.dao.SalleDao;
import com.formation.model.Couleur;
import com.formation.model.Salle;


@Controller
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	SalleDao salleDao;


	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewSalleForm(Model model) {
		model.addAttribute("action", "Ajouter");

		Salle a = new Salle();

		model.addAttribute("salle", a);
		return "salle/addSalle";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewSalleForm(@ModelAttribute("salle") Salle salle, BindingResult result,
			Model model, HttpServletRequest request) {

		
		List<Couleur> couleurs = new ArrayList<Couleur>(EnumSet.allOf(Couleur.class));
        model.addAttribute("couleurs", couleurs);		

		if (result.hasErrors()) {
			System.out.println("Errors sur la marque : " + result.getErrorCount());
			result.getFieldError("marque");
			request.setAttribute("errors", result);

			return "salle/addSalle";

		} else {

			if (salle.getId() <= 0) {
				salleDao.save(salle);
			} else {
				salleDao.update(salle);
			}
			return "redirect:/salle/list";
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getAddNewSalleForm(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("action", "Editer");

		
		List<Couleur> couleurs = new ArrayList<Couleur>(EnumSet.allOf(Couleur.class));
        model.addAttribute("couleurs", couleurs);				
		
		Salle a = salleDao.findByPrimaryKey(id);
		if (a == null) {
			return "redirect:/error";
		}
		model.addAttribute("salle", a);
		return "salle/addSalle";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getSalleDetail(Model model, @PathVariable("id") Long id) {
		Salle a = salleDao.findByPrimaryKey(id);

		model.addAttribute("salleFromDb", a);
		return "salle/showSalle";
	}

	@RequestMapping(value = "/list")
	public String listSalle(Model model) {
		List<Salle> listSalle = salleDao.findAll();
		model.addAttribute("listeSalles", listSalle);
		return "salle/listSalle";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSalle(Model model, @PathVariable("id") Long id) {
		Salle a = salleDao.findByPrimaryKey(id);
		salleDao.delete(a);

		return "redirect:/salle/list";

	}

}
