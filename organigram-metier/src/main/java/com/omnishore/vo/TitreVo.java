package com.omnishore.vo;

import java.util.ArrayList;
import java.util.Collection;

public class TitreVo {
	
	private int codeTitre;
	private String libelleTitre;
	private Collection<CollaborateurVo> collaborateurs = new ArrayList<CollaborateurVo>();
	
	
	public Collection<CollaborateurVo> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(Collection<CollaborateurVo> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	public int getCodeTitre() {
		return codeTitre;
	}
	public void setCodeTitre(int codeTitre) {
		this.codeTitre = codeTitre;
	}
	public String getLibelleTitre() {
		return libelleTitre;
	}
	public void setLibelleTitre(String libelleTitre) {
		this.libelleTitre = libelleTitre;
	}
	
	
	
}
