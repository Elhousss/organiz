package com.omnishore.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ResponsableVo extends CollaborateurVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -584512520687580111L;
	
	private EntiteVo entite;
	@Transient
	private AdminVo admin;
	@Transient
	private Collection<CollaborateurVo> collaborateurs = new ArrayList<CollaborateurVo>();
	@Transient
	private boolean editable;
	
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public EntiteVo getEntite() {
		return entite;
	}
	public void setEntite(EntiteVo entite) {
		this.entite = entite;
	}
	public AdminVo getAdmin() {
		return admin;
	}
	public void setAdmin(AdminVo admin) {
		this.admin = admin;
	}
	public Collection<CollaborateurVo> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(Collection<CollaborateurVo> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
}
