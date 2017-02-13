package com.omnishore.vo;

import java.io.Serializable;

public class CompteVo implements Serializable{
	public CompteVo(String login, String email, String motDePasse, String nom,
			String prenom, CollaborateurVo collaborateur,
			String confirmationPWD, boolean estAdmin, boolean estResponsable) {
		super();
		this.login = login;
		this.email = email;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.collaborateur = collaborateur;
		this.confirmationPWD = confirmationPWD;
		this.isAdmin = estAdmin;
		this.isResponsable = estResponsable;
	}
	
	public CompteVo() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8644199035702631049L;
	private String login;
	private String email;
	private String motDePasse;
	private String nom;
	private String prenom;
	private CollaborateurVo collaborateur;
	private String confirmationPWD;
	private Boolean isAdmin;
	private Boolean isResponsable;
	
	
	public boolean isEstAdmin() {
		return isAdmin;
	}
	public void setEstAdmin(boolean estAdmin) {
		this.isAdmin = estAdmin;
	}
	public Boolean isEstResponsable() {
		return isResponsable;
	}
	public void setEstResponsable(Boolean estResponsable) {
		this.isResponsable = estResponsable;
	}
	public String getConfirmationPWD() {
		return confirmationPWD;
	}
	public void setConfirmationPWD(String confirmationPWD) {
		this.confirmationPWD = confirmationPWD;
	}
	public CollaborateurVo getCollaborateur(){
		return collaborateur;
	}
	public void setCollaborateur(CollaborateurVo collaborateur) {
		this.collaborateur = collaborateur;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
	
}
