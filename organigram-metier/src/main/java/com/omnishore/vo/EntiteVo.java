package com.omnishore.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class EntiteVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9193828424545931894L;
	@Id
	private int idEntite;
	private String nom;
	private String description;
	@Transient
	private Collection<CollaborateurVo> collaborateurs = new ArrayList<CollaborateurVo>();
	@Transient
	private ResponsableVo responsable;
	@Transient
	private AdminVo admin;
	@Transient
	private EntiteVo entiteMere;
	@Transient
	private boolean editable;
	
	
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public EntiteVo getEntiteMere() {
		return entiteMere;
	}
	public void setEntiteMere(EntiteVo entiteMere) {
		this.entiteMere = entiteMere;
	}
	public Collection<CollaborateurVo> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(Collection<CollaborateurVo> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	public ResponsableVo getResponsable() {
		return responsable;
	}
	public void setResponsable(ResponsableVo responsable) {
		this.responsable = responsable;
	}
	public AdminVo getAdmin() {
		return admin;
	}
	public void setAdmin(AdminVo admin) {
		this.admin = admin;
	}
	public int getIdEntite() {
		return idEntite;
	}
	public void setIdEntite(int idEntite) {
		this.idEntite = idEntite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
