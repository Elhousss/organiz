package com.omnishore.services.api;

import java.util.List;

import com.omnishore.vo.EntiteVo;

public interface IEntityService {
	
	public void enregistrerEntite(EntiteVo entite);
	public EntiteVo trouverEntite(int entiteID);
	public List<EntiteVo> getEntites();
	public void modifierEntite(int idEntite, EntiteVo entite);
	public void supprimerEntite(int idEntite);
	public boolean verifierNom(String nomEntite);
	

}
