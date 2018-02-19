package com.formation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.formation.dao.SalleDao;
import com.formation.model.Prof;
import com.formation.model.Salle;

@Controller
@RequestMapping("/salle")
public class SalleController {

	@Autowired
	SalleDao salleDao;


	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewSalleForm(Model model) {
				
		model.addAttribute("action","Ajouter");		

		Salle a = new Salle();
		
		model.addAttribute("salle",a);
		
		return "salle/addSalle";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewSalleForm(@ModelAttribute("salle") Salle salle, BindingResult result, Model model,
			HttpServletRequest request) {
		
		System.out.println("dans le add POST");

		if (salle.getId() == null) {
			salleDao.save(salle);
		} else {
			salleDao.update(salle);
		}
		return "redirect:/salle/list";
		
	}

	@RequestMapping(value = "/list")
	public String listSalle(Model model) {
		List<Salle> listSalle = salleDao.findAll();
		model.addAttribute("listeSalles", listSalle);
		return "salle/listSalle";
	}


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getAddNewArtistForm(@PathVariable(value = "id")  Long id, Model model) {
		model.addAttribute("action", "Editer");

		Salle a = salleDao.findByPrimaryKey(id);
		if (a == null) {
			return "redirect:/error";
		}
		model.addAttribute("salle", a);
		return "salle/addSalle";
	}
	
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public String deleteProf(Model model, @PathVariable("id") Long id) {
		Salle a = salleDao.findByPrimaryKey(id);
		salleDao.delete(a);

		return "redirect:/salle/list";

	}	
	
}
