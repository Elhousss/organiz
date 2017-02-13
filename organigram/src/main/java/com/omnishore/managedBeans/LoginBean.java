package com.omnishore.managedBeans;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.omnishore.dao.impl.CompteDaoImpl;
import com.omnishore.vo.CompteVo;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	
	private CompteDaoImpl compteDaoImpl = new CompteDaoImpl();
	private CompteVo compte = new CompteVo();
	
	
	public CompteVo getCompte() {
		return compte;
	}
	public void setCompte(CompteVo compte) {
		this.compte = compte;
	}
	public CompteDaoImpl getCompteDaoImpl() {
		return compteDaoImpl;
	}
	public void setCompteDaoImpl(CompteDaoImpl compteDaoImpl) {
		this.compteDaoImpl = compteDaoImpl;
	}
	
	
	public String afficherPage(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String btnId = params.get("btnId");
		System.out.println(btnId);
		if(btnId.equals("connexion")){
			System.out.println("Le bouton cliqué est "+btnId);
			return "Accueil";
		}
		else{
			System.out.println("Le bouton cliqué est "+btnId);
			return "Inscription1";

		}
	}
	
	public boolean seConnecter(){
		if(compte.getLogin()!=null){
			if(compteDaoImpl.verifierPass(compte.getLogin(), compte.getMotDePasse())){
				
				HttpServletRequest req = (HttpServletRequest)(FacesContext.getCurrentInstance().getExternalContext().getRequest());
				HttpSession session = req.getSession();
				if(compteDaoImpl.estAdmin(compte.getLogin())){
					session.setAttribute("admin", "admin");	
					compte.setEstAdmin(true);
					System.out.println("estAdmin vaut "+compte.isEstAdmin());
				}
				System.out.println();
				return true;
			}
		}
		return false;

	}
	
	public void seDeconnecter(){
		HttpServletRequest req = (HttpServletRequest)(FacesContext.getCurrentInstance().getExternalContext().getRequest());
		HttpSession session = req.getSession();
		session.invalidate();
	}
}
