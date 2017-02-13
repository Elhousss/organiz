package com.omnishore.services.impl;

import com.omnishore.dao.impl.CompteDaoImpl;
import com.omnishore.entities.Compte;
import com.omnishore.vo.CompteVo;

public class ConnexionServiceImpl {

	private String messageDeConnexion;

	public String getMessageDeConnexion() {
		return messageDeConnexion;
	}

	public void setMessageDeConnexion(String messageDeConnexion) {
		this.messageDeConnexion = messageDeConnexion;
	}

	public CompteVo connecterCompte(CompteVo compteVo) {
		String login = compteVo.getLogin();
		String pass = compteVo.getMotDePasse();
		Compte compte = null;
		CompteDaoImpl cdi = new CompteDaoImpl();
		if (cdi.verifierPass(login, pass)) {
			messageDeConnexion = "Vous êtes connecté !";
			compte = cdi.trouverCompte(login);
			return populateCompteVo(compte);
		} else {
			messageDeConnexion = "Login ou mot de passe invalide";
		}
		return null;
	}

	private CompteVo populateCompteVo(Compte compte) {
		
		return new CompteVo(compte.getLogin(), compte.getEmail(),
				compte.getMotDePasse(), compte.getNom(), compte.getPrenom(),
				null, null, compte.isEstAdmin(), compte.isEstResponsable());
	}
}
