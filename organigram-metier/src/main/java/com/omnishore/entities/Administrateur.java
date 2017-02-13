package com.omnishore.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Administrateur extends Collaborateur{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2511921646664759862L;
	private Collection<Entite> entites = new ArrayList<Entite>();
	private Collection<Responsable> responsables = new ArrayList<Responsable>();
	
	
	public Administrateur(String nom, String prenom, Date dateNaissance,
			Date dateEmbauche, Date datePremierRec, boolean active,
			Entite entite, Boolean isResponsable) {
		super(nom, prenom, dateNaissance, dateEmbauche, datePremierRec, active, entite,
				isResponsable);
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Entite> getEntites() {
		return entites;
	}
	public void setEntites(Collection<Entite> entites) {
		this.entites = entites;
	}
	public Collection<Responsable> getResponsables() {
		return responsables;
	}
	public void setResponsables(Collection<Responsable> responsables) {
		this.responsables = responsables;
	}

	
}
