package com.omnishore.services.api;

import java.util.Map;

import com.omnishore.entities.Compte;
import com.omnishore.vo.CompteVo;

public interface IInscriptionService {
	
	/**
	 * Cette méthode permet de savoir si il y'avait des erreurs lors de la création du compte
	 * @param cmp
	 * @return boolean
	 */
	public boolean checkErreurs(CompteVo cmp);
	
	public void enregistrerCompte(CompteVo c);
	
	public Map<String, String> getErreurs();
	
	
	
	
	
	
	
	


}
