package com.omnishore.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.omnishore.services.api.IEntityService;
import com.omnishore.services.impl.EntityServiceImpl;
import com.omnishore.vo.EntiteVo;

/**
 * @author stagiaire2
 *
 */
/**
 * @author stagiaire2
 *
 */
@ManagedBean
@RequestScoped
public class MajEntiteBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1695627561477414200L;
	private List<EntiteVo> listeEntites;
	private EntiteVo entite;
	private IEntityService entityService;
	
	
	
	@PostConstruct
	public void init(){
		entite = new EntiteVo();
		entityService = new EntityServiceImpl();
		if (this.listeEntites == null) {
			listeEntites = entityService.getEntites();
		}
	}
	
	public List<EntiteVo> getListeEntites() {
		return listeEntites;
	}

	public void setListeEntites(List<EntiteVo> listeEntites) {
		this.listeEntites = listeEntites;
	}

	public EntiteVo getEntite() {
		return entite;
	}
	
	public void setEntite(EntiteVo entite) {
		this.entite = entite;
	}
	
	
	
	/** Methode d'ajout de l'entite dans la base et dans la liste des entites
	 * @return String
	 */ 
	public String creerEntite(){
		entityService.enregistrerEntite(entite);
		return "MajEntite?faces-redirect=true";
			
	}
	
	 public String onRowEdit(RowEditEvent event) {
	     try{
	    	 EntiteVo entite= (EntiteVo) event.getObject();
	    	 
	    	 entityService.modifierEntite(entite.getIdEntite(), entite);
	     }
	     catch(Exception ex){
	    	 ex.printStackTrace();
	     }
		 FacesMessage msg = new FacesMessage("Entité Modifiée", ((EntiteVo) event.getObject()).getIdEntite()+"");
	     FacesContext.getCurrentInstance().addMessage(null, msg);
	     return "MajEntite?faces-redirect=true";

    }
	 
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((EntiteVo) event.getObject()).getIdEntite()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    
    public void supprimerEntite(EntiteVo entite){
    	entityService.supprimerEntite(entite.getIdEntite());
    	listeEntites.remove(entite);
    }
   
    public void canEdit(){
    	entite.setEditable(true);
    }
    
    public void cannotEdit(){
    	entite.setEditable(false);
    }
    
}
