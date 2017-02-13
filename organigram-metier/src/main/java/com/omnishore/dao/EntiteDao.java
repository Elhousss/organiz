package com.omnishore.dao;

import java.util.List;

import com.omnishore.entities.Entite;

public interface EntiteDao {
	
	public void enregistrerEntite(Entite entite);
	public Entite trouverEntite(int entiteID);
	public int getMaxID();
	public List<Entite> getEntites();
	public void modifierEntite(int idEntite, Entite entite);
	public void supprimerEntite(int idEntite);
	public boolean verifierNom(String nomEntite);
}
