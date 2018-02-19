package com.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.swing.text.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity(name = "matiere")
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nom;

	private Couleur couleur;

	@ManyToMany
	private List<Salle> salles;

	@ManyToMany
	private List<Prof> profs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public List<Prof> getProfs() {
		return profs;
	}

	public void setProfs(List<Prof> profs) {
		this.profs = profs;
	}

	public Matiere(String nom, Couleur couleur, List<Salle> salles, List<Prof> profs) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.salles = salles;
		this.profs = profs;
	}
	
	public Matiere() {
		super();
	}

}
