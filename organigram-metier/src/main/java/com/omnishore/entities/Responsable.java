package com.omnishore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Responsable extends Collaborateur implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -584512520687580111L;
	
	private Entite entite;
	@Transient
	private Administrateur admin;
	@Transient
	private Collection<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
	@Transient
	private boolean editable;
	
	
	public Responsable(String nom, String prenom,
			Date dateNaissance, Date dateEmbauche, Date datePremierRec,
			boolean active, Entite entite, Boolean isResponsable) {
		super(nom, prenom, dateNaissance, dateEmbauche,
				datePremierRec, active, entite, isResponsable);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public Entite getEntite() {
		return entite;
	}
	public void setEntite(Entite entite) {
		this.entite = entite;
	}
	public Administrateur getAdmin() {
		return admin;
	}
	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	public Collection<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(Collection<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
}
