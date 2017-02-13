package com.omnishore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Entite implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9193828424545931894L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int idEntite;
	private String nom;
	private String description;
	@Transient
	private Collection<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
	@Transient
	private Responsable responsable;
	@Transient
	private Administrateur admin;
	@Transient
	private Entite entiteMere;
	
	
	public Entite(int idEntite, String nom, String description,
			Collection<Collaborateur> collaborateurs, Responsable responsable,
			Administrateur admin, Entite entiteMere) {
		super();
		this.idEntite = idEntite;
		this.nom = nom;
		this.description = description;
		this.collaborateurs = collaborateurs;
		this.responsable = responsable;
		this.admin = admin;
		this.entiteMere = entiteMere;
	}
	
	public Entite getEntiteMere() {
		return entiteMere;
	}
	public void setEntiteMere(Entite entiteMere) {
		this.entiteMere = entiteMere;
	}
	public Collection<Collaborateur> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(Collection<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public Administrateur getAdmin() {
		return admin;
	}
	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}
	public int getIdEntite() {
		return idEntite;
	}
	public void setIdEntite(int idEntite) {
		this.idEntite = idEntite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
