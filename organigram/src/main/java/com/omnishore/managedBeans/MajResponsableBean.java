package com.omnishore.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.omnishore.dao.ResponsableDao;
import com.omnishore.dao.impl.ResponsableDaoImpl;
import com.omnishore.services.api.ICollaborateurService;
import com.omnishore.services.impl.CollaborateurServiceImpl;
import com.omnishore.vo.ResponsableVo;


@ManagedBean
@SessionScoped
public class MajResponsableBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1695627561477414200L;
	private List<ResponsableVo> responsablesList;
	

	private ResponsableVo responsable;
	
	private ICollaborateurService collaborateurService;
	
	
	
	@PostConstruct
	public void init(){
		collaborateurService = new CollaborateurServiceImpl();
		if (this.responsablesList == null) {
			responsablesList = collaborateurService.getCollaborateurs();
		}
		responsable = new ResponsableVo();
	}
	

	public ResponsableVo getResponsable() {
		return responsable;
	}
	
	public void setResponsable(ResponsableVo responsable) {
		this.responsable = responsable;
	}
	
	public List<ResponsableVo> getResponsablesList() {
		return responsablesList;
	}


	public void setResponsablesList(List<ResponsableVo> responsableList) {
		this.responsablesList = responsableList;
	}
	public String creerResponsable(){

		collaborateurService.enregistrerCollaborateur(responsable);
		return "MajResponsable?faces-redirect=true";
	}
	
	
	 public void onRowEdit(RowEditEvent event) {
	     try{
	    	 ResponsableVo responsable= (ResponsableVo) event.getObject();
	    	 
	    	 collaborateurService.modifierCollaborateur(responsable);
	     }
	     catch(Exception ex){
	    	 ex.printStackTrace();
	     }
		 FacesMessage msg = new FacesMessage("Responsable Modifié", ((ResponsableVo) event.getObject()).getNom()+"");
	     FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((ResponsableVo) event.getObject()).getNom()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public void deleteResponsable(int collaborateurId){
    	Session session = null;
		SessionFactory sessionFactory = null;
		System.out.println("l'id à supprimer est : "+collaborateurId);
		try{
			sessionFactory = (new Configuration()).configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			ResponsableVo responsable = collaborateurService.trouverCollaborateur(collaborateurId);
			if(responsable!=null){
				session.delete(responsable);
				System.out.println("Responsable "+responsable.getNom()+"supprimé");
				session.getTransaction().commit();
			}
			else{
				System.out.println("pas d'responsable avec l'id "+collaborateurId);
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			session.close();
			sessionFactory.close();
		}
    }
   
    public void canEdit(){
    	responsable.setEditable(true);
    }
    
    public void cannotEdit(){
    	responsable.setEditable(false);
    }
    
}
