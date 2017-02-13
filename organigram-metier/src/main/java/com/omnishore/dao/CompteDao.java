package com.omnishore.dao;

import com.omnishore.entities.Compte;

public interface CompteDao {
	
	public void enregistrerCompte(Compte c);
	public Compte trouverCompte(String login);
	public boolean verifierPass(String login, String pass);
	public boolean estAdmin(String login);
}
