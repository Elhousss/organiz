package com.omnishore.services.impl;

import java.util.HashMap;
import java.util.Map;

import com.omnishore.dao.impl.CompteDaoImpl;
import com.omnishore.entities.Compte;
import com.omnishore.services.api.IInscriptionService;
import com.omnishore.vo.CompteVo;

public class InscriptionServiceImpl implements IInscriptionService {

	public static final String REGEX = "[a-zA-Z0-9.-_]+[a-zA-Z0-9]+@[A-Za-z]+.[A-Za-z]{2,3}";
	private Map<String, String> erreurs = new HashMap<String, String>();

	
	
	@Override
	public boolean checkErreurs(CompteVo cmp) {

		boolean exist = false;

		checkEmail(cmp.getEmail());
		checkLength(cmp.getNom(), "nom");
		checkLength(cmp.getPrenom(), "prenom");
		checkLogin(cmp.getLogin());
		checkPass(cmp.getMotDePasse(), cmp.getConfirmationPWD());

		if (erreurs.isEmpty()) {
			checkExistence(cmp);
			if (erreurs.isEmpty()) {
				exist = true;
			}
		}

		return exist;

	}
	
	@Override
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	// METHODES DE VERIFICATION :

	private void checkLength(String str, String champ) {
		if (str != null && str.trim().length() != 0) {
			if (str.trim().length() < 3) {
				erreurs.put(champ,
						"Ce champ doit contenir au moins 3 caractères");
			}
		}
	}

	public void checkLogin(String login) {
		if (login != null && login.trim().length() != 0) {
			if (login.trim().length() < 4) {
				erreurs.put("login",
						"Le login doit contenir 4 caractères minimum!");
			}
		} else {
			erreurs.put("login", "Merci de saisir un login ! ");
		}
	}

	private void checkEmail(String email) {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches(REGEX)) {
				erreurs.put("email", "Merci de saisir une adresse mail valide");
			}
		} else {
			erreurs.put("email", "Merci de saisir une adresse mail");
		}
	}

	private void checkPass(String pass, String conf) {
		if (pass != null && pass.trim().length() != 0 && conf != null
				&& conf.trim().length() != 0) {
			if (!pass.equals(conf)) {
				erreurs.put("pass",
						"Le mot de passe et la confirmation doivent être identique !");

			}
		} else {
			erreurs.put("pass",
					"Merci de saisir un mot de passe et une confirmation");
		}
	}

	private void checkExistence(CompteVo cmp) {

		if (erreurs.isEmpty()) {
			CompteDaoImpl cdi = new CompteDaoImpl();
			if (cdi.trouverCompte(cmp.getLogin()) != null) {
				erreurs.put("login", "Un compte existe déja avec ce login");
			}
		}
	}

	@Override
	public void enregistrerCompte(CompteVo c) {
		// TODO Auto-generated method stub
		
	}

	

}
