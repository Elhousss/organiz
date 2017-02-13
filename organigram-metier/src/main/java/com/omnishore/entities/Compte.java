package com.omnishore.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Compte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8644199035702631049L;
	@Id
	private String login;
	private String email;
	private String motDePasse;
	private String nom;
	private String prenom;
	@Transient
	private Collaborateur collaborateur;
	@Transient
	private String confirmationPWD;
	private boolean estAdmin;
	private boolean estResponsable;
	
	
	public boolean isEstAdmin() {
		return estAdmin;
	}
	public void setEstAdmin(boolean estAdmin) {
		this.estAdmin = estAdmin;
	}
	public boolean isEstResponsable() {
		return estResponsable;
	}
	public void setEstResponsable(boolean estResponsable) {
		this.estResponsable = estResponsable;
	}
	public String getConfirmationPWD() {
		return confirmationPWD;
	}
	public void setConfirmationPWD(String confirmationPWD) {
		this.confirmationPWD = confirmationPWD;
	}
	public Collaborateur getCollaborateur(){
		return collaborateur;
	}
	public void setCollaborateur(Collaborateur collaborateur) {
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
