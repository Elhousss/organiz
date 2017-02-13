package com.omnishore.vo;

import java.io.Serializable;
import java.util.Date;

public class CollaborateurVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2081971288084619717L;
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Date dateEmbauche;
	private Date datePremierRec;
	private boolean active;
//	private Titre titre;
//	private Fonction fonction;
	private EntiteVo entite;
//	private Compte compte;
	private Boolean isResponsable;
	
	
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
	public EntiteVo getEntite() {
		return entite;
	}
	public void setEntite(EntiteVo entite) {
		this.entite = entite;
	}
//	public Compte getCompte() {
//		return compte;
//	}
//	public void setCompte(Compte compte) {
//		this.compte = compte;
//	}
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
