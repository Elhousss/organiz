package com.omnishore.managedBeans;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.omnishore.dao.impl.CompteDaoImpl;
import com.omnishore.services.api.IInscriptionService;
import com.omnishore.services.impl.InscriptionServiceImpl;
import com.omnishore.vo.CompteVo;

@ManagedBean
@RequestScoped
public class InscriptionBean implements Serializable{
	
	private CompteVo compte;
	private Map<String,String> erreurs;
	private IInscriptionService inscriptionService;
	
//	private ServiceInscription
	
	@PostConstruct
	private void init() {
		inscriptionService = new InscriptionServiceImpl();
		compte = new CompteVo();
		erreurs = inscriptionService.getErreurs();
	}
	
	
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	
	public CompteVo getCompte() {
		return compte;
	}

	public void setCompte(CompteVo compte) {
		this.compte = compte;
	}
	
	public boolean creerCompte(){
		
		boolean checked = inscriptionService.checkErreurs(compte);
		if(checked){
			inscriptionService.enregistrerCompte(compte);
		}
		return checked;
	}
	
	public String combinedFunctions(){
		boolean sansErreur = creerCompte();
		if(sansErreur){
			return "Accueil";
		}
		return "Inscription1";
	}
	

   
}










