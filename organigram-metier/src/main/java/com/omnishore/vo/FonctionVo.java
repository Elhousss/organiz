package com.omnishore.vo;

import java.util.ArrayList;
import java.util.Collection;

public class FonctionVo {
	
	private int codeFonction;
	private String libelleFonction;
	private Collection<CollaborateurVo> collaborateurs = new ArrayList<CollaborateurVo>();
	
	
	
	public Collection<CollaborateurVo> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(Collection<CollaborateurVo> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	public int getCodeFonction() {
		return codeFonction;
	}
	public void setCodeFonction(int codeFonction) {
		this.codeFonction = codeFonction;
	}
	public String getLibelleFonction() {
		return libelleFonction;
	}
	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}
	
	
}
