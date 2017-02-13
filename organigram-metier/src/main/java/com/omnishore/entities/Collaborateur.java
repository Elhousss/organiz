package com.omnishore.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Collaborateur implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2081971288084619717L;
	@Id
	private int idCollaborateur;
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Date dateEmbauche;
	private Date datePremierRec;
	private boolean active;
//	private Titre titre;
//	private Fonction fonction;
	private Entite entite;
//	private Compte compte;
	private Boolean isResponsable;
	
	
	public Collaborateur(String nom, String prenom,
			Date dateNaissance, Date dateEmbauche, Date datePremierRec,
			boolean active, Entite entite, Boolean isResponsable) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.dateEmbauche = dateEmbauche;
		this.datePremierRec = datePremierRec;
		this.active = active;
		this.entite = entite;
		this.isResponsable = isResponsable;
	}
	
public Boolean getIsResponsable() {
		return isResponsable;
	}
	public void setIsResponsable(Boolean isResponsable) {
		this.isResponsable = isResponsable;
	}
	//	public Responsable getResponsable() {
//		return responsable;
//	}
//	public void setResponsable(Responsable responsable) {
//		this.responsable = responsable;
//	}
//	public Titre getTitre() {
//		return titre;
//	}
//	public void setTitre(Titre titre) {
//		this.titre = titre;
//	}
//	public Fonction getFonction() {
//		return fonction;
//	}
//	public void setFonction(Fonction fonction) {
//		this.fonction = fonction;
//	}
	public Entite getEntite() {
		return entite;
	}
	public void setEntite(Entite entite) {
		this.entite = entite;
	}
//	public Compte getCompte() {
//		return compte;
//	}
//	public void setCompte(Compte compte) {
//		this.compte = compte;
//	}
	public int getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(int idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public Date getDatePremierRec() {
		return datePremierRec;
	}
	public void setDatePremierRec(Date datePremierRec) {
		this.datePremierRec = datePremierRec;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
